package kz.chocofamily.coroutinelesson.presentation.fragments.crypto_currencies_list_with_vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kz.chocofamily.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.chocofamily.coroutinelesson.data.repositories.BaseRepository
import kz.chocofamily.coroutinelesson.presentation.fragments.ScopedViewModel

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryptoCurrencyViewModel: ScopedViewModel() {

    private val repository: BaseRepository = BaseRepository()

    val data: LiveData<List<CryptoCurrencyModel>> = liveData {
        val retrievedData = repository.getCryptoCurrencyList()
        emit(retrievedData)
    }

    val exceptionHandler = MutableLiveData<Throwable>()

    fun loadData()= liveData {
        try{
            val retrievedData = repository.getCryptoCurrencyList()
            emit(retrievedData)
        } catch (e: Throwable) {
            exceptionHandler.value = e
        }

    }
}