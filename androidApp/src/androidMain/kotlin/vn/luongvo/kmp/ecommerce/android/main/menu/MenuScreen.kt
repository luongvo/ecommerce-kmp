package vn.luongvo.kmp.ecommerce.android.main.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import vn.luongvo.kmp.ecommerce.data.model.MenuResponse
import vn.luongvo.kmp.ecommerce.android.theme.AppTheme.dimensions

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = MenuViewModel(),
) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadMenus()
    }

    MenuScreenContent(
        state.isLoading,
        state.menus,
        state.error,
    )
}

@Composable
fun MenuScreenContent(
    isLoading: Boolean,
    menus: List<MenuResponse>,
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
                items(menus) { menu ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(dimensions.spacingSmall),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // TODO
                            }
                            .padding(dimensions.spacingMedium)
                    ) {
                        AsyncImage(
                            menu.thumbnailUrl.orEmpty(),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )

                        Text(
                            text = menu.title.orEmpty(),
                        )
                    }
                }
            }
        }
    }
}
