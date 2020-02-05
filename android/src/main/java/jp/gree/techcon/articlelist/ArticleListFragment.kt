package jp.gree.techcon.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import jp.gree.techcon.common.viewstate.ArticleListViewModel
import jp.gree.techcon.observe

class ArticleListFragment : Fragment() {
    private val vm = ArticleListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.setContent { Root(vm) }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

@Composable
fun Root(viewState: ArticleListViewModel) {
    val articles = observe(viewState.articles) ?: listOf()
    MaterialTheme {
        ArticleList(articles = articles)
    }
}
