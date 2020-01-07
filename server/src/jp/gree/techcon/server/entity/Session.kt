package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Sessions
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Session(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Session>(Sessions)

    var startTime by Sessions.startTime
    val endTime by Sessions.endTime
    val title by Sessions.title
    val description by Sessions.description
    val slideUrl by Sessions.slideUrl
    val movieUrl by Sessions.movieUrl
}
