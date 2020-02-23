package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.usecase.ArticleDetailService
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.common.util.wrap
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class ArticleDetailViewModel(articleId: Long): KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val useCase: ArticleDetailService by kodein.instance()

    val article: CFlow<Article>

    init {
        article = useCase.get(articleId).wrap()
    }
}
