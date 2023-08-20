package com.example.githubapi.ui.pullRequestList

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.domain.User
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.Date

@Config(
    manifest = Config.NONE,
    sdk = [30]
)
@RunWith(RobolectricTestRunner::class)
class PullRequestCardKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pullRequestCardShouldBePresent() {
        val pr = PullRequest(
            id = 7684,
            url = "https://www.google.com/#q=ultrices",
            title = "alterum",
            state = "New Jersey",
            createdDate = Date(),
            closedDate = null,
            user = User(login = "gloriatur", userImage = "www.example.com/abc.jpg")
        )

        composeTestRule.setContent {
            PullRequestCard(pr)
        }
        composeTestRule.onNodeWithTag("pr_detail_card").assertExists()
        composeTestRule.onNodeWithText("alterum").assertExists()
    }
}