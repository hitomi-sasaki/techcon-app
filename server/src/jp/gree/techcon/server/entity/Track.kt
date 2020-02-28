package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.TrackSessions
import jp.gree.techcon.server.dao.Tracks
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Track(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Track>(Tracks)

    var trackName by Tracks.trackName
    var sessions by Session via TrackSessions
}
