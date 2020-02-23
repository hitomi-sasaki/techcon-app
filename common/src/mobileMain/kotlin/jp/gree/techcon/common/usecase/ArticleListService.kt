package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticleListService(private val repository: ArticleRepository) {
    fun get(): Flow<List<Article>> = repository.getArticles()
}
