package vn.luongvo.kmp.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.AccountAppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.HomeAppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.OrdersAppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.ProductsAppDestination
import vn.luongvo.kmp.ecommerce.presentation.screens.main.account.AccountScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.home.HomeScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.orders.OrdersScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.products.ProductsScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.products.ProductsViewModel

// TODO provide via DI
val productsViewModel = ProductsViewModel()

@Composable
fun MainBottomNavGraph(
    navController: NavHostController,
    onNavigateToProduct: (ProductModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = ProductsAppDestination.Products.destination,
        modifier = modifier,
    ) {
        composable(HomeAppDestination.Home.route) {
            HomeScreen()
        }
        composable(ProductsAppDestination.Products.route) {
            ProductsScreen(
                onProductClick = onNavigateToProduct,
                viewModel = productsViewModel,
            )
        }
        composable(OrdersAppDestination.Orders.route) {
            OrdersScreen()
        }
        composable(AccountAppDestination.Account.route) {
            AccountScreen()
        }
    }
}
