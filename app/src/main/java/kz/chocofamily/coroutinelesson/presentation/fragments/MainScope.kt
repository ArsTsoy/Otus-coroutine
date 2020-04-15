package kz.chocofamily.coroutinelesson.presentation.fragments

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

abstract class MainScope : CoroutineScope, LifecycleObserver {

    //Не уверен в таком способе, но мне он показался проще чем создавать Wrapper <- хотелось бы тут комментария от Вас
    abstract fun provideExceptionHandler(): CoroutineExceptionHandler

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + provideExceptionHandler()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun destroy() {
        coroutineContext.cancelChildren()
    }
}