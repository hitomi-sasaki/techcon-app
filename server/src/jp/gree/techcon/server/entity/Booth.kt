package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Booths
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Booth(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Booth>(Booths)

    var title by Booths.title
    var description by Booths.description
}
