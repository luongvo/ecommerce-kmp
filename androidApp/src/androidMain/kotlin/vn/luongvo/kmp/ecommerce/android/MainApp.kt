package vn.luongvo.kmp.ecommerce.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vn.luongvo.kmp.ecommerce.android.main.MainScreen
import vn.luongvo.kmp.ecommerce.android.theme.AppTheme
import vn.luongvo.kmp.ecommerce.android.theme.ComposeTheme

@Composable
fun MainApp(
    viewModel: AppViewModel,
    modifier: Modifier = Modifier,
) {
    ComposeTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = AppTheme.colors.themeColors.background,
        ) {
            MainScreen()
        }
    }
}
