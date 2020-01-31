package jp.gree.techcon.server.dao

import org.jetbrains.exposed.sql.Table

object TagRelations : Table() {
    val session = reference("session_id", Sessions).primaryKey(0)
    val tag = reference("tag_id", Tags).primaryKey(1)
}
