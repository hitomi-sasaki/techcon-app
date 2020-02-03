package jp.gree.techcon.server.service

import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.config.ApplicationConfig
import io.ktor.util.KtorExperimentalAPI
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object DatabaseFactory {
    @KtorExperimentalAPI
    fun init(config: ApplicationConfig) {
        Database.connect(hikari(config))
    }

    @KtorExperimentalAPI
    private fun hikari(app: ApplicationConfig): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "com.mysql.jdbc.Driver"
        config.jdbcUrl = app.propertyOrNull("ktor.techcon.jdbcUrl")?.getString() ?: ""
        config.username = app.propertyOrNull("ktor.techcon.username")?.getString() ?: ""
        config.password = app.propertyOrNull("ktor.techcon.password")?.getString() ?: ""
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(
        block: suspend () -> T): T =
        newSuspendedTransaction { block() }}