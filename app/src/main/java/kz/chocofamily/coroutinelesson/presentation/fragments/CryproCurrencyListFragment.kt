package kz.chocofamily.coroutinelesson.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.chocofamily.coroutinelesson.R

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryproCurrencyListFragment : Fragment() {

    //region Overridden Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list_currency, container, false)


    //endregion


}