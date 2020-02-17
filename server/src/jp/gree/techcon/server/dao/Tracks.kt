package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Tracks : IntIdTable() {
    val name = text("name")
    val order = integer("order")
}