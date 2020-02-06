package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Sessions : IntIdTable() {
    val startTime = integer("start_time")
    val endTime = integer("end_time")
    val title = varchar("title", 128)
    val description = varchar("description", 4096)
    val slideUrl = varchar("slide_url", 1024)
    val movieUrl = varchar("movie_url", 1024)
}
