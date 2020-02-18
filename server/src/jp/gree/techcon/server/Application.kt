package jp.gree.techcon.server

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.auth.authentication
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.serialization.serialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.KtorExperimentalAPI
import jp.gree.techcon.common.model.Article
import jp.gree.techcon.common.model.ArticleList
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.SessionList
import jp.gree.techcon.server.service.DatabaseFactory
import jp.gree.techcon.server.service.SessionService
import jp.gree.techcon.server.service.firebaseUid
import jp.gree.techcon.server.service.techcon


@KtorExperimentalAPI
@KtorExperimentalLocationsAPI
fun Application.module() {
    DatabaseFactory.init(environment.config)
    install(DefaultHeaders) {
        header(HttpHeaders.AccessControlAllowOrigin, "*")
    }
    install(CallLogging)
    install(Locations)
    install(ContentNegotiation) {
        serialization()
    }
    install(Authentication) {
        techcon {
            gcpProject = environment.config.property("ktor.techcon.gcpProject").getString()
        }
    }
    routing {
        authenticate(optional = true) {
            get("/") {
                call.respond("hello")
            }
            @Location("/session/{id}")
            data class SessionLocation(val id: Long)
            get<SessionLocation> { param ->
                val id = param.id.toInt()
                val session = SessionService().get(id)
                if (session == null) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        session
                    )
                }
            }
            get("/sessions") {
                // val firebaseUid: String? = call.authentication.firebaseUid()
                call.respond(
                    HttpStatusCode.OK,
                    SessionList(SessionService().getAllSessions())
                )
            }
            get("/bookmarks") {
                call.respond(
                    HttpStatusCode.OK,
                    SessionList(Session.getDummyList().take(4))
                )
            }
            @Location("article/{id}")
            data class ArticleLocation(val id: Long)
            get<ArticleLocation> { param ->
                val id = param.id
                call.respond(Article.getSample(id))
            }
            get("/articles") {
                call.respond(ArticleList(Article.getSamples()))
            }
            post("/bookmark") {
                call.respond(Session.getSample())
            }
        }
    }
}

fun main() {
    embeddedServer(
        Netty,
        8080,
        module = Application::module
    ).start()
}
