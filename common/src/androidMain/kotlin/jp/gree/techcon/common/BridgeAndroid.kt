package jp.gree.techcon.common

import android.content.Context
import android.util.Log
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

lateinit var context: Context

// TOOD: disable logging for release build
internal actual fun dispatcher(): CoroutineDispatcher = Dispatchers.Main
internal actual fun logDebug(message: String) = Unit.also { Log.d("common-log", message) }
internal actual fun logError(message: String) = Unit.also { Log.e("common-log", message) }
internal actual fun driver(name: String?): SqlDriver = AndroidSqliteDriver(AppDatabase.Schema, context, name)

actual object Platform {
    internal actual val isIos: Boolean = false
    internal actual val localhost: String = "http://10.0.2.2:8080"
}

