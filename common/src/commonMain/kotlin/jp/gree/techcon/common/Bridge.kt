package jp.gree.techcon.common

import kotlinx.coroutines.CoroutineDispatcher

internal expect fun dispatcher(): CoroutineDispatcher
internal expect fun logDebug(message: String)
internal expect fun logError(message: String)
