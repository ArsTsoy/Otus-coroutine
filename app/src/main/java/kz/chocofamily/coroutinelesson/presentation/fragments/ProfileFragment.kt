package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_profile.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.presentation.MainActivity
import kz.chocofamily.coroutinelesson.presentation.fragments.pin.PinFragmentArgs

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-28
 */

class ProfileFragment: Fragment() {

    private val isAlreadyAuth: IsAlreadyAuth by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPinSettings.setOnClickListener {
            val args = PinFragmentArgs.Builder().apply {
                isNavigatableBack = true
            }.build().toBundle()
            (activity as MainActivity).navigateToPin(args)
        }

        isAlreadyAuth.getResult().observe(this.viewLifecycleOwner, Observer {
            Log.i("myProfileFragment", "isAlreadyAuth: $it")
        })
    }
}