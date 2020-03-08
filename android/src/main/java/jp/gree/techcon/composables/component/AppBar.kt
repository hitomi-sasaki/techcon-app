package jp.gree.techcon.composables.component

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.TopAppBar
import jp.gree.techcon.R
import jp.gree.techcon.composables.VectorImageButton
import jp.gree.techcon.composables.appColors

@Composable
fun AppBar(title: String, onBackClick: (() -> Unit)? = null, onShareClick: (() -> Unit)? = null) {
    val backIcon: @Composable (() -> Unit)? =
        onBackClick?.let { { VectorImageButton(R.drawable.ic_back, onClick = it) } }
    if (onShareClick != null) {
        TopAppBar(
            title = { Text(title) },
            color = appColors.background,
            navigationIcon = backIcon,
            action = { VectorImageButton(R.drawable.ic_share, onClick = onShareClick) },
            actionData = listOf("hoge") // TODO: ?
        )
    } else {
        TopAppBar(
            title = { Text(title) },
            color = appColors.background,
            navigationIcon = backIcon
        )
    }
}
