package jp.gree.techcon.server.dao

import org.jetbrains.exposed.sql.Table

object Bookmarks : Table() {
    val user = reference("user_id", Users).primaryKey(0)
    val session = reference("session_id", Sessions).primaryKey(1)
}
