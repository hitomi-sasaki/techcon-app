package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Tags
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Tag(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Tag>(Tags)

    var name by Tags.name
}
