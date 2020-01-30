package jp.gree.techcon.common.util

import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow

object GlobalEvent {
    // TODO: Create Error class instead of String if needed
    internal val error = BroadcastChannel<String>(Channel.CONFLATED)
    val onError = error.asFlow().wrap()
}
