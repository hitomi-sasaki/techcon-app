package jp.gree.techcon.server.dao

import org.jetbrains.exposed.sql.Table

object SpeakerRelations : Table() {
    val session = reference("session_id", Sessions).primaryKey(0)
    val speaker = reference("speaker_id", Speakers).primaryKey(1)
}
