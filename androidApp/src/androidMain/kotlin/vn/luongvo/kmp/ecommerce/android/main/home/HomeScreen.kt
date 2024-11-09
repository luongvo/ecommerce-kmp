package vn.luongvo.kmp.ecommerce.android.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import vn.luongvo.kmp.ecommerce.data.model.PostResponse
import vn.luongvo.kmp.ecommerce.android.theme.AppTheme.dimensions
import vn.luongvo.kmp.ecommerce.android.theme.ComposeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel(),
) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    HomeScreenContent(
        state.isLoading,
        state.posts,
        state.error,
    )
}

@Composable
fun HomeScreenContent(
    isLoading: Boolean,
    posts: List<PostResponse>,
    error: String?,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                item {
                    CircularProgressIndicator()
                }
            } else if (!error.isNullOrBlank()) {
                item {
                    Text(text = error)
                }
            } else {
                items(posts) { post ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // TODO
                            }
                            .padding(dimensions.spacingMedium)
                    ) {
                        Text(
                            text = post.title.orEmpty(),
                        )
                        Text(
                            text = post.body.orEmpty(),
                            color = Color.Gray,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ComposeTheme {
        HomeScreenContent(
            isLoading = false,
            posts = listOf(
                PostResponse(
                    id = "1",
                    userId = "1",
                    title = "title",
                    body = "body",
                )
            ),
            error = null,
        )
    }
}
