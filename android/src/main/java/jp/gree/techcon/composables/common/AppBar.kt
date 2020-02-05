package jp.gree.techcon.composables.common

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Padding
import androidx.ui.material.TopAppBar
import androidx.ui.unit.dp
import jp.gree.techcon.composables.lightColors

@Composable
fun AppBar(title: String) {
    // TODO: Support edge to edge(status bar height)
    Padding(top = 24.dp) {
        TopAppBar(
            title = { Text(title) },
            color = lightColors.background
        )
    }
}
