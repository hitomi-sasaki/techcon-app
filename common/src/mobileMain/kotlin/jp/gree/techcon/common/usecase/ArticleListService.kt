package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.repository.ArticleRepository
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.wrap
import jp.gree.techcon.common.viewstate.ArticleListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class ArticleListService : KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val repository: ArticleRepository by kodein.instance()
    val articles: CFlow<List<ArticleListItem>>

    init {
        articles = get().wrap()
    }

    private fun get(): Flow<List<ArticleListItem>> =
        repository.getArticles().map { ArticleListItem.buildList(it) }
}
