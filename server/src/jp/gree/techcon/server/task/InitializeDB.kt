package jp.gree.techcon.server.task

import io.ktor.server.engine.commandLineEnvironment
import io.ktor.util.KtorExperimentalAPI
import jp.gree.techcon.server.dao.*
import jp.gree.techcon.server.entity.Article
import jp.gree.techcon.server.entity.Session
import jp.gree.techcon.server.entity.Speaker
import jp.gree.techcon.server.entity.Bookmark
import jp.gree.techcon.server.entity.Tag
import jp.gree.techcon.server.service.DatabaseFactory
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction

@KtorExperimentalAPI
fun main(args: Array<String>) {
    val config = commandLineEnvironment(args).config
    DatabaseFactory.init(config)

    InitializeDB.setupSchema()
    InitializeDB.setupInitialRecords()
}

object InitializeDB {
    const val DATABASE = "techcon"
    val TABLES = arrayOf(Sessions, SpeakerRelations, Speakers, TagRelations, Tags, Articles, Bookmarks)

    fun setupSchema() {
        transaction {
            SchemaUtils.createMissingTablesAndColumns(*TABLES)
        }
    }

    fun setupInitialRecords() {
        transaction {
            val TAG_IOS = DatabaseFactory.upsert(Tag.Companion, 1) {
                name = "iOS"
            }
            val TAG_ANDROID = DatabaseFactory.upsert(Tag.Companion, 2) {
                name = "Android"
            }
            val TAG_WEB = DatabaseFactory.upsert(Tag.Companion, 3) {
                name = "Web"
            }
            val TAG_PHP = DatabaseFactory.upsert(Tag.Companion, 4) {
                name = "PHP"
            }
            val TAG_GO = DatabaseFactory.upsert(Tag.Companion, 5) {
                name = "go"
            }
            val TAG_KOTLIN = DatabaseFactory.upsert(Tag.Companion, 6) {
                name = "Kotlin"
            }
            val TAG_SWIFT = DatabaseFactory.upsert(Tag.Companion, 7) {
                name = "Swift"
            }

            val SPEAKER_01 = DatabaseFactory.upsert(Speaker.Companion, 1) {
                name = "Haruki Nakano"
                title = "Android Engineer"
                githubId = "haru067"
                twitterId = "haru067"
                description = "最近はフィットネスと一体化しつつあります"
            }

            val SPEAKER_02 = DatabaseFactory.upsert(Speaker.Companion, 2) {
                name = "Takayuki Sei"
                title = "iOS Engineer"
                githubId = ""
                twitterId = "tion-low"
                description = ""
            }

            val SPEAKER_03 = DatabaseFactory.upsert(Speaker.Companion, 3) {
                name = "Masahiro Higuchi"
                title = "Backend Engineer"
                githubId = "aaaa"
                twitterId = ""
                description = "少し長めの文章をここに試しに入力あいうえおかきくけこさしすせそくぁｗせｄｒｆｔｇｙふじこｌｐ；"
            }

            val SESSION_01 = DatabaseFactory.upsert(Session.Companion, 1) {
                startTime = 1574157622
                endTime = 1574163622
                title = "PHPからgoへの移行で分かったこと"
                description = "弊社バックエンドは、PHPエンジニアのみで開発を行なっていました。 " +
                        "PHPからgoへの移行を行ったところ、トレーニング、開発環境構築、障害対応など想定外の問題が発生しました。 " +
                        "時代の流れとともに、goへの移行が選択肢に上がるケースが増えて来ているかと思います。 " +
                        "これらの知見を共有することで、goに移行した方が良いケースと悪いケースを明らかにしたいと思います。"
                slideUrl = "https://www.slideshare.net/greetech/phpgo-200234954"
                movieUrl = "https://www.youtube.com/watch?v=PD4lWpEXE2Q"
                speakers = SizedCollection(SPEAKER_01)
                tags = SizedCollection(TAG_WEB, TAG_PHP, TAG_GO)
            }

            val SESSION_02 = DatabaseFactory.upsert(Session.Companion, 2) {
                startTime = 1574157622
                endTime = 1574163622
                title = "エンジニア以外の方が自らSQLを使ってセグメント分析を行うカルチャーをどのように作っていったか"
                description = "リミアでは私達のチームが中心となって分析基盤を更新し、企画運営担当がSQLを使って自分が欲しい情報を分析できるようにしました。" +
                        "これにより、コンテンツやユーザに対する理解が深まり、KPIや業務効率の改善に繋がりました。 " +
                        "エンジニア以外の方が自らSQLを使ってセグメント分析を行う分析基盤やカルチャーをどのように作っていったか、またその結果どのような成果を達成できたか、" +
                        "そして当初の目論見と異なった点について説明します"
                slideUrl = "https://www.slideshare.net/greetech/sql-203319046"
                movieUrl = "https://www.youtube.com/watch?v=qad2CqdgjzU"
                speakers = SizedCollection(SPEAKER_02)
                tags = SizedCollection(TAG_WEB)
            }

            val SESSION_03 = DatabaseFactory.upsert(Session.Companion, 3) {
                startTime = 1574157622
                endTime = 1574163622
                title = "あなたたちの中で罪を犯したことのない者が、まず、この広告SDK開発者に石を投げなさい。"
                description = "iOSエンジニアという職業にはiOSアプリケーション開発をしている人間だけではなく、インターネット広告のサービスを利用するためのSDKを開発している人間も含まれております。 " +
                        "このセッションでは、モバイル向け広告SDKを開発/運用しているエンジニアの考えていることや、開発する上で大事にしていること、課題に感じていること、開発の方法などを発表します。"
                slideUrl = "https://www.slideshare.net/greetech/realityvtuber1"
                movieUrl = "https://www.youtube.com/watch?v=A0Ro_f5kzc8"
                speakers = SizedCollection(SPEAKER_03)
                tags = SizedCollection(TAG_IOS, TAG_SWIFT)
            }

            val ARTICLE_01 = DatabaseFactory.upsert(Article.Companion, 1) {
                title = "GREE Tech Conference 2020 公式アプリをダウンロードいただきありがとうございます。"
                description = "GREE Tech Conference 2020 公式アプリへようこそ。" +
                        "セッションをブックマークすることでマイスケジュールが作成できます。" +
                        "アプリを活用して GREE Tech Conference 2020 をお楽しみください。" +
                        "プライバシーポリシー" +
                        "https://techcon.gree.jp/xxxx" +
                        "利用規約" +
                        "https://techcon.gree.jp/xxxx"
                publishedAt = 1574157622
            }

            val ARTICLE_02 = DatabaseFactory.upsert(Article.Companion, 2) {
                title = "ブース情報追加しました"
                description = ""
                publishedAt = 1574157622
            }

            val ARTICLE_03 = DatabaseFactory.upsert(Article.Companion, 3) {
                title = "いよいよ今週末です"
                description = "いよいよ今週末です"
                publishedAt = 1574157622
            }

            val BOOKMARK_01 = DatabaseFactory.upsert(Bookmark.Companion, 1) {
                firebaseUid = "1111-1111-1111-1111"
                session = SESSION_01
            }

            val BOOKMARK_02 = DatabaseFactory.upsert(Bookmark.Companion, 2) {
                firebaseUid = "2222-2222-2222-2222"
                session = SESSION_02
            }

            val BOOKMARK_03 = DatabaseFactory.upsert(Bookmark.Companion, 2) {
                firebaseUid = "2222-2222-2222-2222"
                session = SESSION_03
            }
        }
    }
}