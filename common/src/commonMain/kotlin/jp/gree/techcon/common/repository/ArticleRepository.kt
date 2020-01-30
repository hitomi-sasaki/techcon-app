package jp.gree.techcon.common.repository

import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRepository {
    fun getArticles(): Flow<List<Article>> = flow { emit(Api.getArticles()) }
    fun getArticle(id: Long): Flow<Article> = flow { emit(Api.getArticle(id)) }
}
