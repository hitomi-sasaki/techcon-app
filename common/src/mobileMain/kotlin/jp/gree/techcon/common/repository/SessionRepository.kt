package jp.gree.techcon.common.repository

import jp.gree.techcon.common.Platform
import jp.gree.techcon.common.datasource.db.SessionDao
import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.model.Session
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SessionRepository(private val dao: SessionDao, private val api: Api) {
    fun getSessions(): Flow<List<Session>> = channelFlow {
        // TODO: Remove this workaround after supporting iOS multithread
        if (Platform.isIos) {
            send(dao.loadSessionsWorkaroundForIos())
            val sessions = api.getSessions()
            dao.save(sessions)
            send(sessions)
            return@channelFlow
        }

        launch {
            dao.loadSessions().collect { send(it) }
        }
        val sessions = api.getSessions()
        dao.save(sessions)
    }

    fun getSession(id: Long): Flow<Session> = flow { emit(api.getSession(id)) }
    fun getBookmarks(): Flow<List<Session>> = flow { emit(api.getBookmarks()) }

    suspend fun updateBookmark(sessionId: Long, enable: Boolean) {
        if (enable) {
            api.addBookmark(sessionId)
        } else {
            api.removeBookmark(sessionId)
        }
    }
}
