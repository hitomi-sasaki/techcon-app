package jp.gree.techcon.sessionlist

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp
import jp.gree.techcon.R
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.composables.VectorImageButton

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
            Padding(16.dp) {
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
}
