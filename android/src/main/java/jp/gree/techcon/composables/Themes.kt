package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette
import androidx.ui.text.TextStyle
import androidx.ui.unit.sp

val appColors = lightColorPalette(
    background = Color(red = 255, green = 255, blue = 255),
    onBackground = Color(red = 33, green = 37, blue = 41)
)

val appTypography = Typography(
    h4 = TextStyle(
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontSize = 12.sp
    )
)

/**
 * Note: Dark Theme support is not yet available, it will come in 2020. This is just an example of
 * using dark colors.
 */
val darkColors = darkColorPalette()

@Composable
fun AppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = appColors, typography = appTypography, children = children)
}
