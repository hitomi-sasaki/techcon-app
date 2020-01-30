package jp.gree.techcon.sessiondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import jp.gree.techcon.common.SessionDetailState
import jp.gree.techcon.observe

class SessionDetailFragment : Fragment() {
    private val args: SessionDetailFragmentArgs by navArgs()
    private val viewState by lazy { SessionDetailState(args.sessionId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.setContent { Root(viewState) }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}

@Composable
fun Root(viewState: SessionDetailState) {
    val session = +observe(viewState.session) ?: return
    MaterialTheme {
        SessionDetail(session = session)
    }
}
