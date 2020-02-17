package jp.gree.techcon.server.service

import io.ktor.features.NotFoundException
import io.ktor.util.KtorExperimentalAPI
import jp.gree.techcon.server.repository.SessionRepository

class SessionService(private val sessionRepository: SessionRepository) {
    suspend fun list(userUid: String?) = sessionRepository.list(userUid).map { it.toCommonObject() }
    @KtorExperimentalAPI
    suspend fun get(id: Int, userUid: String?) = sessionRepository.find(id, userUid)?.toCommonObject() ?: throw NotFoundException()
}
