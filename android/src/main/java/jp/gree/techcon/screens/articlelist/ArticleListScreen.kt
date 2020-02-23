package jp.gree.techcon.screens.articlelist

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.unit.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.composables.*

@Composable
fun ArticleList(articles: List<Article>) {
    VerticalScroller {
        ScreenPadding {
            Column {
                articles.forEachIndexed { i, article ->
                    ArticleListItem(article)
                    if (i != articles.size - 1) {
                        VerticalSpace(32.dp)
                        Divider()
                        VerticalSpace(32.dp)
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleListItem(article: Article) {
    Column {
        PrimaryText("4月8日", appTypography.subtitle1)
        VerticalSpace(16.dp)
        PrimaryText(article.title, appTypography.subtitle1)
        VerticalSpace(16.dp)
        SecondaryText(article.description, appTypography.body1)
        VerticalSpace(16.dp)
        SecondaryText("10:00 AM", appTypography.body1)
    }
}
