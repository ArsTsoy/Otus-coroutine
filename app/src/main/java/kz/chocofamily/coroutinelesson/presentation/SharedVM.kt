package kz.chocofamily.coroutinelesson.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-28
 */

abstract class SharedVM<T> : ViewModel() {

    protected val resultLiveData: MutableLiveData<T> = MutableLiveData()

    //TODO: это антипаттерн для MVVM
    fun setResult(result: T?) {
        resultLiveData.value = result
    }

    fun getResult(): LiveData<T> {
        return resultLiveData
    }

    fun getInstantResult(): T? {
        return resultLiveData.value
    }

    override fun onCleared() {
        setResult(null)
        super.onCleared()
    }
}