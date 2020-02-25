package jp.gree.techcon.screens.sessionlist

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.ripple.Ripple
import jp.gree.techcon.R
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.composables.VectorImageButton

@Composable
fun SessionTabList(
    sessions: List<SessionListItem>,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    TabRow(
        items = listOf("aaa", "aaa", "bbb"),
        selectedIndex = 0
    ) { index, text ->
        Tab(
            text = text,
            selected = 0 == index,
            onSelected = { }
        )
    }
    Container {
        SessionList(sessions = sessions, onClick = onClick, onBookmark = onBookmark)
    }
}


@Composable
fun SessionList(
    sessions: List<SessionListItem>,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    VerticalScroller {
        Column {
            sessions.forEach {
                SessionListItem(it, { onClick(it) }, { onBookmark(it) })
            }
        }
    }
}

@Composable
fun SessionListItem(session: SessionListItem, onClick: () -> Unit, onBookmark: () -> Unit) {
    val bookmarkImage =
        if (session.isBookmarked) R.drawable.ic_bookmark else R.drawable.ic_bookmark_border
    Ripple(bounded = true) {
        Clickable(onClick = onClick) {
            Column {
                Text(
                    text = session.title,
                    style = (MaterialTheme.typography()).subtitle1
                )
                Text(
                    text = session.names,
                    style = (MaterialTheme.typography()).body2
                )
                VectorImageButton(id = bookmarkImage, onClick = onBookmark)
            }
        }
    }
}
