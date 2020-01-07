package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Tags : IntIdTable() {
    val name = varchar("name", 128)
}
