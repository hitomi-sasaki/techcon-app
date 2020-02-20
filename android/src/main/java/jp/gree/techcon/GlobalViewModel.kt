package jp.gree.techcon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.gree.techcon.wrapper.Auth
import kotlinx.coroutines.launch

class GlobalViewModel : ViewModel() {
    fun initAccount() {
        viewModelScope.launch {
            // TODO
            if (!Auth.isLoggedIn()) {
                val isSuccessful = Auth.signIn()
            }
            val token = Auth.token()
            MutableAppState.setToken(token)
        }
    }
}
