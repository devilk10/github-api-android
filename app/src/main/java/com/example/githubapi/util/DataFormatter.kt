package com.example.githubapi.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DataFormatter {

    fun formatDate(date: Date): String {
        val sdf = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

}