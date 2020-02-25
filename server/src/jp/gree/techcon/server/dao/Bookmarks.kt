package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Bookmarks : IntIdTable() {
    val firebaseUid = varchar("firebase_uid", 128)
    val session = reference("session_id", Sessions)
}
