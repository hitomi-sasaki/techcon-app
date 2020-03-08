package jp.gree.techcon.common.request

import kotlinx.serialization.Serializable

@Serializable
data class BookmarkParam(val sessionId: Long)
