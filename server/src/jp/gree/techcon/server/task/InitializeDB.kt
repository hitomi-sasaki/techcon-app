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

            val SESSION_04 = DatabaseFactory.upsert(Session.Companion, 4) {
                startTime = 1574157622
                endTime = 1574163622
                title = "REALITY低遅延モード配信を支えるリアルタイムサーバとデータパイプライン"
                description = "バーチャル配信アプリ「REALITY」の低遅延モード配信機能が2020年1月8日に正式リリースされました。\n" +
                        "本機能の開発にあたり、「ラグなし・ギガ安・高画質」の配信・視聴体験を実現した上で、バックエンドのスケーラビリティと安定性を追求するために新規に構築したライブ配信基盤において、\n" +
                        "その中核をなすふたつのコンポーネントである「コンテナベースのリアルタイムサーバ」と「Apache Beamによるストリーミングデータパイプライン」についてご紹介します。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_04)
                tags = SizedCollection(TAG_LIVE, TAG_REALTIMESERVER, TAG_KUBERNETES, TAG_DATAPIPELINE, TAG_APACHEBEAM)
            }

            val SESSION_05 = DatabaseFactory.upsert(Session.Companion, 5) {
                startTime = 1574157622
                endTime = 1574163622
                title = "RealityStudio Motion Engineについて"
                description = "「連絡取れないですね」\n" +
                        "時は年末、某開発スタジオ。\n" +
                        "モーションキャプチャーを稼働させるために必要不可欠としてきたミドルウェアが突如サービス停止との一報が届く。\n" +
                        "「リミットはあと3ヶ月か…」\n" +
                        "サービス停止とは即ちキャプチャーシステムの停止である。\n" +
                        "「ミドルウェアを独自開発するしかない」\n" +
                        "ミドルウェアの多機能化、多すぎる設定項目見直し、高度に複雑化していく番組内容、さいげんなく増えていく端末管理、、、これらもまとめて解消したいという思い。\n" +
                        "限られた時間に反するように項目だけが増えていく、、、\n" +
                        "REALITY Studioが所持しているキャプチャーシステムの停止だけは絶対に阻止しなければならない。\n" +
                        "そしてミドルウェア「REALITY Studio Motion Engine」は完成した。\n" +
                        "そこで本日は「REALITY Studio Motion Engine」について紹介を致します。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_05, SPEAKER_06)
                tags = SizedCollection(TAG_UNITY, TAG_UNREALENGINE4, TAG_MOTIONCAPTURE, TAG_WFLE)
            }

            val SESSION_06 = DatabaseFactory.upsert(Session.Companion, 6) {
                startTime = 1574157622
                endTime = 1574163622
                title = "大規模タイトルの長期運営におけるエンジニアリング的工夫 - ソーシャルアプリで世界と人を変える為にエンジニアが出来るコト -"
                description = "設立から10年を越え、数々のHitタイトルに恵まれ弊社ポケラボには様々なエンジニアリングノウハウが蓄積されております。過去, 運用中のタイトルで行った様々な工夫を今回ご紹介させて頂きます。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_07)
                tags = SizedCollection(TAG_PHP, TAG_OPERATION)
            }

            val SESSION_07 = DatabaseFactory.upsert(Session.Companion, 7) {
                startTime = 1574157622
                endTime = 1574163622
                title = "長寿タイトルの運営の歴史"
                description = "10年もの歴史を刻んできたソーシャルゲーム内製タイトルを運用しつづけている私たち。技術的な観点において、10年の道のりは平坦ではなかった。歴史あるレガシーアプリケーションに対し、私たちが直面した問題とそれをどう乗り越えたかを紹介する。また、今後さらに長期間運用を続ける上で現在抱えている課題や、生き残り続けるための展望も一部紹介する。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_08)
                tags = SizedCollection(TAG_SOCIALGAME, TAG_LAMP, TAG_LONGHIT, TAG_LONGTERM, TAG_LEGACY)
            }

            val SESSION_08 = DatabaseFactory.upsert(Session.Companion, 8) {
                startTime = 1574157622
                endTime = 1574163622
                title = "モバイルゲーム。移管と運営のエンジニア"
                description = "ファンプレックス株式会社ではモバイルゲーム運営事業を行っています。\n" +
                        "ゲーム運営のプロフェッショナルとして、開発会社からゲームタイトルを移管し運営を行う上で必要な事・ファンプレックスが大事にしていることをエンジニア視点にて紹介させていただきます。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_09)
                tags = SizedCollection(TAG_SOCIALGAME, TAG_MOBILEGAME, TAG_DEVELOPMENT, TAG_MIGRATION, TAG_RUN, TAG_ENGINEER, TAG_ENGINEERING)
            }

            val SESSION_09 = DatabaseFactory.upsert(Session.Companion, 9) {
                startTime = 1574157622
                endTime = 1574163622
                title = "NuxtJS + REST APIで運用中サービスをNuxt.js + GraphQLに変更したことによる光と影"
                description = "アウモ株式会社では記事メディア「aumo」だけではなく、横断比較できるサービスの開発を行なっています。\n" +
                        "REST APIで実装していたところを一部サービスについては全面的にGraphQLに書き換えを行い、そこで得た知見について紹介します。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_10)
                tags = SizedCollection(TAG_FRONTEND, TAG_VUEJS, TAG_NUXTJS, TAG_GRAPHQL)
            }

            val SESSION_10 = DatabaseFactory.upsert(Session.Companion, 10) {
                startTime = 1574157622
                endTime = 1574163622
                title = "LIMIAアプリにおける行動履歴を用いたコンテンツ配信の最適化"
                description = "「おてがる工夫で家事上手」をコンセプトにした、家事情報のアプリ「LIMIA」では、毎日ユーザーさんに楽しんでもらうために、様々なコンテンツを配信しています。ユーザーさんに喜ばれるコンテンツを配信するためには、ユーザーさんのアプリ内の行動を正しく知る必要があります。\n" +
                        "このセッションでは、アプリ内でユーザーさんがどのようなコンテンツに興味を持ったのかをトラッキングする仕組みから、実際にそのトラッキングデータを元にユーザーに最適なコンテンツの配信するシステムまでを紹介します。\n" +
                        "具体的には、アプリ内でのユーザーのトラッキングに関しては、コンテンツのvCTRを計測するライブラリの開発、Firebase Analyticsを利用したイベント送信についてを、\n" +
                        "コンテンツの配信システムに関しては、配信するコンテンツを決めるレコメンド処理のパイプラインの紹介、実際の業務でどうやってレコメンドの改善を行うかについてお話しします。\n"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_11, SPEAKER_12)
                tags = SizedCollection(TAG_FIREBASE, TAG_BIGQUERY, TAG_NATIVEAPP, TAG_IOS, TAG_ANDROID, TAG_MACHINELEANING, TAG_AWS)
            }

            val SESSION_11 = DatabaseFactory.upsert(Session.Companion, 11) {
                startTime = 1574157622
                endTime = 1574163622
                title = "ホストベースからコンテナベースへのワークロード移行に求められるインフラエンジニアの役割"
                description = "オンプレミス時代、クラウド活用時代、クラウドネイティブ時代といった Web技術の変遷に伴い、グリーグループのサービスを提供するインフラは変化を続けています。インフラ部門のアプリケーション開発サイドに向き合うチームとして、ゲームタイトルのリリースと運用に関わってきた経験を元に、急激な変化を続けているインフラエンジニアの役割と課題について発表します。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_13)
                tags = SizedCollection(TAG_DEVOPS, TAG_ORGANIZATION, TAG_INFRA, TAG_AWS, TAG_GCP, TAG_KUBERNETES)
            }

            val SESSION_12 = DatabaseFactory.upsert(Session.Companion, 12) {
                startTime = 1574157622
                endTime = 1574163622
                title = "任意話者間声質変換の研究開発"
                description = "任意の話者から任意の話者への声質変換をニューラルネットを用いて実装する。特に入力話者に関して事前に発話が入手できず、対象話者の音声サンプルが1発話しかない場合でも動作するように学習の設定を工夫する。"
                slideUrl = ""
                movieUrl = ""
                speakers = SizedCollection(SPEAKER_14)
                tags = SizedCollection(TAG_DEEPLEARNING, TAG_VOICECONVERSION)
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