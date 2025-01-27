package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Sessions
import jp.gree.techcon.server.dao.SpeakerRelations
import jp.gree.techcon.server.dao.TagRelations
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Session(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Session>(Sessions)

    var startTime by Sessions.startTime
    var endTime by Sessions.endTime
    var title by Sessions.title
    var description by Sessions.description
    var slideUrl by Sessions.slideUrl
    var movieUrl by Sessions.movieUrl
    var speakers by Speaker via SpeakerRelations
    var tags by Tag via TagRelations
}
