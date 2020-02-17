package jp.gree.techcon.server.controller

import io.ktor.application.ApplicationCall
import io.ktor.auth.authentication
import io.ktor.features.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.KtorExperimentalAPI
import jp.gree.techcon.common.model.SessionList
import jp.gree.techcon.server.service.SessionService
import jp.gree.techcon.server.service.firebaseUid
import org.jetbrains.exposed.exceptions.EntityNotFoundException

class SessionController(private val sessionService: SessionService) {
    suspend fun list(call: ApplicationCall) {
        call.respond(
            HttpStatusCode.OK,
            SessionList(sessionService.list(userUid = call.authentication.firebaseUid()))
        )
    }

    @KtorExperimentalAPI
    suspend fun get(id: Int, call: ApplicationCall) {
        call.respond(
            HttpStatusCode.OK,
            sessionService.get(id, call.authentication.firebaseUid())
        )
    }
}