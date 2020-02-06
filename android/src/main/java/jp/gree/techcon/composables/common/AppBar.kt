package jp.gree.techcon.composables.common

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.ColoredRect
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Surface
import androidx.ui.unit.dp
import jp.gree.techcon.composables.lightColors

@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = { Text(title) },
        color = lightColors.background
    )
}
