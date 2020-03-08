package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.repository.SessionRepository
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.CoroutineScopeBuilder
import jp.gree.techcon.common.util.wrap
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

class SessionListService : KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val scope = CoroutineScopeBuilder().build()
    private val repository: SessionRepository by kodein.instance()
    val state: CFlow<SessionListState>

    init {
        state = get().wrap()
    }

    fun updateBookmark(sessionId: Long, enable: Boolean) {
        scope.launch {
            // TODO: replace scope
            repository.updateBookmark(sessionId, enable)
        }
    }

    private fun get(): Flow<SessionListState> {
        val sessionListItems : Flow<List<SessionListItem>> = getSessionListItems()
        sessionListItems.map {

        }
    }

    private fun getSessionListItems(): Flow<List<SessionListItem>> {
        val sessionList = repository.getSessions()
        val bookmarkList = repository.getBookmarks()
        return sessionList.combine(bookmarkList) { sessions, bookmarks ->
            val combinedList = mutableListOf<SessionListItem>()
            for (session in sessions) {
                val isBookmarked = bookmarks.find { it.id == session.id } != null
                combinedList.add(SessionListItem.build(session, isBookmarked))
            }
            return@combine combinedList
        }
    }

    private fun listToTrack(list: List<SessionListItem>): List<SessionListTrack> {
        list.groupBy { it.trackName }
    }
}
