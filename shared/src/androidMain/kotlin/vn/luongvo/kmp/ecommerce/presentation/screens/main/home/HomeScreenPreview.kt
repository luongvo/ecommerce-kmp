package vn.luongvo.kmp.ecommerce.presentation.screens.main.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import vn.luongvo.kmp.ecommerce.data.model.PostResponse
import vn.luongvo.kmp.ecommerce.presentation.theme.ComposeTheme

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
