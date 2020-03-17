package jp.gree.techcon.screens.sessiondetail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.usecase.SessionDetailService
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.component.AppBar
import jp.gree.techcon.composables.observe

class SessionDetailFragment : Fragment() {
    private val args: SessionDetailFragmentArgs by navArgs()
    private val service = SessionDetailService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = ""
        val onBackClick: () -> Unit = { findNavController().popBackStack() }
        val onShareClick: (Session?) -> Unit = { share(it) }

        val root = FrameLayout(requireContext())
        root.setContent { SessionDetailScreen(title, service.get(args.sessionId), onBackClick, onShareClick) }
        return root
    }

    private fun share(session: Session?) {
        if (session == null) return

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "https://google.co.jp/search?q=${session.id}") // TODO: fix url
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}

@Composable
fun SessionDetailScreen(
    title: String,
    observable: CFlow<Session>,
    onBackClick: () -> Unit,
    onShareClick: (Session?) -> Unit
) {
    val session = observe(observable)
    AppTheme {
        Column {
            AppBar(
                title = title,
                onBackClick = onBackClick,
                onShareClick = { onShareClick(session) })
            SessionDetail(session = session)
        }
    }
}
