package jp.gree.techcon.common.datasource.db

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import jp.gree.techcon.common.AppDatabase
import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker


class SessionDao(private val db: AppDatabase) {
    fun loadSessions() =
        db.sessionQueries.selectAll(mapper = { id: String, name: String, startTime: Long, endTime: Long, title: String, description: String ->
            Session(
                id.toLong(),
                listOf(Speaker.getSample()),
                startTime,
                endTime,
                title,
                description,
                listOf()
            )
        }).asFlow().mapToList()

    // TODO: Remove this workaround after supporting iOS multithread
    suspend fun loadSessionsWorkaroundForIos() =
            db.sessionQueries.selectAll(mapper = { id: String, name: String, startTime: Long, endTime: Long, title: String, description: String ->
            Session(
                    id.toLong(),
                    listOf(Speaker.getSample()),
                    startTime,
                    endTime,
                    title,
                    description,
                    listOf()
            )
        }).executeAsList()

    fun save(sessions: List<Session>) {
        db.sessionQueries.transaction {
            sessions.forEach {
                db.sessionQueries.save(it.id.toString(), it.name[0].name, it.startTime, it.endTime, it.title, it.description)
            }
        }
    }
}
