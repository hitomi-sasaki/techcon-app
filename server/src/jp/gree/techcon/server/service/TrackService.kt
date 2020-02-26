package jp.gree.techcon.server.service

import jp.gree.techcon.server.entity.Track
import jp.gree.techcon.common.model.Session as SessionModel
import jp.gree.techcon.common.model.Speaker as SpeakerModel
import jp.gree.techcon.common.model.Track as TrackModel

class TrackService {
    suspend fun getAll(): List<TrackModel> {
        return DatabaseFactory.dbQuery {
            return@dbQuery Track.all().map { track ->
                val sessions: List<SessionModel> = track.sessions.map { session ->
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
                TrackModel(
                    track.id.value.toLong(),
                    track.trackName,
                    sessions
                )
            }
        }
    }
}
