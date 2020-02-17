package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Schedules
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Schedule(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Schedule>(Schedules)

    var userUid by Schedules.userUid
    var session by Session referencedOn Schedules.session
}
