package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.presentation.IntentVM

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-27
 */

class MenuFragment : Fragment() {

//    private val intentVM: IntentVM by activityViewModels()
//    private val isAlreadyAuth: IsAlreadyAuth by activityViewModels()

//    private var deeplink = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        intentVM.getResult().observe(this.viewLifecycleOwner, Observer { intent ->
//            intent?.let {
//                deeplink = it.getStringExtra(DEEPLINK) ?: ""
//                Log.i("myMenuFragment", "deeplink = $deeplink")
//            }
//        })
//        if (deeplink.isNotBlank()) {
//            val deepLinkBuilder = NavDeepLinkRequest.Builder
//                .fromUri(deeplink.toUri())
//                .build()
//            findNavController().navigate(deepLinkBuilder)
//            intentVM.setResult(null)
//        }
        btnNext.setOnClickListener {
            val direction = MenuFragmentDirections.actionMenuFragmentToSomeFlowFragment()
            findNavController().navigate(direction)
        }
    }


}