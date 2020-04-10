package kz.chocofamily.coroutinelesson.presentation.fragments.crypto_currencies_list_with_vm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_currency.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.chocofamily.coroutinelesson.data.repositories.BaseRepository
import kz.chocofamily.coroutinelesson.presentation.controllers.adapters.CryptoCurrencyRVAdapter

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryptoCurrencyListFragment2 : Fragment() {

    //region Vars
    private val repository = BaseRepository()
    private val adapter = CryptoCurrencyRVAdapter()
    protected var viewModel: CryptoCurrencyViewModel? = null
    //endregion

    //region Overridden Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CryptoCurrencyViewModel::class.java)
    }

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
        viewModel?.let {
            it.data.observe(this.viewLifecycleOwner, Observer {
                showList(it)
            })
        }
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