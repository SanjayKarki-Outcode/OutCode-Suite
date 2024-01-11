package com.outcodesoftware.outcodesuite.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn

object DateAndTimeUtils {

    val now : Instant = Clock.System.now()
     val currentTimeSelected: LocalTime = now.toLocalDateTime(TimeZone.currentSystemDefault()).time

    val timeNow: String = "${currentTimeSelected.hour}:${currentTimeSelected.minute}:${currentTimeSelected.second}"
//    val timeNow: LocalTime = Instant.fromEpochMilliseconds(
//        Clock.System.now().epochSeconds
//    ).toLocalDateTime(TimeZone.currentSystemDefault()).time
    val today: LocalDate = Clock.System.todayIn(TimeZone.currentSystemDefault())





}