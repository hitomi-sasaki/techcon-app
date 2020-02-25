package jp.gree.techcon.server.service

import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.server.dao.Sessions
import jp.gree.techcon.server.dao.Bookmarks
import jp.gree.techcon.server.entity.Bookmark
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.*
import jp.gree.techcon.common.model.User as UserModel

class UserService {
    suspend fun findByFirebaseUid(firebaseUid: String): UserModel {
        // get data from database
        return DatabaseFactory.dbQuery {
            val bookmarks = Bookmark.find { Bookmarks.firebaseUid.eq(firebaseUid) }.map { user ->
                val names: List<Speaker> = user.session.speakers.map { speaker ->
                    Speaker(
                        speaker.name,
                        speaker.title,
                        speaker.githubId,
                        speaker.twitterId,
                        speaker.description
                    )
                }
                val tagNames: List<String> = user.session.tags.map { tag -> tag.name }

                Session(
                    user.session.id.value.toLong(),
                    names,
                    user.session.startTime.toLong(),
                    user.session.endTime.toLong(),
                    user.session.title,
                    user.session.description,
                    tagNames,
                    user.session.slideUrl,
                    user.session.movieUrl
                )
            }
            UserModel(
                firebaseUid,
                bookmarks
            )
        }
    }

    suspend fun setBookmark(firebaseUid: String, sessionId: Int): Boolean {
        return DatabaseFactory.dbQuery {
            //            Bookmark.find { Bookmarks.firebaseUid.eq(firebaseUid) }.map { bookmark ->
//                var alreadyExists: Boolean = false
//                user.bookmarks.forEach { session ->
//                    alreadyExists = alreadyExists || session.id.value.equals(sessionId)
//                }
//                if (alreadyExists) {
//                    return@dbQuery false
//                }
//                Bookmarks.insert {
//                        it[Bookmarks.firebaseUid] = firebaseUid
//                        it[Bookmarks.session] = EntityID(sessionId, Sessions)
//                    }
////                DatabaseFactory.upsert(User.Companion, 1) {
////                    firebaseUid = "1111-1111-1111-1111"
////                    bookmarks = SizedCollection(sessionId)
////                }
//            }
//            return@dbQuery true
            Bookmarks.select { Bookmarks.firebaseUid.eq(firebaseUid) and Bookmarks.session.eq(sessionId) }.forEach {
                return@dbQuery false
            }
            Bookmarks.insert {
                it[Bookmarks.firebaseUid] = firebaseUid
                it[Bookmarks.session] = EntityID(sessionId, Sessions)
            }
            return@dbQuery true
        }
    }
}
