package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.repository.ArticleRepository
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.wrap
import kotlinx.coroutines.flow.Flow
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class ArticleListService : KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val repository: ArticleRepository by kodein.instance()
    val articles: CFlow<List<Article>>

    init {
        articles = get().wrap()
    }

    private fun get(): Flow<List<Article>> = repository.getArticles()
}
