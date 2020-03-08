package jp.gree.techcon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.gree.techcon.model.MutableAppState
import jp.gree.techcon.wrapper.Auth
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    fun requireAccount(invalidate: Boolean = false) {
        if (!invalidate && MutableAppState.token != null) return
        viewModelScope.launch {
            // TODO
            if (!Auth.isLoggedIn()) {
                val isSuccessful = Auth.signIn()
            }
            println("sadfa")
            val token = Auth.token()
            println("faf")
            MutableAppState.token = token
            println("asdadfaf")
        }
    }
}
