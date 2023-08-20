package com.example.githubapi.ui.pullRequestList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githubapi.domain.PullRequest
import com.example.githubapi.util.DataFormatter.formatDate

@Composable
fun PullRequestCard(pullRequest: PullRequest) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .testTag("pr_detail_card"),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = pullRequest.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Created by: ${pullRequest.user.login}",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .fillMaxSize()
                        .align(Alignment.CenterVertically),
                    painter = rememberImagePainter(pullRequest.user.userImage),
                    contentDescription = "user_avatar"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Created at: ${formatDate(pullRequest.createdDate)}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Closed on: ${pullRequest.closedDate?.let { formatDate(it) }}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }
    }
}
