package jp.gree.techcon.screens.sessiondetail

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.OutlinedButton
import androidx.ui.material.surface.Surface
import androidx.ui.unit.dp
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.composables.*

@Composable
fun SessionDetail(session: Session?) {
    if (session == null) {
        Column {}
        return
    }
    VerticalScroller {
        ScreenColumn {
            Column {
                Header()
                VerticalSpace(16.dp)
                PrimaryText(session.title, appTypography.h4)
                VerticalSpace(16.dp)
                SecondaryText(
                    session.tagList.map { "#${it}" }.joinToString(" "),
                    appTypography.body1
                )
                VerticalSpace(24.dp)
                SecondaryText(session.description, appTypography.body1)
                VerticalSpace(24.dp)
                // session.name.forEach { SpeakerItem(speaker = it) }
                VerticalSpace(24.dp)
                Row(modifier = LayoutWidth.Fill, arrangement = Arrangement.Center) {
                    // OutlinedButton { Text("スケジュールに追加") } // TODO: ImageButton
                }
            }
        }
    }
}

@Composable
fun Header() {
    Row {
        PrimaryText("A-1", appTypography.h6)
        SecondaryText(" / ", appTypography.h6)
        PrimaryText("13:45 - 14:15", appTypography.h6)
    }
}

@Composable
fun SpeakerItem(speaker: Speaker) {
    Surface(color = Color(247, 247, 247)) {
        Column(modifier = LayoutWidth.Fill) {
            Column(modifier = LayoutPadding(24.dp)) {
                SpeakerAvatarAndNames(speaker)
                VerticalSpace(16.dp)
                PrimaryText(speaker.description, appTypography.caption)

            }
        }
    }
}

@Composable
fun SpeakerAvatarAndNames(speaker: Speaker) {
    Row {
        Surface(color = Color(207, 207, 207)) {
            Container(height = 64.dp, width = 64.dp) {} // TODO: load image
        }
        HorizontalSpace(16.dp)
        Column(modifier = LayoutHeight.Min(64.dp), arrangement = Arrangement.Center) {
            PrimaryText(speaker.name, appTypography.subtitle1)
            VerticalSpace(8.dp)
            SecondaryText(speaker.title, appTypography.caption)
        }
    }
}
