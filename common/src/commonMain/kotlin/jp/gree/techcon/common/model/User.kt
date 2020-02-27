package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val firebaseUid: String,
    val bookmarks: List<Session>
)