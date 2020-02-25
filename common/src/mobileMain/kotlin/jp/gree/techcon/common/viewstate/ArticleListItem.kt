package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.util.AppDateTime

data class ArticleListItem(
    val title: String,
    val description: String,
    val timeText: String,
    val dateText: String
) {
    companion object {
        fun build(article: Article): ArticleListItem {
            return ArticleListItem(
                title = article.title,
                description = article.description,
                timeText = AppDateTime.parseToArticleTime(article.publishedAt),
                dateText = AppDateTime.parseToArticleDate(article.publishedAt)//article.publishedAt)
            )
        }

        fun buildList(articles: List<Article>): List<ArticleListItem> = articles.map { build(it) }
    }
}
