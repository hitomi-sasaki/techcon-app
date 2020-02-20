package jp.gree.techcon

import jp.gree.techcon.common.AppState

object MutableAppState : AppState {
    private var _token: String? = null
    override val token: String?
        get() = _token

    fun setToken(newToken: String?) {
        _token = newToken
    }
}
