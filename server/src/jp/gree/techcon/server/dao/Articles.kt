package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Articles : IntIdTable() {
    val title = varchar("title", 128)
    val description = varchar("description", 4096)
    val publishedAt = integer("published_at")
}
