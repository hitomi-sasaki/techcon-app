package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.model.Article

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
                timeText = "10:00 AM", // TODO: date-to-string converter
                dateText = "10月12日（火）" // TODO: date-to-string converter
            )
        }

        fun buildList(articles: List<Article>): List<ArticleListItem> = articles.map { build(it) }
    }
}
