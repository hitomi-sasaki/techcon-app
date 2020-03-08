package jp.gree.techcon.screens.sessionlist

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.unit.dp
import jp.gree.techcon.R
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.common.viewstate.SessionListItem
import jp.gree.techcon.composables.*

@Composable
fun SessionTabList(
    sessions: List<SessionListItem>,
    onClick: (session: SessionListItem) -> Unit,
    onBookmark: (session: SessionListItem) -> Unit
) {
    val sectionTitles = Sections.values().map { it.title }
    var section by state { Sections.Left }
    TabRow(
        items = sectionTitles,
        selectedIndex = section.ordinal,
        color = appColors.background
    ) { index, text ->
        Tab(
            text = text,
            selected = section.ordinal == index,
            onSelected = { section = Sections.values()[index] }
        )
    }
    Surface(color = Color(247, 247, 247)) {
        SessionList(sessions = sessions, onClick = onClick, onBookmark = onBookmark)
    }
}

private enum class Sections(val title: String) {
    Left("Aトラック"),
    Center("Bトラック"),
    Right("ショートトラック")
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
    Column(modifier = LayoutPadding(16.dp)) {
        PrimaryText(session.dateText, appTypography.h6)
        VerticalSpace(8.dp)
        SessionCard(session = session, onClick = onClick, onBookmark = onBookmark)
    }
}

@Composable
fun SessionCard(session: SessionListItem, onClick: () -> Unit, onBookmark: () -> Unit) {
    Ripple(bounded = true) {
        Clickable(onClick = onClick) {
            Card(shape = RoundedCornerShape(4.dp), color = appColors.background) {
                Column(modifier = LayoutWidth.Fill + LayoutPadding(16.dp)) {
                    CardHeader(session, onBookmark)
                    VerticalSpace(8.dp)
                    PrimaryText(session.title, appTypography.subtitle1)
                    VerticalSpace(16.dp)
                    SecondaryText(session.tags, appTypography.body1)
                    VerticalSpace(16.dp)
                    SpeakerItem(session.speaker)
                }
            }
        }
    }
}

@Composable
fun SpeakerItem(speaker: Speaker) {
    Row {
        Surface(color = Color(207, 207, 207)) {
            Container(height = 48.dp, width = 48.dp) {} // TODO: load image
        }
        HorizontalSpace(16.dp)
        Column(modifier = LayoutHeight.Min(48.dp), arrangement = Arrangement.Center) {
            PrimaryText(speaker.name, appTypography.body1)
            VerticalSpace(8.dp)
            SecondaryText(speaker.title, appTypography.caption)
        }
    }
}

@Composable
fun CardHeader(session: SessionListItem, onBookmark: () -> Unit) {
    val bookmarkImage =
        if (session.isBookmarked) R.drawable.ic_bookmark_on else R.drawable.ic_bookmark_off
    Stack(modifier = LayoutWidth.Fill) {
        PrimaryText(session.trackName, appTypography.subtitle2, modifier = LayoutGravity.CenterLeft)
        Container(modifier = LayoutGravity.CenterRight) {
            VectorImageButton(id = bookmarkImage, onClick = onBookmark)
        }
    }
}
