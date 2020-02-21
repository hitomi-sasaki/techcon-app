package jp.gree.techcon.server.service

import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.common.model.User as UserModel
import jp.gree.techcon.server.dao.Users
import jp.gree.techcon.server.entity.User

class UserService {
    suspend fun findByFirebaseUid(firebaseUid: String): List<UserModel> {
        // get data from database
        return DatabaseFactory.dbQuery {
            return@dbQuery User.find { Users.firebaseUid.eq(firebaseUid) }.map { user ->
                val bookmarks = user.bookmarks.map { session->
                    val names: List<Speaker> = session.speakers.map { speaker ->
                        Speaker(
                            speaker.name,
                            speaker.title,
                            speaker.githubId,
                            speaker.twitterId,
                            speaker.description
                        )
                    }
                    val tagNames: List<String> = session.tags.map { tag -> tag.name }

                    Session(
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
                UserModel(
                    user.id.value.toLong(),
                    user.firebaseUid,
                    bookmarks
                )
            }
        }
    }
}
