package jp.gree.techcon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dev.chrisbanes.insetter.doOnApplyWindowInsets
import jp.gree.techcon.common.util.GlobalEvent
import jp.gree.techcon.databinding.ActivityMainBinding
import kotlinx.io.core.Closeable

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: SharedViewModel by viewModels()
    private lateinit var closable: Closeable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Navigation
        binding.bottomNav.setupWithNavController(findNavController(R.id.nav_host_fragment))

        // Edge to Edge
        binding.root.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        binding.root.doOnApplyWindowInsets { view, insets, initialState ->
            view.updatePadding(top = initialState.paddings.top + insets.systemWindowInsetTop)
        }

        // TODO: This is Sample code. remove this later
        closable = GlobalEvent.onError.watch {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.requireAccount()
    }

    override fun onDestroy() {
        super.onDestroy()
        closable.close()
    }
}
