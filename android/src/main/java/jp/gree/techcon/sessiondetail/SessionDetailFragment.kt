package jp.gree.techcon.sessiondetail

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
import jp.gree.techcon.common.SessionDetailState
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.common.AppBar
import jp.gree.techcon.observe

class SessionDetailFragment : Fragment() {
    private val args: SessionDetailFragmentArgs by navArgs()
    private val viewState by lazy { SessionDetailState(args.sessionId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = ""
        val onBackClick = { findNavController().popBackStack(); Unit }

        val root = FrameLayout(requireContext())
        root.setContent { SessionDetailScreen(title, viewState, onBackClick) }
        return root
    }
}

@Composable
fun SessionDetailScreen(title: String, viewState: SessionDetailState, onBackClick: () -> Unit) {
    val session = observe(viewState.session) ?: return
    AppTheme {
        Column {
            AppBar(title = title, onBackClick = onBackClick, onShareClick = { /* TODO */ })
            SessionDetail(session = session)
        }
    }
}
