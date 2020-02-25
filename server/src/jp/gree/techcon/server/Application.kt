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
import jp.gree.techcon.common.model.*
import jp.gree.techcon.server.service.*


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
            data class SessionLocation(val id: Int)
            get<SessionLocation> { param ->
                val session = SessionService().get(param.id)
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
            data class ArticleLocation(val id: Int)
            get<ArticleLocation> { param ->
                val article = ArticleService().get(param.id)
                if (article == null) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        article
                    )
                }
            }
            get("/articles") {
                call.respond(
                    HttpStatusCode.OK,
                    ArticleList(ArticleService().getAll())
                )
            }
            get("/boothes") {
                call.respond(
                    HttpStatusCode.OK,
                    BoothList(BoothService().getAll())
                )
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
