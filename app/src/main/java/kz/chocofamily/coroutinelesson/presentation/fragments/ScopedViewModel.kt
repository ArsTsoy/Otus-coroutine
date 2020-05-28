package kz.chocofamily.coroutinelesson.presentation.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

open class ScopedViewModel : ViewModel() {

    private val job = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun t() {

    }

    override fun onCleared() {
        uiScope.coroutineContext.cancelChildren()
        super.onCleared()
    }

}