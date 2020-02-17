package jp.gree.techcon.server.repository

import jp.gree.techcon.server.entity.Session
import jp.gree.techcon.server.service.DatabaseFactory.dbQuery
import org.jetbrains.exposed.dao.with

class SessionRepository {
    suspend fun list(userUid: String?): List<Session> {
        return dbQuery {
            return@dbQuery Session.all().with(*Session.relations)
        }
    }

    suspend fun find(id: Int, userUid: String?): Session? {
        return dbQuery {
            return@dbQuery Session.findById(id)?.apply { loadRelations() }
        }
    }
}