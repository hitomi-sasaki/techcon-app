package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Sessions
import jp.gree.techcon.server.dao.Tracks
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Track(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Track>(Tracks)

    var name by Tracks.name
    var order by Tracks.order
    val sessions by Session referrersOn Sessions.track
}
