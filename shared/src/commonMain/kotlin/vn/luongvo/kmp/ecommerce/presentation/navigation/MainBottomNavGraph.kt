package vn.luongvo.kmp.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vn.luongvo.kmp.ecommerce.presentation.screens.main.home.AccountScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.home.HomeScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.home.MenuScreen
import vn.luongvo.kmp.ecommerce.presentation.screens.main.home.OrdersScreen

@Composable
fun MainBottomNavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeAppDestination.Home.destination,
        modifier = modifier,
    ) {
        composable(HomeAppDestination.Home.route) {
            HomeScreen()
        }
        composable(MenuAppDestination.Menu.route) {
            MenuScreen()
        }
        composable(OrdersAppDestination.Orders.route) {
            OrdersScreen()
        }
        composable(AccountAppDestination.Account.route) {
            AccountScreen()
        }
    }
}
