package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Track(
    val id: Long,
    val trackName: String,
    val sessions: List<Session>
)
