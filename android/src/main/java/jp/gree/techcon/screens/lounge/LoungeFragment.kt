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
import jp.gree.techcon.composables.AppTheme
import jp.gree.techcon.composables.component.AppBar

class LoungeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val title = getString(R.string.menu_lounge)

        val root = FrameLayout(requireContext())
        root.setContent {
            LoungeScreen(title)
        }
        return root
    }

}

@Composable
fun LoungeScreen(title: String) {
    AppTheme {
        Column {
            AppBar(title = title)
            Lounge()
        }
    }
}
