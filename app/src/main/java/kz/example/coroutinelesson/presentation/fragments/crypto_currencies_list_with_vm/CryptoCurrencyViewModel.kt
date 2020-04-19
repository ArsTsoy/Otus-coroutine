package kz.example.coroutinelesson.presentation.fragments.crypto_currencies_list_with_vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kz.example.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.example.coroutinelesson.data.repositories.BaseRepository
import kz.example.coroutinelesson.presentation.fragments.ScopedViewModel

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