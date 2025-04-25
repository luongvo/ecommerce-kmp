package vn.luongvo.kmp.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.AppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.ProductIdKey
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.ProductsAppDestination
import vn.luongvo.kmp.ecommerce.presentation.screens.main.MainScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.product.ProductScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.product.ProductViewModel

// TODO provide via DI
val productViewModel = ProductViewModel()

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Main.destination,
        modifier = modifier,
    ) {
        composable(AppDestination.Main.route) {
            MainScreen(
                onNavigateToProduct = { product ->
                    navController.navigate(ProductsAppDestination.Product.createRoute(product.id).destination)
                }
            )
        }
        composable(ProductsAppDestination.Product.route) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString(ProductIdKey).orEmpty()

            ProductScreen(
                productId = productId,
                onClickBack = navController::navigateUp,
                viewModel = productViewModel,
            )
        }
    }
}
