package jp.gree.techcon.common.datasource.network

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import jp.gree.techcon.common.AppState
import jp.gree.techcon.common.Platform
import jp.gree.techcon.common.model.*
import jp.gree.techcon.common.request.BookmarkParam

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

    private suspend inline fun <reified T> postWithAuth(url: String, param: Any): T = client.post(url) {
        header("Authorization", "Bearer ${appState.token}")
        contentType(ContentType.Application.Json)
        body = param
    }

    private suspend inline fun <reified T> deleteWithAuth(url: String, param: Any): T = client.delete(url) {
        header("Authorization", "Bearer ${appState.token}")
        contentType(ContentType.Application.Json)
        body = param
    }

    // Read
    suspend fun getSession(id: Long): Session = client.get("$endpoint/session/$id")
    // TODO remove this
    suspend fun getSessions(): List<Session> = client.get<SessionList>("$endpoint/sessions").value
    suspend fun getTracks(): List<Track> = client.get<TrackList>("$endpoint/tracks").value
    suspend fun getBookmarks(): List<Session> = getWithAuth<SessionList>("$endpoint/bookmarks").value
    suspend fun getArticle(id: Long): Article = client.get("$endpoint/article/$id")
    suspend fun getArticles(): List<Article> = client.get<ArticleList>("$endpoint/articles").value
    suspend fun getBooths(): List<Booth> = client.get<BoothList>("$endpoint/booths").value

    // Update
    suspend fun addBookmark(sessionId: Long): Unit = postWithAuth("$endpoint/bookmark", BookmarkParam(sessionId))

    // Delete
    suspend fun removeBookmark(sessionId: Long): Unit = deleteWithAuth("$endpoint/bookmark", BookmarkParam(sessionId))
}

