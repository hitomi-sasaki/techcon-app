package jp.gree.techcon.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val name: String
) {
    companion object {
        fun getSample() = listOf(
            Tag("iOS"),
            Tag("Android"),
            Tag("Web"),
            Tag("インフラ"),
            Tag("Kotlin"),
            Tag("PHP"),
            Tag("go"),
            Tag("Swift"),
            Tag("Kubernetes"),
            Tag("GCP"),
            Tag("AWS"),
            Tag("Laravel"),
            Tag("Ktor"),
            Tag("Unity"),
            Tag("teraform")
        ).random()
    }
}
