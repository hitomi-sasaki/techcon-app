package jp.gree.techcon.screens.articlelist

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.Divider
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import jp.gree.techcon.common.viewstate.ArticleListItem
import jp.gree.techcon.composables.*

@Composable
fun ArticleList(articles: List<ArticleListItem>) {
    VerticalScroller {
        ScreenColumn {
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

@Composable
fun ArticleListItem(article: ArticleListItem) {
    Column {
        PrimaryText(article.dateText, appTypography.h5)
        if (article.title.isNotEmpty()) {
            VerticalSpace(16.dp)
            PrimaryText(article.title, appTypography.subtitle1)
        }
        if (article.description.isNotEmpty()) {
            VerticalSpace(16.dp)
            SecondaryText(article.description, appTypography.body1)
        }
        VerticalSpace(16.dp)
        SecondaryText(article.timeText, appTypography.body1)
    }
}
