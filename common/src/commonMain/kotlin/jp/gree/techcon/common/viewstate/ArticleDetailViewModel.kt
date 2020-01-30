package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.usecase.ArticleDetailUseCase
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.wrap
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance
import org.kodein.di.newInstance

class ArticleDetailViewModel(articleId: Long): KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val useCase: ArticleDetailUseCase by kodein.instance()

    val article: CFlow<Article>

    init {
        article = useCase.get(articleId).wrap()
    }
}
