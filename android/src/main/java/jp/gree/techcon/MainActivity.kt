package jp.gree.techcon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import dev.chrisbanes.insetter.doOnApplyWindowInsets
import jp.gree.techcon.common.util.GlobalEvent
import jp.gree.techcon.databinding.ActivityMainBinding
import kotlinx.io.core.Closeable

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
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

        // TODO: zatsu
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to sign in", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            user.getIdToken(true).addOnCompleteListener {
                if (it.isSuccessful) {
                    val idToken = it.result!!.token
                    Toast.makeText(this, idToken, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Auth failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        closable.close()
    }
}
