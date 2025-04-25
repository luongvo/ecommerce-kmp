package vn.luongvo.kmp.ecommerce.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vn.luongvo.kmp.ecommerce.presentation.navigation.AppNavGraph
import vn.luongvo.kmp.ecommerce.presentation.theme.AppTheme
import vn.luongvo.kmp.ecommerce.presentation.theme.ComposeTheme

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
            AppNavGraph()
        }
    }
}
