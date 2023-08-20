package com.example.githubapi.domain

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PullRequest(
    val id: Long,
    val url: String,
    val title: String,
    val state: String,
    @SerializedName("created_at") val createdDate: Date,
    @SerializedName("closed_at") val closedDate: Date?,
    @SerializedName("user") val user: User,
)

data class User(
    val login: String,
    @SerializedName("avatar_url") val userImage: String
)