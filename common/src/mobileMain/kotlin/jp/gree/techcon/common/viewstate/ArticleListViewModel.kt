package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.usecase.ArticleListUseCase
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.wrap
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class ArticleListViewModel: KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val useCase: ArticleListUseCase by kodein.instance()
    val articles: CFlow<List<Article>>

    init {
        articles = useCase.get().wrap()
        // articles = flow<List<Article>> { listOf<Article>() }.wrap()
    }
}

