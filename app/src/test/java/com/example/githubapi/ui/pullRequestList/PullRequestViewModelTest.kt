package com.example.githubapi.ui.pullRequestList

import com.example.githubapi.api.Response
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.domain.User
import com.example.githubapi.repository.PullRequestRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Date

@RunWith(JUnit4::class)
class PullRequestViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val pullRequestRepo = mockk<PullRequestRepository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun shouldSetErrorTrueWhenResponseIsError() = runTest {
        coEvery { pullRequestRepo.getAllClosedPRsOf(any(), any()) } returns Response.Error(100, "")
        val pullRequestViewModel = PullRequestViewModel(pullRequestRepo)
        assertEquals(pullRequestViewModel.error.value, true)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun shouldSetClosedPRWhenResponseIsSuccess() = runTest {
        val pullRequests = listOf(
            PullRequest(
                id = 8429,
                url = "http://www.bing.com/search?q=neque",
                title = "nonumy",
                state = "Guam Gu",
                createdDate = Date(),
                closedDate = null,
                user = User(login = "mollis", userImage = "cubilia")
            )
        )
        coEvery { pullRequestRepo.getAllClosedPRsOf(any(), any()) } returns Response.Success(
            pullRequests
        )
        val pullRequestViewModel = PullRequestViewModel(pullRequestRepo)
        assertEquals(pullRequestViewModel.error.value, false)
        assertEquals(pullRequestViewModel.closedPrs.value, pullRequests)
    }
}