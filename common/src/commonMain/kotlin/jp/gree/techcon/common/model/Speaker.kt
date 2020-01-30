package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Speaker(
    val name: String,
    val title: String,
    val githubId: String,
    val twitterId: String,
    val description: String
) {
    companion object {
        fun getSample() = listOf(
            Speaker("Haruki Nakano", "Android Engineer", "haru067", "haru067", "最近はフィットネスと一体化しつつあります。"),
            Speaker("Takayuki Sei", "iOS Engineer", "", "tion-low", ""),
            Speaker("Masahiro Higuchi", "Backend Engineer", "aaaa", "", "少し長めの文章をここに試しに入力あいうえおかきくけこさしすせそくぁｗせｄｒｆｔｇｙふじこｌｐ；")
            ).random()
    }
}
