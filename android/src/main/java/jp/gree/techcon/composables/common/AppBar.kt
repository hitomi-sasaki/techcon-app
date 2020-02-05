package jp.gree.techcon.composables.common

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Padding
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import jp.gree.techcon.AppColor

@Composable
fun AppBar(title: String) {
    // TODO: Support edge to edge(status bar height)
    Padding(top = 24.dp) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = TextStyle(color = AppColor.onBackGround)
                )
            },
            color = AppColor.backGround
        )
    }
}
