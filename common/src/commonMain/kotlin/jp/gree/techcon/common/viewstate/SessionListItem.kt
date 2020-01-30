package jp.gree.techcon.common.viewstate

import jp.gree.techcon.common.model.Session

data class SessionListItem(
    val id: Long,
    val names: String,
    val dateText: String,
    val title: String,
    val isBookmarked: Boolean
) {
    companion object {
        fun build(session: Session, isBookmarked: Boolean): SessionListItem {
            return SessionListItem(
                id = session.id,
                names = session.name.map { it.name }.reduce { acc, name -> "$acc, $name" },
                dateText = "12月19日 19:00 - 20:00", // TODO: date-to-string converter
                title = session.title,
                isBookmarked = isBookmarked
            )
        }
    }
}
