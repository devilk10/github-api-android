package com.example.githubapi

import com.example.githubapi.api.GithubApiService
import com.example.githubapi.repository.PullRequestRepository
import com.example.githubapi.ui.pullRequestList.PullRequestViewModel
import com.example.githubapi.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {
    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    private val prRepo = PullRequestRepository(GithubApiService(retrofit))
    val prViewModel = PullRequestViewModel(prRepo)
}
