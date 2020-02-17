package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Speakers
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Speaker(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<Speaker>(Speakers)

    var name by Speakers.name
    var title by Speakers.title
    var githubId by Speakers.githubId
    var twitterId by Speakers.twitterId
    var description by Speakers.description

    fun toCommonObject() = jp.gree.techcon.common.model.Speaker(
        name = name,
        title = title,
        githubId = githubId,
        twitterId = twitterId,
        description = description
    )
}
