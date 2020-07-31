package com.tonykalo.githubapp.utils.extensions

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatServerDateToDate(): String {
    var formattedDate = ""
    try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
        val date = inputFormat.parse(this)
        formattedDate = outputFormat.format(date!!)
    } catch (e: Exception) { }
    return formattedDate
}
