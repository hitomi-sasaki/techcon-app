package jp.gree.techcon.articlelist

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Expanded
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.withOpacity
import jp.gree.techcon.common.model.Article

@Composable
fun ArticleList(articles: List<Article>) {
    VerticalScroller {
        Column {
            articles.forEach {
                ArticleListItem(it)
            }
        }
    }
}

@Composable
fun ArticleListItem(article: Article) {
    Ripple(bounded = true) {
        Clickable(onClick = {}) {
            Padding(16.dp) {
                Column(modifier = Expanded) {
                    Text(
                        text = article.title,
                        style = (+MaterialTheme.typography()).subtitle1.withOpacity(0.87f)
                    )
                    Text(
                        text = article.description,
                        style = (+MaterialTheme.typography()).body2.withOpacity(0.6f)
                    )
                }
            }
        }
    }
}
