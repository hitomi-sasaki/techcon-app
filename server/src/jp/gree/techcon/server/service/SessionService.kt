package jp.gree.techcon.server.service

import jp.gree.techcon.server.entity.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import jp.gree.techcon.common.model.Session as SessionModel
import jp.gree.techcon.common.model.Speaker as SpeakerModel
import jp.gree.techcon.common.model.Tag as TagModel

class SessionService {
    fun getAllSessions(): List<SessionModel> {
        val user = "root"
        val pass = "root"
        val url = "jdbc:mysql://techcon-mysql:3306/techcon?useSSL=false"
        val driver = "com.mysql.jdbc.Driver"
        Database.connect(url = url, driver = driver, user = user, password = pass)
        var sessions: List<Session> = listOf()
        var speakers: List<Speaker> = listOf()
        var speakerRelations: List<SpeakerRelation> = listOf()
        var tags: List<Tag> = listOf()
        var tagRelations: List<TagRelation> = listOf()
        // get data from database
        transaction {
            sessions = Session.all().toList()
            speakers = Speaker.all().toList()
            speakerRelations = SpeakerRelation.all().toList()
            tags = Tag.all().toList()
            tagRelations = TagRelation.all().toList()
        }
        // format data
        val result: List<SessionModel> = sessions.map { session ->
            val names: List<SpeakerModel> = speakerRelations.map { speakerRelation ->
                if (session.id.value == speakerRelation.sessionId) {
                    speakers.map { speaker ->
                        if (speakerRelation.speakerId == speaker.id.value) {
                            SpeakerModel(
                                speaker.name,
                                speaker.title,
                                speaker.githubId,
                                speaker.twitterId,
                                speaker.description
                            )
                        } else {
                            null
                        }
                    }.filterNotNull()
                } else {
                    null
                }
            }.filterNotNull().flatMap { it.distinct() }

            val tagNames: List<TagModel> = tagRelations.map { tagRelation ->
                if (session.id.value == tagRelation.sessionId) {
                    tags.map {tag ->
                        if (tagRelation.tagId == tag.id.value) {
                            TagModel(tag.name)
                        } else {
                            null
                        }
                    }.filterNotNull()
                } else {
                    null
                }
            }.filterNotNull().flatMap { it.distinct() }

            SessionModel(
                session.id.value.toLong(),
                names,
                session.startTime.toLong(),
                session.endTime.toLong(),
                session.title,
                session.description,
                tagNames,
                session.slideUrl,
                session.movieUrl
            )
        }
        return result
    }
}
