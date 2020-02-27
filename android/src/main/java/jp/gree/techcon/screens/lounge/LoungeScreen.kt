package jp.gree.techcon.screens.lounge

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.surface.Surface
import androidx.ui.unit.dp
import jp.gree.techcon.composables.*

@Composable
fun Lounge() {
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
                Booth()
                Booth()
                Booth()
                Booth()
            }
        }
    }
}

@Composable
fun Booth() {
    VerticalSpace(24.dp)
    PrimaryText("Make部", appTypography.h6)
    VerticalSpace(16.dp)
    SecondaryText("非公式の部活です。3Dプリンタで作った作品を展示しています。", appTypography.body1)
}
