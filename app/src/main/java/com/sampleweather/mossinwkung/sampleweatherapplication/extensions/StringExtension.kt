package com.sampleweather.mossinwkung.sampleweatherapplication.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val FORMAT_API = "yyyy-MM-dd HH:mm:ss"

fun String?.toDate(dateFormat: String = FORMAT_API): Date {
    try {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        val date = sdf.parse(this)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.time
    } catch (e: ParseException) {
        //For exception ,Will return Date() (current time on the device)
        return Date()
    } catch (e: NullPointerException) {
        //For exception ,Will return Date() (current time on the device)
        return Date()
    }
}

fun String?.toDatePlusHour(dateFormat: String = FORMAT_API, hour: Int = 0): Date {
    try {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())

        val date = sdf.parse(this)

        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR, hour)

        return calendar.time
    } catch (e: ParseException) {
        //For exception ,Will return Date() (current time on the device)
        return Date()
    } catch (e: NullPointerException) {
        //For exception ,Will return Date() (current time on the device)
        return Date()
    }
}
