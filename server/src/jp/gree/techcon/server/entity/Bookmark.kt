package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Bookmarks
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Bookmark(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Bookmark>(Bookmarks)

    var firebaseUid by Bookmarks.firebaseUid
    var session by Session referencedOn Bookmarks.session
}
