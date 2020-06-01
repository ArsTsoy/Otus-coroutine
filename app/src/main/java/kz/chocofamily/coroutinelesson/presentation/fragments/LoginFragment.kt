package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.presentation.IntentVM
import kz.chocofamily.coroutinelesson.presentation.MainActivity
import kz.chocofamily.coroutinelesson.presentation.fragments.pin.CheckPinVM

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-27
 */

class LoginFragment : Fragment() {

    private val pinVM: CheckPinVM by activityViewModels()
    private val intentVM: IntentVM by activityViewModels()
    private val isAlreadyAuth: IsAlreadyAuth by activityViewModels()

    private var deeplink = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intentVM.getResult().observe(this.viewLifecycleOwner, Observer { intent ->
            intent?.let {
                deeplink = it.getStringExtra(DEEPLINK) ?: ""
            }
        })
        Log.i(
            "myLoginFragment",
            "isAlreadyAuth model : ${isAlreadyAuth.getInstantResult() ?: "null"}"
        )
        isAlreadyAuth.getResult().observe(this.viewLifecycleOwner, Observer {
            Log.i("myProfileFragment", "in Login was isAlreadyAuth: ${it ?: "false"}")
        })

        pinVM.getResult().observe(this.viewLifecycleOwner, Observer {
            when (it) {
                CheckPinVM.PinCheckState.Success -> {
                    isAlreadyAuth.setResult(IsAlreadyAuth.AuthState.Success)
                    Log.i(
                        "myLoginFragment",
                        "isAlreadyAuth model(After Success) : ${isAlreadyAuth.getInstantResult() ?: "null"}"
                    )
                    if (deeplink.isNotBlank()) {
                        val deepLinkBuilder = NavDeepLinkRequest.Builder
                            .fromUri(deeplink.toUri())
                            .build()
                        findNavController().navigate(deepLinkBuilder)
                        intentVM.setResult(null)
                    } else {
                        findNavController().navigate(R.id.action_global_menuFragment)
                    }
                }
                null -> {
//                    val direction = LoginFragmentDirections.actionGlobalPinFragment()
//                    findNavController().navigate(direction)
//                    (activity as MainActivity).navigateToPin()
                }
                else -> {
                    Toast.makeText(this.context, "Пожалуйста авторизуйтесь", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

        btnEnter.setOnClickListener {
            (activity as MainActivity).navigateToPin()
        }
    }

}