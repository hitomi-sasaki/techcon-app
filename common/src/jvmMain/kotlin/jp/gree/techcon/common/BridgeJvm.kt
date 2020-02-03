package jp.gree.techcon.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual fun dispatcher(): CoroutineDispatcher = Dispatchers.Main
internal actual fun logDebug(message: String) = println(message)
internal actual fun logError(message: String) = println(message)

