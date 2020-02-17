package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Schedules : IntIdTable() {
    val userUid = varchar("user_uid", 128)
    val session = reference("session_id", Sessions)

    init {
        index(true, userUid, session)
    }
}