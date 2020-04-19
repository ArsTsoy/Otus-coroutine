package kz.example.coroutinelesson.presentation.fragments.crypto_currencies_list_with_vm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_currency.*
import kz.example.coroutinelesson.R
import kz.example.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.example.coroutinelesson.presentation.controllers.adapters.CryptoCurrencyRVAdapter

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryptoCurrencyListFragment2 : Fragment() {

    //region Vars
    private val adapter = CryptoCurrencyRVAdapter()
    private val viewModel: CryptoCurrencyViewModel by lazy {
        ViewModelProviders.of(this).get(CryptoCurrencyViewModel::class.java)
    }
    //endregion

    //region Overridden Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list_currency, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        loadData()
    }
    //endregion

    //region Support
    private fun loadData() {
        showLoading()
        viewModel.loadData().observe(this.viewLifecycleOwner, Observer {
            showList(it)
        })
        viewModel.exceptionHandler.observe(this.viewLifecycleOwner, Observer {
            Toast.makeText(this.context, "Error handled: $it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    private fun showList(listCryptoCurrencies: List<CryptoCurrencyModel>) {
        adapter.refreshCryptoCurrencies(listCryptoCurrencies)
        hideLoading()
    }

    private fun setupRV() {
        rvCurrencies.layoutManager = LinearLayoutManager(this.context)
        rvCurrencies.adapter = adapter
    }
    //endregion


}