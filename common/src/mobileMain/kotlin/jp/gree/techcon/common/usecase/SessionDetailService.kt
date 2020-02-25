package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.repository.SessionRepository
import jp.gree.techcon.common.util.wrap
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class SessionDetailService: KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val repository: SessionRepository by kodein.instance()
    fun get(sessionId: Long) = repository.getSession(sessionId).wrap()
    suspend fun updateBookmark(sessionId: Long, enable: Boolean) = repository.updateBookmark(sessionId, enable)
}
