package jp.gree.techcon.common.util

import jp.gree.techcon.common.dispatcher
import jp.gree.techcon.common.logError
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

internal class CoroutineScopeBuilder {
    fun build(): CoroutineScope {
        val exceptionHandler = CoroutineExceptionHandler(::onException)
        val job = SupervisorJob()
        return CoroutineScope(dispatcher() + job + exceptionHandler)
    }

    private fun onException(context: CoroutineContext, throwable: Throwable) {
        // TODO: supervisorJob?
        CoroutineScope(context + SupervisorJob()).launch {
            logError(throwable.toString())
            GlobalEvent.error.send(throwable.toString())
        }
    }
}
