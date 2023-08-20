package com.example.githubapi.repository

import com.example.githubapi.api.GithubApiService
import com.example.githubapi.api.Response
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.domain.User
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Date

@RunWith(JUnit4::class)
class PullRequestRepositoryTest {

    private lateinit var pullRequestRepository: PullRequestRepository
    private lateinit var mockGhService: GithubApiService

    @Before
    fun setUp() {
        mockGhService = mockk()
        pullRequestRepository = PullRequestRepository(mockGhService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun shouldReturnListOfPr() = runBlocking {
        val pullRequests = listOf(
            PullRequest(
                1L,
                url = "https://search.yahoo.com/search?p=senserit",
                title = "accusata",
                state = "Virginia",
                createdDate = Date(1212342314),
                closedDate = null,
                user = User(login = "persecuti", userImage = "finibus"),
            )
        )
        coEvery { mockGhService.getAllClosedPRsOf(any(), any()) } returns pullRequests
        val detailsOf = pullRequestRepository.getAllClosedPRsOf("", "")
        assertEquals(Response.Success(pullRequests), detailsOf)
    }

    @Test
    fun shouldReturnErrorResponseWhenServiceCallFails() = runBlocking {
        val pullRequests = listOf(
            PullRequest(
                1L,
                url = "https://search.yahoo.com/search?p=senserit",
                title = "accusata",
                state = "Virginia",

                createdDate = Date(1212342314),
                closedDate = null,
                user = User(login = "persecuti", userImage = "finibus"),
            )
        )
        coEvery { mockGhService.getAllClosedPRsOf(any(), any()) } throws Exception("")
        val detailsOf = pullRequestRepository.getAllClosedPRsOf("", "")
        assertEquals(Response.Error(100, ""), detailsOf)
    }
}