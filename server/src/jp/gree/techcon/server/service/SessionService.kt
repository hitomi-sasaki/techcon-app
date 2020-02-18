package jp.gree.techcon.server.service

import jp.gree.techcon.server.entity.*
import jp.gree.techcon.server.service.DatabaseFactory.dbQuery
import jp.gree.techcon.common.model.Session as SessionModel
import jp.gree.techcon.common.model.Speaker as SpeakerModel

class SessionService {
    suspend fun getAllSessions(): List<SessionModel> {
        var sessions: List<Session> = listOf()
        var result: List<SessionModel> = listOf()

        // get data from database
        dbQuery {
            sessions = Session.all().toList()
            // format data
            result = sessions.map { session ->
                val names: List<SpeakerModel> = session.speakers.map { speaker ->
                    SpeakerModel(
                        speaker.name,
                        speaker.title,
                        speaker.githubId,
                        speaker.twitterId,
                        speaker.description
                    )
                }
                val tagNames: List<String> = session.tags.map { tag -> tag.name }

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
        }
        return result
    }
}
