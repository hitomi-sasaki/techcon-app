package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object TagRelations : IntIdTable() {
    val sessionId = integer("session_id")
    val tagId = integer("tag_id")
}