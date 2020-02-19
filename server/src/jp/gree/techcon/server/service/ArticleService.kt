package jp.gree.techcon.server.service

import jp.gree.techcon.common.model.Article as ArticleModel
import jp.gree.techcon.server.entity.Article
import jp.gree.techcon.server.service.DatabaseFactory.dbQuery

class ArticleService {
    suspend fun getAll(): List<ArticleModel> {
        // get data from database
        return dbQuery {
            // format data
            return@dbQuery Article.all().toList().map { article ->
                ArticleModel(
                    article.id.value.toLong(),
                    article.title,
                    article.description,
                    article.publishedAt.toLong()
                )
            }
        }
    }

    suspend fun get(id: Int): ArticleModel? {
        // get data from database
        return dbQuery {
            // format data
            return@dbQuery Article.findById(id)?.let { article ->
                ArticleModel(
                    article.id.value.toLong(),
                    article.title,
                    article.description,
                    article.publishedAt.toLong()
                )
            }
        }
    }
}
