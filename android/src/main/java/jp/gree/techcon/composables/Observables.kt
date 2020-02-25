package jp.gree.techcon.composables

import androidx.compose.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import jp.gree.techcon.common.util.CFlow
import kotlinx.io.core.Closeable

@Composable
fun <T> observe(data: LiveData<T>): T? {
    var result by state { data.value }
    val observer = remember { Observer<T> { result = it } }

    onCommit(data) {
        data.observeForever(observer)
        onDispose { data.removeObserver(observer) }
    }

    return result
}

@Composable
fun <T> observe(data: CFlow<T>): T? {
    var result by state<T?> { null }
    val observer = remember { { it: T -> result = it } }

    onCommit(data) {
        val c = data.watch(observer)
        onDispose { c.close() }
    }

    return result
}
