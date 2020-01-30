package jp.gree.techcon.common

import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher

internal expect fun dispatcher(): CoroutineDispatcher
internal expect fun logDebug(message: String)
internal expect fun logError(message: String)
internal expect fun driver(name: String?): SqlDriver

expect object Platform {
    internal val isIos: Boolean
    internal val localhost: String
}
