package jp.gree.techcon.screens.lounge

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
import jp.gree.techcon.common.model.Booth
import jp.gree.techcon.common.usecase.LoungeService
import jp.gree.techcon.common.util.CFlow
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.component.AppBar
import jp.gree.techcon.composables.observe

class LoungeFragment : Fragment() {
    private val service by lazy { LoungeService() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = getString(R.string.menu_lounge)

        val root = FrameLayout(requireContext())
        root.setContent { LoungeScreen(title, service.get()) }
        return root
    }

}

@Composable
fun LoungeScreen(title: String, observable: CFlow<List<Booth>>) {
    val booths = observe(observable) ?: listOf()
    AppTheme {
        Column {
            AppBar(title = title)
            Lounge(booths)
        }
    }
}
