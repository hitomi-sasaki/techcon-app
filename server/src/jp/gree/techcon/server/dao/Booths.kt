package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Booths : IntIdTable() {
    val title = varchar("title", 128)
    val description = varchar("description", 4096)
}