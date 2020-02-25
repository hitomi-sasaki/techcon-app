package jp.gree.techcon.composables

import androidx.compose.Composable
import androidx.ui.layout.*
import androidx.ui.unit.Dp
import androidx.ui.unit.dp

@Composable
fun VerticalSpace(height: Dp) {
    Spacer(modifier = LayoutHeight(height = height))
}

@Composable
fun HorizontalSpace(width: Dp) {
    Spacer(modifier = LayoutWidth(width = width))
}

@Composable
fun ScreenColumn(children: @Composable() ColumnScope.() -> Unit) {
    Column(modifier = LayoutPadding(left = 16.dp, right = 16.dp, top = 24.dp, bottom = 24.dp), children = children)
}
