package jp.gree.techcon.sessiondetail

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.unit.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
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
                Spacer(modifier = LayoutHeight(24.dp))
                Header()
                Spacer(modifier = LayoutHeight(24.dp))
                Text(
                    text = session.title,
                    style = (MaterialTheme.typography()).h4.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = LayoutHeight(16.dp))
                Text(
                    text = "12月10日（木） 10:20 - 11:00",
                    style = (MaterialTheme.typography()).subtitle1
                )
                Spacer(modifier = LayoutHeight(32.dp))
                Text(
                    text = session.description,
                    style = (MaterialTheme.typography()).body1
                )
                Spacer(modifier = LayoutHeight(32.dp))
                Text(
                    text = "発表者",
                    style = (MaterialTheme.typography()).subtitle1
                )
                Spacer(modifier = LayoutHeight(16.dp))
                session.name.forEach { SpeakerItem(speaker = it) }
                Spacer(modifier = LayoutHeight(32.dp))
            }
        }
    }
}

@Composable
fun Header() {
    Row {
        Text("A-1")
        Text("／")
        Text("13:45 - 14:15")
    }
}

@Composable
fun SpeakerItem(speaker: Speaker) {
    Column {
        Row {
            Text(
                text = speaker.name,
                style = (MaterialTheme.typography()).body2
            )
            Spacer(modifier = LayoutWidth(8.dp))
            Text(
                text = speaker.title,
                style = (MaterialTheme.typography()).body2
            )
        }
        if (speaker.description.isNotBlank()) {
            Spacer(modifier = LayoutWidth(4.dp))
            Text(
                text = speaker.description,
                style = (MaterialTheme.typography()).body2
            )
        }
        FlexRow {
            flexible(1f) {
                Column {}
            }
            inflexible {
                VectorImageButton(id = R.drawable.ic_twitter) {  }
                Spacer(modifier = LayoutWidth(16.dp))
                VectorImageButton(id = R.drawable.ic_github) {}
            }
        }
    }
}
