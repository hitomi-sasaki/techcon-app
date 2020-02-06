package jp.gree.techcon.server.dao

import org.jetbrains.exposed.dao.IntIdTable

object Speakers : IntIdTable() {
    val name = varchar("name", 128)
    val title = varchar("title", 128)
    val githubId = varchar("github_id", 128)
    val twitterId = varchar("twitter_id", 128)
    val description = varchar("description", 4096)
}
