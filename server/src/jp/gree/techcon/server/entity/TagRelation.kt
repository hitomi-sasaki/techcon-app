package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.TagRelations
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class TagRelation(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<TagRelation>(TagRelations)

    var sessionId by TagRelations.sessionId
    var tagId by TagRelations.tagId
}
