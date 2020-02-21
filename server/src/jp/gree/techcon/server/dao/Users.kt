package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Users : IntIdTable() {
    val firebaseUid = varchar("firebase_uid", 128)
}
