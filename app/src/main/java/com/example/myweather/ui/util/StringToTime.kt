package com.example.myweather.ui.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.toDayName(): String {
    val date = LocalDate.parse(this)
    return date.dayOfWeek.toString().lowercase()
}

fun String.toLocalTime(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val localDateTime = LocalDateTime.parse(this, formatter)
    val utcZoned = localDateTime.atZone(ZoneId.of("UTC"))
    val localZoned: ZonedDateTime = utcZoned.withZoneSameInstant(ZoneId.systemDefault())
    val outputFormatter = DateTimeFormatter.ofPattern("hh:mm")
    return localZoned.format(outputFormatter)
}