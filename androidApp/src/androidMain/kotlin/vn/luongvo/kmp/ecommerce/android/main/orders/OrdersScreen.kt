package vn.luongvo.kmp.ecommerce.android.main.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vn.luongvo.kmp.ecommerce.android.theme.AppTheme.dimensions

@Composable
fun OrdersScreen() {
    OrdersScreenContent()
}

@Composable
fun OrdersScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This will be a order list",
            modifier = Modifier
                .padding(all = dimensions.spacingMedium)
        )
    }
}
