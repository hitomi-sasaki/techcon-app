package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val id: Long,
    val name: List<Speaker>,
    val startTime: Long,
    val endTime: Long,
    val title: String,
    val description: String,
    val tagList: List<String>,
    val slideUrl: String? = null,
    val movieUrl: String? = null
) {
    companion object {
        fun getSample(): Session {
            val speakers = listOf(Speaker.getSample(), Speaker.getSample())
            val title = getSampleTitle()
            val description = getSampleDescription()
            val slideUrl = getSampleSlideUrl()
            val movieUrl = getSampleMovieUrl()
            val tagList = listOf(getSampleTag(), getSampleTag())
            return Session(1, speakers, 1574157622, 1574157622 + 6000, title, description, tagList, slideUrl, movieUrl)
        }

        fun getSampleTag() = listOf(
            "iOS",
            "Android",
            "Web",
            "インフラ",
            "Kotlin",
            "PHP",
            "go",
            "Swift",
            "Kubernetes",
            "GCP",
            "AWS",
            "Laravel",
            "Ktor",
            "Unity",
            "teraform"
        ).random()

        fun getDummyList(): List<Session> {
            val session = Session(-1, listOf(Speaker.getSample()), 1574157622, 1574157622 + 6000, "", "", listOf(), "", "")
            return MutableList(100) { session.copy(id = it.toLong(), title = getSampleTitle(), description = getSampleDescription()) }
        }

        private fun getSampleTitle() = listOf(
            "PHPからgoへの移行で分かったこと",
            "エンジニア以外の方が自らSQLを使ってセグメント分析を行うカルチャーをどのように作っていったか",
            "あなたたちの中で罪を犯したことのない者が、まず、この広告SDK開発者に石を投げなさい。"
            ).random()

        private fun getSampleDescription() = listOf(
            """弊社バックエンドは、PHPエンジニアのみで開発を行なっていました。
PHPからgoへの移行を行ったところ、トレーニング、開発環境構築、障害対応など想定外の問題が発生しました。
時代の流れとともに、goへの移行が選択肢に上がるケースが増えて来ているかと思います。
これらの知見を共有することで、goに移行した方が良いケースと悪いケースを明らかにしたいと思います。

【アジェンダ】
* 移行前後のシステム構成
* PHPエンジニアがgolangを学ぶ時にハマりがちなこと
* golangに移行して良かった点
* 改めて分かったPHPの良さ
""",
            """リミアでは私達のチームが中心となって分析基盤を更新し、企画運営担当がSQLを使って自分が欲しい情報を分析できるようにしました。これにより、コンテンツやユーザに対する理解が深まり、KPIや業務効率の改善に繋がりました。
エンジニア以外の方が自らSQLを使ってセグメント分析を行う分析基盤やカルチャーをどのように作っていったか、またその結果どのような成果を達成できたか、そして当初の目論見と異なった点について説明します。""",
            """iOSエンジニアという職業にはiOSアプリケーション開発をしている人間だけではなく、インターネット広告のサービスを利用するためのSDKを開発している人間も含まれております。
このセッションでは、モバイル向け広告SDKを開発/運用しているエンジニアの考えていることや、開発する上で大事にしていること、課題に感じていること、開発の方法などを発表します。"""

        ).random()
        private fun getSampleSlideUrl() = listOf(
            "https://www.slideshare.net/greetech/phpgo-200234954",
            "https://www.slideshare.net/greetech/sql-203319046",
            "https://www.slideshare.net/greetech/developer-boost-2019-200228479",
            "https://www.slideshare.net/greetech/gcp-195118124",
            "https://www.slideshare.net/greetech/meetup-6-jamboard",
            "https://www.slideshare.net/greetech/ss-173178300",
            "https://www.slideshare.net/greetech/realityvtuber1"
        ).random()

        private fun getSampleMovieUrl() = listOf(
            "https://www.youtube.com/watch?v=PD4lWpEXE2Q",
            "https://www.youtube.com/watch?v=qad2CqdgjzU",
            "https://www.youtube.com/watch?v=A0Ro_f5kzc8"
        ).random()
    }
}
