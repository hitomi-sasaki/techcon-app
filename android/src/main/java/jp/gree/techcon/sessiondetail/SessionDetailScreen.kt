package jp.gree.techcon.sessiondetail

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.withOpacity
import androidx.ui.text.font.FontWeight
import jp.gree.techcon.R
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.composables.VectorImageButton

@Composable
fun SessionDetail(session: Session) {
    VerticalScroller {
        Padding(left = 16.dp, right = 16.dp) {
            Column {
                HeightSpacer(height = 32.dp)
                Text(
                    text = session.title,
                    style = (+MaterialTheme.typography()).h4.withOpacity(0.87f).copy(fontWeight = FontWeight.Bold)
                )
                HeightSpacer(height = 16.dp)
                Text(
                    text = "12月10日（木） 10:20 - 11:00",
                    style = (+MaterialTheme.typography()).subtitle1.withOpacity(0.6f)
                )
                HeightSpacer(height = 32.dp)
                Text(
                    text = session.description,
                    style = (+MaterialTheme.typography()).body1.withOpacity(0.87f)
                )
                HeightSpacer(height = 32.dp)
                Text(
                    text = "発表者",
                    style = (+MaterialTheme.typography()).subtitle1.withOpacity(0.87f)
                )
                HeightSpacer(height = 16.dp)
                session.name.forEach { SpeakerItem(speaker = it) }
                HeightSpacer(height = 32.dp)
            }
        }
    }
}

@Composable
fun SpeakerItem(speaker: Speaker) {
    Column {
        Row {
            Text(
                text = speaker.name,
                style = (+MaterialTheme.typography()).body2.withOpacity(0.87f)
            )
            WidthSpacer(width = 8.dp)
            Text(
                text = speaker.title,
                style = (+MaterialTheme.typography()).body2.withOpacity(0.6f)
            )
        }
        if (speaker.description.isNotBlank()) {
            HeightSpacer(height = 4.dp)
            Text(
                text = speaker.description,
                style = (+MaterialTheme.typography()).body2.withOpacity(0.6f)
            )
        }
        FlexRow {
            flexible(1f) {
                Column(modifier = Expanded) {}
            }
            inflexible {
                VectorImageButton(id = R.drawable.ic_twitter) {  }
                WidthSpacer(width = 16.dp)
                VectorImageButton(id = R.drawable.ic_github) {}
            }
        }
    }
}
