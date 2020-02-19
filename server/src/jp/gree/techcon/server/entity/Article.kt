package jp.gree.techcon.server.entity

import jp.gree.techcon.server.dao.Articles
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class Article(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Article>(Articles)

    var title by Articles.title
    var description by Articles.description
    var publishedAt by Articles.publishedAt
}
