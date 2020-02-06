package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle

@Composable
fun PrimaryText(text: String, style: TextStyle? = null) {
    Text(
        text = text,
        style = style?.copy(color = MaterialTheme.emphasisLevels().high.emphasize(style.color!!))
    )
}

@Composable
fun SecondaryText(text: String, style: TextStyle? = null) {
    Text(
        text = text,
        style = style?.copy(color = MaterialTheme.emphasisLevels().medium.emphasize(style.color!!))
    )
}
