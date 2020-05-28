package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.chocofamily.coroutinelesson.R

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-28
 */

class SomeFlowFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_some_flow, container, false)
    }


}