package vn.luongvo.kmp.ecommerce.android.main.account

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
fun AccountScreen() {
    AccountScreenContent()
}

@Composable
fun AccountScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile and Logout",
            modifier = Modifier
                .padding(all = dimensions.spacingMedium)
        )
    }
}
