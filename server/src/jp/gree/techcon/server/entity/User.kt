package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Bookmarks
import jp.gree.techcon.server.dao.Users
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var firebaseUid by Users.firebaseUid
    var bookmarks by Session via Bookmarks
}
