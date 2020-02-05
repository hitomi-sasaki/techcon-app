package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

val lightColors = lightColorPalette(
    background = Color(red = 255, green = 255, blue = 255),
    onBackground = Color(red = 33, green = 37, blue = 41)
)

/**
 * Note: Dark Theme support is not yet available, it will come in 2020. This is just an example of
 * using dark colors.
 */
val darkColors = darkColorPalette()

@Composable
fun AppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = lightColors, children = children)
}
