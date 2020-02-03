package jp.gree.techcon.common

import com.squareup.sqldelight.db.SqlDriver

internal expect fun driver(name: String?): SqlDriver

expect object Platform {
    internal val isIos: Boolean
    internal val localhost: String
}
