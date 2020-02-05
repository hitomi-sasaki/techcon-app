package jp.gree.techcon.articlelist

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.unit.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
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
                Column {
                    Text(
                        text = article.title,
                        style = (MaterialTheme.typography()).subtitle1
                    )
                    Text(
                        text = article.description,
                        style = (MaterialTheme.typography()).body2
                    )
                }
            }
        }
    }
}
