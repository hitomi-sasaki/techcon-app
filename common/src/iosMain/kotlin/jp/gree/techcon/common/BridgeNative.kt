package jp.gree.techcon.common

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.ios.NativeSqliteDriver
import kotlinx.coroutines.*
import platform.darwin.*
import kotlin.coroutines.CoroutineContext
import jp.gree.techcon.common.model.*
import jp.gree.techcon.common.viewstate.*

val Session.descriptionText: String get() = description
val Speaker.descriptionText: String get() = description
val ArticleListItem.descriptionText: String get() = description
val Booth.descriptionText: String get() = description

internal actual fun dispatcher(): CoroutineDispatcher = UI
internal actual fun logDebug(message: String) = println(message)
internal actual fun logError(message: String) = println(message)
internal actual fun driver(name: String?): SqlDriver =
        NativeSqliteDriver(AppDatabase.Schema, name ?: "app.db")

actual object Platform {
    internal actual val isIos: Boolean = true
    internal actual val localhost: String = "http://localhost:8080"
}

@UseExperimental(InternalCoroutinesApi::class)
private object UI : CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        val queue = dispatch_get_main_queue()
        dispatch_async(queue) {
            block.run()
        }
    }

    override fun scheduleResumeAfterDelay(
            timeMillis: Long,
            continuation: CancellableContinuation<Unit>
    ) {
        val queue = dispatch_get_main_queue()

        val time = dispatch_time(DISPATCH_TIME_NOW, (timeMillis * NSEC_PER_MSEC.toLong()))
        dispatch_after(time, queue) {
            with(continuation) {
                resumeUndispatched(Unit)
            }
        }
    }
}
