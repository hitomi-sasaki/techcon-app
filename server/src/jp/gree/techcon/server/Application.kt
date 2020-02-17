package jp.gree.techcon.server

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.features.*
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
import jp.gree.techcon.server.controller.SessionController
import jp.gree.techcon.server.repository.SessionRepository
import jp.gree.techcon.server.service.DatabaseFactory
import jp.gree.techcon.server.service.SessionService
import jp.gree.techcon.server.service.techcon
import org.jetbrains.exposed.exceptions.EntityNotFoundException
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


object KodeinModules {
    private val session = Kodein.Module("SESSION") {
        bind() from singleton { SessionController(instance()) }
        bind() from singleton { SessionService(instance()) }
        bind() from singleton { SessionRepository() }
    }
    val kodein = Kodein {
        import(session)
    }
}

@KtorExperimentalAPI
@KtorExperimentalLocationsAPI
fun Application.module() {
    DatabaseFactory.init(environment.config)
    val sessionController by KodeinModules.kodein.instance<SessionController>()
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
    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respond(HttpStatusCode.InternalServerError)
        }
        exception<NotFoundException> { cause ->
            call.respond(HttpStatusCode.NotFound)
        }
    }
    routing {
        authenticate(optional = true) {
            get("/") {
                call.respond("hello")
            }
            @Location("/session/{id}")
            data class SessionLocation(val id: Int)
            get<SessionLocation> { sessionController.get(it.id, call) }
            get("/sessions") { sessionController.list(call) }
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
