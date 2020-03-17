package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.sp

val appColors = lightColorPalette(
    background = Color(red = 255, green = 255, blue = 255),
    surface = Color(red = 230, green = 230, blue = 230),
    primary = Color(red = 224, green = 62, blue = 99),
    secondary = Color(red = 0, green = 159, blue = 175),
    secondaryVariant = Color(red = 250, green = 174, blue = 60),
    onBackground = Color(red = 33, green = 37, blue = 41)
)

val appTypography = Typography(
    h4 = TextStyle(
        color = appColors.onBackground,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        color = appColors.onBackground,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h6 = TextStyle(
        color = appColors.onBackground,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        color = appColors.onBackground,
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        color = appColors.onBackground,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        color = appColors.onBackground,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        color = Color.Red,
        fontSize = 20.sp
    ),
    button = TextStyle(
        color = appColors.onBackground,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        color = appColors.onBackground,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        color = Color.Red,
        fontSize = 20.sp
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
