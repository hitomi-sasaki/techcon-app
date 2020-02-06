package jp.gree.techcon.sessionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import jp.gree.techcon.R
import jp.gree.techcon.common.usecase.SessionListService
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.common.AppBar
import jp.gree.techcon.observe

class SessionListFragment : Fragment() {
    private val vm = SessionListService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = getString(R.string.menu_session)

        val root = FrameLayout(requireContext())
        root.setContent {
            SessionListScreen(title, vm, this::onClick, this::onBookmark)
        }
        return root
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
fun SessionListScreen(
    title: String,
    viewState: SessionListService,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    val sessions = observe(viewState.sessions) ?: listOf()
    AppTheme {
        Column {
            AppBar(title = title)
            SessionList(sessions = sessions, onClick = onClick, onBookmark = onBookmark)
        }
    }
}
