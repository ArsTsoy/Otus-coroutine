package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import kz.chocofamily.coroutinelesson.R

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-27
 */

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNextInMain.setOnClickListener {
            val direction = MainFragmentDirections.actionMainFragment2ToProfileFragment()
            findNavController().navigate(direction)
        }
    }

}