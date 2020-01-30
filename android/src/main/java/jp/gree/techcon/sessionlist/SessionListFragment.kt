package jp.gree.techcon.sessionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import jp.gree.techcon.common.usecase.SessionListService
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.observe

class SessionListFragment : Fragment() {
    private val vm = SessionListService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.setContent { Root(vm, this::onClick, this::onBookmark) }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun onClick(session: SessionListItem) {
        // findNavController().navigate(SessionListFragmentDirections.toArticle(1234))
        findNavController().navigate(SessionListFragmentDirections.toDetail(session.id))
    }

    private fun onBookmark(session: SessionListItem) {
        vm.updateBookmark(session.id, !session.isBookmarked) // TODO
    }
}

@Composable
fun Root(
    viewState: SessionListService,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    val sessions = +observe(viewState.sessions) ?: listOf()
    MaterialTheme {
        SessionList(sessions = sessions, onClick = onClick, onBookmark = onBookmark)
    }
}
