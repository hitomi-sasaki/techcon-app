package jp.gree.techcon.model

import jp.gree.techcon.common.AppState

object MutableAppState : AppState {
    override var token: String? = null
}
