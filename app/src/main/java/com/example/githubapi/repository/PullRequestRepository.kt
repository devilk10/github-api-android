package com.example.githubapi.repository

import com.example.githubapi.api.GithubApiService
import com.example.githubapi.api.Response
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.util.Constants

class PullRequestRepository(private val ghApiService: GithubApiService) {

    suspend fun getAllClosedPRsOf(username: String, repo: String): Response<List<PullRequest>> {
        return try {
            val pullRequests = ghApiService.getAllClosedPRsOf(username, repo)
            Response.Success(pullRequests)
        } catch (e: Exception) {
            Response.Error(Constants.ErrorCodes.INVALID_RESPONSE, e.localizedMessage ?: "")
        }
    }
}
