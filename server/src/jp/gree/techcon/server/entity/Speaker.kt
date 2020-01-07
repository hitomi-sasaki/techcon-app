package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Speakers
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Speaker(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Speaker>(Speakers)

    var name by Speakers.name
    val title by Speakers.title
    val githubId by Speakers.githubId
    val twitterId by Speakers.twitterId
    val description by Speakers.description
}
