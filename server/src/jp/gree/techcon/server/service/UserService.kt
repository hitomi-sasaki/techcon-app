package jp.gree.techcon.server.service

import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.server.dao.Bookmarks
import jp.gree.techcon.server.dao.Sessions
import jp.gree.techcon.server.dao.Users
import jp.gree.techcon.server.entity.User
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.*
import jp.gree.techcon.common.model.User as UserModel

class UserService {
    suspend fun findByFirebaseUid(firebaseUid: String): List<UserModel> {
        // get data from database
        return DatabaseFactory.dbQuery {
            return@dbQuery User.find { Users.firebaseUid.eq(firebaseUid) }.map { user ->
                val bookmarks = user.bookmarks.map { session ->
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

    suspend fun setBookmark(firebaseUid: String, sessionId: Int): Boolean {
        return DatabaseFactory.dbQuery {
            User.find { Users.firebaseUid.eq(firebaseUid) }.map { user ->
                var alreadyExists: Boolean = false
                user.bookmarks.forEach { session ->
                    alreadyExists = alreadyExists || session.id.value.equals(sessionId)
                }
                if (alreadyExists) {
                    return@dbQuery false
                }
                Bookmarks.insert {
                        it[Bookmarks.user] = user.id
                        it[Bookmarks.session] = EntityID(sessionId, Sessions)
                    }
            }
            return@dbQuery true
        }
    }
}
