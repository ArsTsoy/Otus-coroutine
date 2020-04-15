package kz.chocofamily.coroutinelesson.presentation.fragments

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class MainScope: CoroutineScope, LifecycleObserver {

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.i("myMainScope", "e: $throwable")
    }
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun destroy() {
        coroutineContext.cancelChildren()
    }
}