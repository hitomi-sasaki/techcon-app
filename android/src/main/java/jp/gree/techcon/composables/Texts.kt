package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle

@Composable
fun PrimaryText(text: String, style: TextStyle? = null, modifier: Modifier = Modifier.None) {
    Text(
        text = text,
        style = style?.copy(color = MaterialTheme.emphasisLevels().high.emphasize(style.color!!)),
        modifier = modifier
    )
}

@Composable
fun SecondaryText(text: String, style: TextStyle? = null, modifier: Modifier = Modifier.None) {
    Text(
        text = text,
        style = style?.copy(color = MaterialTheme.emphasisLevels().medium.emphasize(style.color!!)),
        modifier = modifier
    )
}
