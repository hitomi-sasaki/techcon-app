package jp.gree.techcon.common.repository

import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRepository(private val api: Api) {
    fun getArticles(): Flow<List<Article>> = flow { emit(api.getArticles()) }
    fun getArticle(id: Long): Flow<Article> = flow { emit(api.getArticle(id)) }
}
