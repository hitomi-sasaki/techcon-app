package jp.gree.techcon.common.util

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.soywiz.klock.KlockLocale
import com.soywiz.klock.hours
import com.soywiz.klock.locale.japanese

// To resolve format issue on klock
internal object AppDateTime {
    fun parseToArticleTime(timeSecond: Long): String {
        val dt = DateTime.fromUnix(timeSecond * 1000) + 9.hours
        val amOrPm = dt.format(defaultFormat("a")).toUpperCase()
        return "${getHourMin(dt)} $amOrPm"
    }

    fun parseToArticleDate(timeSecond: Long): String {
        val dt = DateTime.fromUnix(timeSecond * 1000) + 9.hours
        val e = dt.format(defaultFormat("（EEE）"))
        val day = dt.format(defaultFormat("dd日")).replaceFirst("^0+(?!$)".toRegex(), "")
        val month = dt.format(defaultFormat("MM月")).replaceFirst("^0+(?!$)".toRegex(), "")
        return "$month$day$e"
    }

    fun parseToTimeDuration(startSecond: Long, endSecond: Long): String {
        val dt = DateTime.fromUnix(startSecond * 1000) + 9.hours
        val dt2 = DateTime.fromUnix(endSecond * 1000) + 9.hours
        return "${getHourMin(dt)} - ${getHourMin(dt2)}"
    }

    private fun getHourMin(dateTime: DateTime): String {
        val hh = dateTime.format(defaultFormat("hh")).replaceFirst("^0+(?!$)".toRegex(), "")
        val mm = dateTime.format(defaultFormat("mm"))
        return "$hh:$mm"
    }

    private fun defaultFormat(pattern: String) =
        DateFormat(pattern).withLocale(KlockLocale.japanese)
}

