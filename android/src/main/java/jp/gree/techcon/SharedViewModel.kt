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
            val token = Auth.token()
            MutableAppState.token = token
        }
    }
}
