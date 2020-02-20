package jp.gree.techcon.common.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import jp.gree.techcon.common.AppState
import jp.gree.techcon.common.Platform
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.model.ArticleList
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.SessionList

class Api(private val appState: AppState) {
    private val endpoint = Platform.localhost // TODO: Use production URL for production build
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    private suspend inline fun <reified T> getWithAuth(url: String): T = client.get(url) {
        header("Authorization", "Bearer ${appState.token}")
    }

    private suspend inline fun <reified T> postWithAuth(url: String): T = client.get(url) {
        header("Authorization", "Bearer ${appState.token}")
    }

    // Read
    suspend fun getSession(id: Long): Session = client.get("$endpoint/session/$id")
    suspend fun getSessions(): List<Session> = client.get<SessionList>("$endpoint/sessions").value
    suspend fun getBookmarks(): List<Session> = getWithAuth<SessionList>("$endpoint/bookmarks").value
    suspend fun getArticle(id: Long): Article = client.get("$endpoint/article/$id")
    suspend fun getArticles(): List<Article> = client.get<ArticleList>("$endpoint/articles").value

    // Update
    suspend fun postBookmark(sessionId: Long, enable: Boolean): Session = postWithAuth("$endpoint/bookmark")
}

