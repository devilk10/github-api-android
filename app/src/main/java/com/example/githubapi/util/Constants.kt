package com.example.githubapi.util

object Constants {
    const val BASE_URL = "https://api.github.com/repos/"

    object ErrorCodes {
        const val INVALID_RESPONSE = 100
        const val NO_INTERNET = 101
        const val INVALID_FORMAT = 102
        const val UNKNOWN_ERROR = 103
    }
}