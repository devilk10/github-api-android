package com.example.githubapi.ui.pullRequestList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapi.api.Response
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.repository.PullRequestRepository
import kotlinx.coroutines.launch

class PullRequestViewModel(private val pullRequestRepo: PullRequestRepository) : ViewModel() {
    val closedPrs = mutableStateOf<List<PullRequest>>(listOf())
    val error = mutableStateOf(false)

    init {
        loadAllPullRequestsFor()
    }

    private fun loadAllPullRequestsFor(
        username: String = "AdevintaSpain",
        repo: String = "Barista"
    ) {
        viewModelScope.launch {
            when (val detailsOf = pullRequestRepo.getAllClosedPRsOf(username, repo)) {
                is Response.Error -> error.value = true
                Response.Loading -> {}
                is Response.Success -> {
                    closedPrs.value = detailsOf.data
                }
            }
        }
    }
}
