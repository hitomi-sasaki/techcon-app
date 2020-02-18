package jp.gree.techcon.screens.articledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import jp.gree.techcon.common.viewstate.ArticleDetailViewModel
import jp.gree.techcon.observe

class ArticleDetailFragment : Fragment() {
    private val args: ArticleDetailFragmentArgs by navArgs()
    private val vm by lazy {
        ArticleDetailViewModel(
            args.articleId
        )
    }

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
fun Root(vm: ArticleDetailViewModel) {
    val article = observe(vm.article) ?: return
    MaterialTheme {
        ArticleDetail(article = article)
    }
}
