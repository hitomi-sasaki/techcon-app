package jp.gree.techcon.screens.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import jp.gree.techcon.R
import jp.gree.techcon.common.usecase.ArticleListService
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.component.AppBar
import jp.gree.techcon.composables.observe

class ArticleListFragment : Fragment() {
    private val service = ArticleListService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = getString(R.string.menu_article)

        val root = FrameLayout(requireContext())
        root.setContent {
            ArticleListScreen(title, service)
        }
        return root
    }
}


@Composable
fun ArticleListScreen(title: String, service: ArticleListService) {
    val articles = observe(service.articles) ?: listOf()
    AppTheme {
        Column {
            AppBar(title)
            ArticleList(articles)
        }
    }
}
