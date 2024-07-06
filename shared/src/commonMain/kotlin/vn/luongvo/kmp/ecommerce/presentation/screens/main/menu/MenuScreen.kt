package vn.luongvo.kmp.ecommerce.presentation.screens.main.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vn.luongvo.kmp.ecommerce.presentation.theme.AppTheme.dimensions

@Composable
fun MenuScreen() {
    MenuScreenContent()
}

@Composable
fun MenuScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This will be a product list to order",
            modifier = Modifier
                .padding(all = dimensions.spacingMedium)
        )
    }
}
