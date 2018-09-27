package com.sampleweather.mossinwkung.sampleweatherapplication.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val FORMAT_API = "yyyy-MM-dd HH:mm:ss"
const val FORMAT_API_24_HOUR = "yyyy-MM-dd HH:mm:ss a"

fun String.checkOneDay(): Boolean {
    val dateFormat = SimpleDateFormat(FORMAT_API, Locale.getDefault())
    val timeZone = TimeZone.getDefault()
    dateFormat.timeZone = TimeZone.getTimeZone(timeZone.displayName)

    var calendar = Calendar.getInstance()
    calendar.add(Calendar.HOUR, 24)
    val currentTime = Calendar.getInstance().time
    val nextDay = calendar.time
    val dataDate = dateFormat.parse(this)

    return nextDay.time > dataDate.time && dataDate.time > currentTime.time
}

fun String.changeFormatDate(): String {
    var newDateFormat = ""

    val readDateFormat = SimpleDateFormat(FORMAT_API, Locale.getDefault())
    val writeDateFormat = SimpleDateFormat(FORMAT_API_24_HOUR, Locale.ENGLISH)

    var date = readDateFormat.parse(this)

    if (date != null) {
        newDateFormat = writeDateFormat.format(date)
    }

    return newDateFormat
}
