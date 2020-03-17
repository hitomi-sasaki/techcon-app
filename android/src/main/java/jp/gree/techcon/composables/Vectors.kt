package jp.gree.techcon.composables

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Container
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.vectorResource

@Composable
fun VectorImageButton(@DrawableRes id: Int, tint: Color = Color.Transparent, onClick: () -> Unit) {
    Ripple(bounded = false) {
        Clickable(onClick = onClick) {
            VectorImage(id, tint)
        }
    }
}

@Composable
fun VectorImage(@DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = vectorResource(id)
    Container(
        width = vector.defaultWidth,
        height = vector.defaultHeight
    ) {
        DrawVector(vector, tint)
    }
}
