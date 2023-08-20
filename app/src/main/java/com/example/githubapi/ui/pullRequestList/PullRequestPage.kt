package com.example.githubapi.ui.pullRequestList

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullRequestPage(pullRequestViewModel: PullRequestViewModel) {
    return Scaffold(
        content = {
            val pullRequests = pullRequestViewModel.closedPrs.value
            LazyColumn {
                items(pullRequests) { pullRequest ->
                    PullRequestCard(pullRequest = pullRequest)
                }
            }
        }
    )
}