package jp.gree.techcon.articledetail

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.withOpacity
import androidx.ui.text.font.FontWeight
import jp.gree.techcon.common.model.Article

@Composable
fun ArticleDetail(article: Article) {
    VerticalScroller {
        Padding(left = 16.dp, right = 16.dp) {
            Column {
                HeightSpacer(height = 32.dp)
                Text(
                    text = article.title,
                    style = (+MaterialTheme.typography()).h4.withOpacity(0.87f).copy(fontWeight = FontWeight.Bold)
                )
                HeightSpacer(height = 16.dp)
                Text(
                    text = "12月10日（木） 10:20 - 11:00",
                    style = (+MaterialTheme.typography()).subtitle1.withOpacity(0.6f)
                )
                HeightSpacer(height = 32.dp)
                Text(
                    text = article.description,
                    style = (+MaterialTheme.typography()).body1.withOpacity(0.87f)
                )
                HeightSpacer(height = 32.dp)
            }
        }
    }
}
