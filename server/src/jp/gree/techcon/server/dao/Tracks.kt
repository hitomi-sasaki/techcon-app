package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Tracks : IntIdTable() {
    val trackName = varchar("track_name", 128)
}
