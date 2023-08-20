package com.example.githubapi.api

import com.example.githubapi.domain.PullRequest
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class GithubApiService(retrofit: Retrofit) {

    private val api: GithubApi = retrofit.create(GithubApi::class.java)

    suspend fun getAllClosedPRsOf(username: String, repo: String): List<PullRequest> {
        return api.getAllClosedPRsOf(username, repo)
    }
}

interface GithubApi {
    @GET("{username}/{repo}/pulls?state=closed")
    suspend fun getAllClosedPRsOf(
        @Path("username") username: String,
        @Path("repo") repo: String,
    ): List<PullRequest>
}