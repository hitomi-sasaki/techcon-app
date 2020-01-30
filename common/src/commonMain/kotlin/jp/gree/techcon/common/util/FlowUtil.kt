package jp.gree.techcon.common.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.io.core.Closeable

fun <T> Flow<T>.wrap(): CFlow<T> = CFlow(this)

class CFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val scope = CoroutineScopeBuilder().build()
        val job = scope.launch {
            collect {
                block(it)
            }
        }

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}
