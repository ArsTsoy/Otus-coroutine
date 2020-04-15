package kz.chocofamily.coroutinelesson.presentation.fragments.crypto_currency_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_currency.*
import kotlinx.coroutines.CoroutineExceptionHandler
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

//TODO: добавить ExceptionHandler

class CryptoCurrencyListFragment : Fragment() {

    //region Vars
    private val repository = BaseRepository()
    private val uiScope =
        object : kz.chocofamily.coroutinelesson.presentation.fragments.MainScope() {
            override fun provideExceptionHandler(): CoroutineExceptionHandler {
                return CoroutineExceptionHandler { coroutineContext, throwable ->
                    Toast.makeText(
                        this@CryptoCurrencyListFragment.context,
                        "Error handled: $throwable",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    private val adapter = CryptoCurrencyRVAdapter()
    //endregion

    //region Overridden Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(uiScope)
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
        uiScope.launch {
            val res = withContext(Dispatchers.IO) {
                repository.getCryptoCurrencyList(1)
            }
            showList(res)
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