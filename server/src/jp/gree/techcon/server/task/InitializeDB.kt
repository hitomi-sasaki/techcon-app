package jp.gree.techcon.server.task

import io.ktor.server.engine.commandLineEnvironment
import io.ktor.util.KtorExperimentalAPI
import jp.gree.techcon.server.dao.*
import jp.gree.techcon.server.entity.Article
import jp.gree.techcon.server.entity.Session
import jp.gree.techcon.server.entity.Speaker
import jp.gree.techcon.server.entity.Tag
import jp.gree.techcon.server.service.DatabaseFactory
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.TransactionManager
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
    val TABLES = arrayOf(Sessions, SpeakerRelations, Speakers, TagRelations, Tags, Articles)

    fun setupSchema() {
        transaction {
            SchemaUtils.createMissingTablesAndColumns(*TABLES)
        }
    }

    fun setupInitialRecords() {
        transaction {
            val TAG_ANDROID = DatabaseFactory.upsert(Tag.Companion, 1) {
                name = "Android"
            }
            val TAG_APACHEBEAM = DatabaseFactory.upsert(Tag.Companion, 2) {
                name = "ApacheBeam"
            }
            val TAG_AWS = DatabaseFactory.upsert(Tag.Companion, 3) {
                name = "AWS"
            }
            val TAG_BIGQUERY = DatabaseFactory.upsert(Tag.Companion, 4) {
                name = "BigQuery"
            }
            val TAG_DEEPLEARNING = DatabaseFactory.upsert(Tag.Companion, 5) {
                name = "DeepLearning"
            }
            val TAG_DEVOPS = DatabaseFactory.upsert(Tag.Companion, 6) {
                name = "DevOps"
            }
            val TAG_FIREBASE = DatabaseFactory.upsert(Tag.Companion, 7) {
                name = "Firebase"
            }
            val TAG_GAMEENGINE = DatabaseFactory.upsert(Tag.Companion, 8) {
                name = "GameEngine"
            }
            val TAG_GCP = DatabaseFactory.upsert(Tag.Companion, 9) {
                name = "GCP"
            }
            val TAG_GRAPHQL = DatabaseFactory.upsert(Tag.Companion, 10) {
                name = "GraphQL"
            }
            val TAG_INFRA = DatabaseFactory.upsert(Tag.Companion, 11) {
                name = "Infra"
            }
            val TAG_IOS = DatabaseFactory.upsert(Tag.Companion, 12) {
                name = "iOS"
            }
            val TAG_KUBERNETES = DatabaseFactory.upsert(Tag.Companion, 13) {
                name = "Kubernetes"
            }
            val TAG_LAMP = DatabaseFactory.upsert(Tag.Companion, 14) {
                name = "LAMP"
            }
            val TAG_LUA = DatabaseFactory.upsert(Tag.Companion, 15) {
                name = "Lua"
            }
            val TAG_MACHINELEANING = DatabaseFactory.upsert(Tag.Companion, 16) {
                name = "MachineLeaning"
            }
            val TAG_MOTIONCAPTURE = DatabaseFactory.upsert(Tag.Companion, 17) {
                name = "MotionCapture"
            }
            val TAG_NATIVEAPP = DatabaseFactory.upsert(Tag.Companion, 18) {
                name = "NativeApp"
            }
            val TAG_NUXTJS = DatabaseFactory.upsert(Tag.Companion, 19) {
                name = "NuxtJS"
            }
            val TAG_PHP = DatabaseFactory.upsert(Tag.Companion, 20) {
                name = "PHP"
            }
            val TAG_REALTIMESERVER = DatabaseFactory.upsert(Tag.Companion, 21) {
                name = "RealtimeServer"
            }
            val TAG_RPG = DatabaseFactory.upsert(Tag.Companion, 22) {
                name = "RPG"
            }
            val TAG_UNITY = DatabaseFactory.upsert(Tag.Companion, 23) {
                name = "Unity"
            }
            val TAG_UNREALENGINE4 = DatabaseFactory.upsert(Tag.Companion, 24) {
                name = "UnrealEngine4"
            }
            val TAG_VOICECONVERSION = DatabaseFactory.upsert(Tag.Companion, 25) {
                name = "VoiceConversion"
            }
            val TAG_VUEJS = DatabaseFactory.upsert(Tag.Companion, 26) {
                name = "Vue.js"
            }
            val TAG_WFLE = DatabaseFactory.upsert(Tag.Companion, 27) {
                name = "WFLE"
            }
            val TAG_WFS = DatabaseFactory.upsert(Tag.Companion, 28) {
                name = "WFS"
            }
            val TAG_ENGINEER = DatabaseFactory.upsert(Tag.Companion, 29) {
                name = "エンジニア"
            }
            val TAG_ENGINEERING = DatabaseFactory.upsert(Tag.Companion, 30) {
                name = "エンジニアリング"
            }
            val TAG_SOCIALGAME = DatabaseFactory.upsert(Tag.Companion, 31) {
                name = "ソーシャルゲーム"
            }
            val TAG_DATAPIPELINE = DatabaseFactory.upsert(Tag.Companion, 32) {
                name = "データパイプライン"
            }
            val TAG_FRONTEND = DatabaseFactory.upsert(Tag.Companion, 33) {
                name = "フロントエンド"
            }
            val TAG_MOBILEGAME = DatabaseFactory.upsert(Tag.Companion, 34) {
                name = "モバイルゲーム"
            }
            val TAG_LIVE = DatabaseFactory.upsert(Tag.Companion, 35) {
                name = "ライブ配信"
            }
            val TAG_LEGACY = DatabaseFactory.upsert(Tag.Companion, 36) {
                name = "レガシー"
            }
            val TAG_INFRASTRUCTURE = DatabaseFactory.upsert(Tag.Companion, 37) {
                name = "基盤"
            }
            val TAG_MIGRATION = DatabaseFactory.upsert(Tag.Companion, 38) {
                name = "移管"
            }
            val TAG_ORGANIZATION = DatabaseFactory.upsert(Tag.Companion, 39) {
                name = "組織"
            }
            val TAG_RUN = DatabaseFactory.upsert(Tag.Companion, 40) {
                name = "運営"
            }
            val TAG_OPERATION = DatabaseFactory.upsert(Tag.Companion, 41) {
                name = "運用"
            }
            val TAG_LONGTERM = DatabaseFactory.upsert(Tag.Companion, 42) {
                name = "運用10年"
            }
            val TAG_LONGHIT = DatabaseFactory.upsert(Tag.Companion, 43) {
                name = "長寿タイトル"
            }
            val TAG_DEVELOPMENT = DatabaseFactory.upsert(Tag.Companion, 44) {
                name = "開発"
            }


            val SPEAKER_01 = DatabaseFactory.upsert(Speaker.Companion, 1) {
                name = "紙谷 憲"
                title = "部長"
                githubId = ""
                twitterId = ""
                description = ""
            }

            val SPEAKER_02 = DatabaseFactory.upsert(Speaker.Companion, 2) {
                name = "西田 綾佑"
                title = "ウルトラスーパーエンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }

            val SPEAKER_03 = DatabaseFactory.upsert(Speaker.Companion, 3) {
                name = "山内 洋典"
                title = "エンジニア"
                githubId = "youten"
                twitterId = "youten_redo"
                description = "組み込み系SIerの会社で十数年ほど働いた後、飽きたので退職。\n" +
                        "1年ほど無職を堪能した後、VTuberにハマり「モバイルでバーチャルアバター配信アプリを本気でやるよ」という話が楽しそうだったのでWFLEに2018年に入社。\n" +
                        "REALITYアプリのUnity・アバター部を担当。"
            }
            val SPEAKER_04 = DatabaseFactory.upsert(Speaker.Companion, 4) {
                name = "増住 啓吾"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_05 = DatabaseFactory.upsert(Speaker.Companion, 5) {
                name = "安川 貴志"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_06 = DatabaseFactory.upsert(Speaker.Companion, 6) {
                name = "髙橋 悠"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = "フィーチャーフォン向けのコンテンツ・ゲームエンジンの開発を3年。\n" +
                        "スマートフォン向けゲームエンジン開発を9年。\n" +
                        "並行して VR コンテンツ開発を 3 年。\n" +
                        "2018年にグリー入社。ライブエンターテインメント事業にて、主にモーションキャプチャーを担当。"
            }
            val SPEAKER_07 = DatabaseFactory.upsert(Speaker.Companion, 7) {
                name = "覚張 泰幸"
                title = "エンジニアマネージャー"
                githubId = ""
                twitterId = ""
                description = "『SINoALICE -シノアリス-』リードエンジニアとして立ち上げから参画。\n" +
                        "現在もリードエンジニアとしてエンジニアを統括している。\n" +
                        "\n" +
                        "ポケラボで携わったタイトル :\n" +
                        "・戦乱のサムライキングダム [エンジニア -> リードエンジニア]\n" +
                        "・新規アクションRPG(未リリース) [リードエンジニア]\n" +
                        "・SINoALICE -シノアリス- [リードエンジニア]\n" +
                        "\n" +
                        "2013年ポケラボ入社"
            }
            val SPEAKER_08 = DatabaseFactory.upsert(Speaker.Companion, 8) {
                name = "天野 雄太"
                title = "エンジニアチームマネージャ"
                githubId = ""
                twitterId = ""
                description = "2012年にグリー株式会社に入社。2014年より携帯ソーシャルゲーム運用・開発のチームに配属。2018年より同チームのエンジニアチームマネージャに就任。現在まで約6年間、長期運用タイトルにエンジニアとして携わる。趣味はテレビゲーム、動画鑑賞、英語の勉強。剣道四段、英検4級。"
            }
            val SPEAKER_09 = DatabaseFactory.upsert(Speaker.Companion, 9) {
                name = "大谷 俊平"
                title = "シニアマネージャー"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_10 = DatabaseFactory.upsert(Speaker.Companion, 10) {
                name = "村田 翔"
                title = "エンジニアチームマネージャ"
                githubId = "sakurahigashi2"
                twitterId = ""
                description = ""
            }
            val SPEAKER_11 = DatabaseFactory.upsert(Speaker.Companion, 11) {
                name = "田畠 知弥"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_12 = DatabaseFactory.upsert(Speaker.Companion, 12) {
                name = "矢﨑 雄人"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_13 = DatabaseFactory.upsert(Speaker.Companion, 13) {
                name = "駒﨑 拓斗"
                title = "エンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }
            val SPEAKER_14 = DatabaseFactory.upsert(Speaker.Companion, 14) {
                name = "石原 達馬"
                title = "データエンジニア"
                githubId = ""
                twitterId = ""
                description = ""
            }


            val SESSION_01 = DatabaseFactory.upsert(Session.Companion, 1) {
                startTime = 1574157622
                endTime = 1574163622
                title = "WFSエンジニア組織の振り返りとこれから〜コンテンツ開発に集中するために取り組んだこと〜"
                description = "WFSはスタジオ立ち上げから6年、「いかにゲームを面白くするか、どのように魅力的なゲームを作るか」のみを考えられるような開発体制を常に模索し続けてきた。内外の環境変化や組織の成熟度とともにその組織構成も徐々に変えてきているが、その中でも「挑戦する、何度でも。」のValueを体現すべく、主に組織横断的に取り組んできた事例について紹介する。また、今後のWFSのエンジニアリングの展望についても一部紹介する。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_01)
                tags = SizedCollection(TAG_WFS, TAG_ORGANIZATION, TAG_INFRASTRUCTURE)
            }

            val SESSION_02 = DatabaseFactory.upsert(Session.Companion, 2) {
                startTime = 1574157622
                endTime = 1574163622
                title = "Lua過激派！WFSにおけるイベントスクリプト活用法 〜すべてはより良いコンテンツ制作のために〜"
                description = "kms : イベントスクリプト活用例\n" +
                        "ららマジ : Excelでのアドベンチャーパート作成法と、改善案\n" +
                        "UnityによるLua活用例 : 新規製作中のゲームにおけるスクリプトエンジンの進化と展望"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_02)
                tags = SizedCollection(TAG_WFS, TAG_GAMEENGINE, TAG_LUA, TAG_RPG)
            }

            val SESSION_03 = DatabaseFactory.upsert(Session.Companion, 3) {
                startTime = 1574157622
                endTime = 1574163622
                title = "バーチャルライブ配信アプリREALITYの3Dアバターシステムの全容について"
                description = "REALITYは、3Dアバターをパーツ毎にカスタマイズし、フェイストラッキングを適用し、音声・チャット・3Dバーチャルアイテムのギフティングを用いて視聴者とコミュニケーションをとることがスマホ1台でできる、バーチャルライブ配信アプリです。\n" +
                        "そのREALITYにおける、3Dアバターシステムの全容について、「Unityにおける着せ替えの基本の仕組み」「OS別フェイストラッキングライブラリとアバターへの適用」「アップデートの歴史と対応してきた課題」の3テーマについて発表します。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_03)
                tags = SizedCollection(TAG_UNITY, TAG_ANDROID, TAG_IOS)
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
        }
    }
}