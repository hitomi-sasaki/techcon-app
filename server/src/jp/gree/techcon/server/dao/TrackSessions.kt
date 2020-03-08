package jp.gree.techcon.server.dao

import org.jetbrains.exposed.sql.Table

object TrackSessions : Table() {
    val track = reference("track_id", Tracks).primaryKey(0)
    val session = reference("session_id", Sessions).primaryKey(1)
}
