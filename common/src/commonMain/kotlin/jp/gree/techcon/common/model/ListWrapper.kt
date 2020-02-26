package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleList(val value: List<Article> = emptyList())

@Serializable
data class SessionList(val value: List<Session> = emptyList())

@Serializable
data class TrackList(val value: List<Track> = emptyList())
