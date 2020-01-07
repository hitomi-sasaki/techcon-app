package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object SpeakerRelations : IntIdTable() {
    val sessionId = integer("session_id")
    val speakerId = integer("speaker_id")
}
