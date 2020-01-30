package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.usecase.SessionDetailUseCase
import kotlinx.coroutines.flow.Flow
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class SessionDetailViewModel(sessionId: Long): KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val useCase: SessionDetailUseCase by kodein.instance()

    val session: Flow<Session>

    init {
        session = useCase.get(sessionId)
    }
}
