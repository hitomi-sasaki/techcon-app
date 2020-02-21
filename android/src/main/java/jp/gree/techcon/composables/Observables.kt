package jp.gree.techcon.composables

import androidx.compose.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import jp.gree.techcon.common.util.CFlow

@Composable
fun <T> observe(data: LiveData<T>): T? {
    val result = state<T?> { data.value }
    val observer = remember { Observer<T> { result.value = it } }

    onCommit(data) {
        data.observeForever(observer)
        onDispose { data.removeObserver(observer) }
    }

    return result.value
}

@Composable
fun <T> observe(data: CFlow<T>): T? {
    val result = state<T?> { null }
    val observer = remember { { it: T -> result.value = it } }

    onCommit(data) {
        val c = data.watch(observer)
        onDispose { c.close() }
    }

    return result.value
}
