package jp.gree.techcon.articledetail

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.unit.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.text.font.FontWeight
import jp.gree.techcon.common.model.Article

@Composable
fun ArticleDetail(article: Article) {
    VerticalScroller {
        Padding(left = 16.dp, right = 16.dp) {
            Column {
                Spacer(modifier = LayoutHeight(32.dp))
                Text(
                    text = article.title,
                    style = (MaterialTheme.typography()).h4.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = LayoutHeight(16.dp))
                Text(
                    text = "12月10日（木） 10:20 - 11:00",
                    style = (MaterialTheme.typography()).subtitle1
                )
                Spacer(modifier = LayoutHeight(32.dp))
                Text(
                    text = article.description,
                    style = (MaterialTheme.typography()).body1
                )
                Spacer(modifier = LayoutHeight(32.dp))
            }
        }
    }
}
