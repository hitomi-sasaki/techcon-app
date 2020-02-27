package jp.gree.techcon.common

import androidx.lifecycle.asLiveData
import jp.gree.techcon.common.viewstate.SessionDetailViewModel

// TODO: Remove this
class SessionDetailState(sessionId: Long) {
    private val vm =
        SessionDetailViewModel(sessionId)
    val session = vm.session
}
