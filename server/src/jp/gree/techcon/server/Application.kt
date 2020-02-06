package jp.gree.techcon.server

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
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
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.serialization.serialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import jp.gree.techcon.common.model.*
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.server.service.DatabaseFactory
import jp.gree.techcon.server.service.SessionService
import org.jetbrains.exposed.sql.*

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
    install(Routing) {
        get("/") {
            call.respond("hello")
        }
        @Location("/session/{id}")
        data class SessionLocation(val id: Long)
        get<SessionLocation> { param ->
            val id = param.id
            call.respond(Session.getSample())
        }
        get("/sessions") {
            call.respond(
                HttpStatusCode.OK,
                SessionService().getAllSessions()
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

fun main() {
    embeddedServer(
        Netty,
        8080,
        module = Application::module
    ).start()
}
