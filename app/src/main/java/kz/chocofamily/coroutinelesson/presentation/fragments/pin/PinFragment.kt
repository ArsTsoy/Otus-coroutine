package kz.chocofamily.coroutinelesson.presentation.fragments.pin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_pin.*
import kz.chocofamily.coroutinelesson.R

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-28
 */

class PinFragment : Fragment() {

    private val args: PinFragmentArgs by navArgs()
    private val pinVM: CheckPinVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.isNavigatableBack) {
            btnBack.visibility = View.VISIBLE
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        } else {
            btnBack.visibility = View.GONE
        }


        btnExit.setOnClickListener {
            activity?.finish()
        }

        btnSuccessPin.setOnClickListener {
            pinVM.setResult(CheckPinVM.PinCheckState.Success)
            findNavController().popBackStack()
        }
    }

    override fun onDetach() {
        pinVM.setResult(null)
        super.onDetach()
    }

}