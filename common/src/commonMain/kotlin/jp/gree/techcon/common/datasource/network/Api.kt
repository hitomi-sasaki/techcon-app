package jp.gree.techcon.common.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.post
import jp.gree.techcon.common.Platform
import jp.gree.techcon.common.model.*
import kotlinx.serialization.list
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
internal object Api {
    private val endpoint = Platform.localhost // TODO: Use production URL for production build
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    // Read
    suspend fun getSession(id: Long): Session = client.get("$endpoint/session/$id")
    suspend fun getSessions(): List<Session> = client.get<SessionList>("$endpoint/sessions").value
    suspend fun getBookmarks(): List<Session> = client.get<SessionList>("$endpoint/bookmarks").value
    suspend fun getArticle(id: Long): Article = client.get("$endpoint/article/$id")
    suspend fun getArticles(): List<Article> = client.get<ArticleList>("$endpoint/articles").value

    // Update
    suspend fun postBookmark(sessionId: Long, enable: Boolean): Session = client.post("$endpoint/bookmark")
}

