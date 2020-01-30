package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: Long,
    val title: String,
    val description: String,
    val publishedAt: Long
) {
    companion object {
        fun getSample(id: Long): Article {
            return Article(id, "ニュースサンプル", "本本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文文", id)
        }

        fun getSamples(): List<Article> {
            return MutableList(10) { getSample(it.toLong()) }
        }
    }
}

