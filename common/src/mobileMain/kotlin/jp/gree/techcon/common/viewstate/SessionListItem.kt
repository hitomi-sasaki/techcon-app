package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.model.Session
import jp.gree.techcon.common.model.Speaker
import jp.gree.techcon.common.util.AppDateTime

data class SessionListItem(
    val id: Long,
    val name: String,
    val tags: String,
    val dateText: String,
    val title: String,
    val trackName: String,
    val speaker: Speaker,
    val isBookmarked: Boolean
) {
    companion object {
        fun build(session: Session, isBookmarked: Boolean): SessionListItem {
            return SessionListItem(
                id = session.id,
                name = session.name.map { it.name }.reduce { acc, name -> "$acc, $name" },
                tags = "#AWS #Unity",
                dateText = AppDateTime.parseToTimeDuration(session.startTime, session.endTime),
                title = session.title,
                trackName = "A-1",
                speaker = Speaker("test name", "test engineer", "", "", ""),
                isBookmarked = isBookmarked
            )
        }
    }
}
