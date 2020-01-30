package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.repository.SessionRepository

class SessionDetailUseCase(private val repository: SessionRepository) {
    fun get(sessionId: Long) = repository.getSession(sessionId)
    suspend fun updateBookmark(sessionId: Long, enable: Boolean) = repository.updateBookmark(sessionId, enable)
}
