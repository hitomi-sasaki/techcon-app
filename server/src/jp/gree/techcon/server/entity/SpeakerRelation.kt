package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.SpeakerRelations
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class SpeakerRelation(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<SpeakerRelation>(SpeakerRelations)

    var sessionId by SpeakerRelations.sessionId
    val speakerId by SpeakerRelations.speakerId
}
