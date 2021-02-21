package com.test.app.data.common

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(dateStr: String?): String? {
    val sdfFrom = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'", Locale.getDefault())
    val sdfTo = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
    return dateStr.let {
        sdfFrom.parse(dateStr ?: "")?.let {
            sdfTo.format(it)
        }
    }
}

fun maskNumber(number: String?): String {
    var masked = ""
    number?.let {
        if (number.length > 4) {
            masked = number.replaceRange(0, number.length - 4, "***")
        }
    }
    return masked
}
