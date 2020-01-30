package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.repository.ArticleRepository

class ArticleDetailUseCase(private val repository: ArticleRepository) {
    fun get(articleId: Long) = repository.getArticle(articleId)
}
