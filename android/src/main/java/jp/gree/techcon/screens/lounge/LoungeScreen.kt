package jp.gree.techcon.screens.lounge

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutGravity
import androidx.ui.material.surface.Surface
import androidx.ui.unit.dp
import jp.gree.techcon.common.model.Booth
import jp.gree.techcon.composables.*

@Composable
fun Lounge(booths: List<Booth>) {
    VerticalScroller {
        ScreenColumn {
            Column {
                PrimaryText("ブースやフリーコーヒー、電源などを準備しています。休憩や、交流の場所としてご利用ください。", appTypography.body1)
                VerticalSpace(24.dp)
                Surface(color = Color(207, 207, 207)) {
                    Container(
                        modifier = LayoutGravity.Center,
                        height = 280.dp,
                        width = 300.dp,
                        alignment = Alignment.Center
                    ) {} // TODO: load image
                }
                booths.forEach { Booth(it) }
            }
        }
    }
}

@Composable
fun Booth(booth: Booth) {
    VerticalSpace(24.dp)
    PrimaryText(booth.title, appTypography.h6)
    VerticalSpace(16.dp)
    SecondaryText(booth.description, appTypography.body1)
}
