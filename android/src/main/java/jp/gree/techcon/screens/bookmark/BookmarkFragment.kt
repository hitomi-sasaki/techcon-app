package jp.gree.techcon.screens.bookmark

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
import jp.gree.techcon.common.usecase.BookmarkService
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.viewstate.BookmarkState
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.component.AppBar
import jp.gree.techcon.composables.observe
import jp.gree.techcon.screens.sessionlist.SessionList

class BookmarkFragment : Fragment() {
    private val service by lazy { BookmarkService() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = getString(R.string.menu_bookmark)

        val root = FrameLayout(requireContext())
        root.setContent {
            BookmarkScreen(title, service.state, this::onClick, this::onBookmark)
        }
        return root
    }

    private fun onClick(session: SessionListItem) {
        findNavController().navigate(BookmarkFragmentDirections.toDetail(session.id))
    }

    private fun onBookmark(session: SessionListItem) {
        service.updateBookmark(session.id, !session.isBookmarked) // TODO
    }
}

@Composable
fun BookmarkScreen(
    title: String,
    viewState: CFlow<BookmarkState>,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    val sessions = observe(viewState)?.sessions ?: listOf()
    AppTheme {
        Column {
            AppBar(title = title)
            SessionList(sessions = sessions, onClick = onClick, onBookmark = onBookmark)
        }
    }
}
