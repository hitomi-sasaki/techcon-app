package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.repository.SessionRepository
import jp.gree.techcon.common.repository.TrackRepository
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.CoroutineScopeBuilder
import jp.gree.techcon.common.util.wrap
import jp.gree.techcon.common.viewstate.BookmarkState
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.common.viewstate.SessionListState
import jp.gree.techcon.common.viewstate.SessionListTrack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class BookmarkService : KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val scope = CoroutineScopeBuilder().build() // TODO inject
    private val repository: SessionRepository by kodein.instance()
    val state: CFlow<BookmarkState>

    init {
        state = get().wrap()
    }

    fun updateBookmark(sessionId: Long, enable: Boolean) {
        scope.launch {
            // TODO: replace scope
            repository.updateBookmark(sessionId, enable)
        }
    }

    private fun get(): Flow<BookmarkState> {
        val sessions = repository.getBookmarks()
        return sessions.map { BookmarkState(convert(it)) }
    }

    // TODO naming
    private fun convert(sessions: List<Session>): List<SessionListItem> =
        sessions.map { SessionListItem.build(it, true) }
}
