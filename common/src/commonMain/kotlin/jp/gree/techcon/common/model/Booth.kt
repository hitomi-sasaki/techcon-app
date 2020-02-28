package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Booth(
    val id: Long,
    val title: String,
    val description: String
)
