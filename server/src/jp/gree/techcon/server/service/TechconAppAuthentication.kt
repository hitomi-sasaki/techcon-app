package jp.gree.techcon.server.service

import com.auth0.jwk.JwkProviderBuilder
import io.ktor.auth.Authentication
import io.ktor.auth.AuthenticationContext
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import java.net.URL
import java.util.concurrent.TimeUnit

// SEE: https://cloud.google.com/iam/docs/creating-managing-service-account-keys#creating_service_account_keys
const val JWKS_URL = "https://www.googleapis.com/service_accounts/v1/jwk/securetoken@system.gserviceaccount.com"

class TechconAppAuthenticationConfiguration() {
    lateinit var gcpProject: String
}

fun Authentication.Configuration.techcon(
    configure: TechconAppAuthenticationConfiguration.() -> Unit
) {
    val config = TechconAppAuthenticationConfiguration().apply(configure)
    val jwkIssuer = "https://securetoken.google.com/${config.gcpProject}"
    val jwtAudience = config.gcpProject
    val jwkProvider = JwkProviderBuilder(URL(JWKS_URL))
        .cached(10, 24, TimeUnit.HOURS)
        .rateLimited(10, 1, TimeUnit.MINUTES)
        .build()

    jwt {
        verifier(jwkProvider, jwkIssuer)
        validate { credentials ->
            if (credentials.payload.audience.contains(jwtAudience)) JWTPrincipal(credentials.payload) else null
        }
    }
}

fun AuthenticationContext.firebaseUid() = this.principal<JWTPrincipal>()?.payload?.subject