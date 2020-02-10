package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Spacer
import androidx.ui.unit.Dp

@Composable
fun VerticalSpace(height: Dp) {
    Spacer(modifier = LayoutHeight(height = height))
}

@Composable
fun HorizontalSpace(width: Dp) {
    Spacer(modifier = LayoutWidth(width = width))
}
