package jp.gree.techcon.common

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual fun dispatcher(): CoroutineDispatcher = Dispatchers.Main
internal actual fun logDebug(message: String) = println(message)
internal actual fun logError(message: String) = println(message)
internal actual fun driver(name: String?): SqlDriver = JdbcSqliteDriver("jdbc:sqlite:")

actual object Platform {
    internal actual val isIos: Boolean = false
    internal actual val localhost: String = "http://localhost:8080/"
}

