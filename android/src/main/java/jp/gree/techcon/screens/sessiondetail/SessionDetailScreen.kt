package jp.gree.techcon.screens.sessiondetail

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.background
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.unit.dp
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.composables.*

@Composable
fun SessionDetail(session: Session) {
    VerticalScroller {
        Padding(left = 16.dp, right = 16.dp, top = 24.dp, bottom = 24.dp) {
            Column {
                Header()
                VerticalSpace(16.dp)
                PrimaryText(session.title, appTypography.h4)
                VerticalSpace(16.dp)
                SecondaryText(session.tagList.map { "#${it}" }.joinToString(" "), appTypography.body1)
                VerticalSpace(24.dp)
                PrimaryText(session.description, appTypography.body1)
                VerticalSpace(24.dp)
                session.name.forEach { SpeakerItem(speaker = it) }
                VerticalSpace(24.dp)
                Row(modifier = LayoutWidth.Fill, arrangement = Arrangement.Center) {
                    Button("スケジュールに追加", style = OutlinedButtonStyle()) // TODO: ImageButton
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
    Column(
        modifier = background(Color(247, 247, 247)) + LayoutWidth.Fill
    ) {
        Padding(padding = 24.dp) {
            Column {
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
        Container(
            modifier = background(Color(207, 207, 207)),
            height = 64.dp,
            width = 64.dp
        ) {} // TODO: load image
        HorizontalSpace(16.dp)
        Column(modifier = LayoutHeight.Min(64.dp), arrangement = Arrangement.Center) {
            PrimaryText(speaker.name, appTypography.subtitle1)
            VerticalSpace(8.dp)
            SecondaryText(speaker.title, appTypography.caption)
        }
    }
}
