package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Boothes
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Booth(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Booth>(Boothes)

    var title by Boothes.title
    var description by Boothes.description
}
