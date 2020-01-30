package jp.gree.techcon

import androidx.compose.effectOf
import androidx.compose.memo
import androidx.compose.onCommit
import androidx.compose.state
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import jp.gree.techcon.common.util.CFlow

fun <T> observe(data: LiveData<T>) = effectOf<T?> {
    val result = +state<T?> { data.value }
    val observer = +memo { Observer<T> { result.value = it } }

    +onCommit(data) {
        data.observeForever(observer)
        onDispose { data.removeObserver(observer) }
    }

    result.value
}

fun <T> observe(data: CFlow<T>) = effectOf<T?> {
    val result = +state<T?> { null }
    val observer = +memo { { it: T -> result.value = it } }

    +onCommit(data) {
        val c = data.watch(observer)
        onDispose { c.close() }
    }

    result.value
}
