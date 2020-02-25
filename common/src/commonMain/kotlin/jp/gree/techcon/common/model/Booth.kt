package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
class Booth(
    val id: Long,
    val title: String,
    val description: String
)
