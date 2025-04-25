package vn.luongvo.kmp.ecommerce.presentation.screens.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ecommerce_kmp.shared.generated.resources.Res
import ecommerce_kmp.shared.generated.resources.bottom_nav_account
import ecommerce_kmp.shared.generated.resources.bottom_nav_orders
import ecommerce_kmp.shared.generated.resources.bottom_nav_products
import ecommerce_kmp.shared.generated.resources.ic_nav_account
import ecommerce_kmp.shared.generated.resources.ic_nav_orders
import ecommerce_kmp.shared.generated.resources.ic_nav_products
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import vn.luongvo.kmp.ecommerce.presentation.base.BaseAppDestination
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.navigation.MainBottomNavGraph
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.AccountAppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.OrdersAppDestination
import vn.luongvo.kmp.ecommerce.presentation.navigation.destinations.ProductsAppDestination

@Composable
fun MainScreen(
    onNavigateToProduct: (ProductModel) -> Unit,
) {
    val bottomNavController: NavHostController = rememberNavController()
    val bottomNavItems = listOf(
//        AppBottomNavItem(
//            title = stringResource(Res.string.bottom_nav_home),
//            iconRes = Res.drawable.ic_nav_home,
//            appDestination = HomeAppDestination.Home,
//        ),
        AppBottomNavItem(
            title = stringResource(Res.string.bottom_nav_products),
            iconRes = Res.drawable.ic_nav_products,
            appDestination = ProductsAppDestination.Products
        ),
        AppBottomNavItem(
            title = stringResource(Res.string.bottom_nav_orders),
            iconRes = Res.drawable.ic_nav_orders,
            appDestination = OrdersAppDestination.Orders
        ),
        AppBottomNavItem(
            title = stringResource(Res.string.bottom_nav_account),
            iconRes = Res.drawable.ic_nav_account,
            appDestination = AccountAppDestination.Account
        ),
    )

    Scaffold(
        bottomBar = {
            AppBottomNavigation(
                bottomNavItems = bottomNavItems,
                navController = bottomNavController,
                navigator = { destination ->
                    bottomNavController.navigate(destination.destination) {
                        popUpTo(bottomNavController.graph.findStartDestination().route.orEmpty()) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    ) { innerPadding ->
        MainBottomNavGraph(
            navController = bottomNavController,
            onNavigateToProduct = onNavigateToProduct,
//                    modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
        )
    }


//    Box(modifier = Modifier.fillMaxSize().padding(32.dp)) {
//        if (state.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier.align(Alignment.Center)
//            )
//        } else {
//            val text by rememberSaveable { mutableStateOf(state.text) }
//            Text(
//                text = text,
//                modifier = Modifier.align(Alignment.Center),
//                textAlign = TextAlign.Center,
//                fontSize = 24.sp
//            )
//        }
//        Button(
//            onClick = onClick,
//            modifier = Modifier.align(Alignment.BottomCenter),
//            enabled = state.isLoading.not()
//        ) {
//            Text(text = "Let's rock!", fontSize = 18.sp)
//        }
//    }
}

@Composable
private fun AppBottomNavigation(
    bottomNavItems: List<AppBottomNavItem>,
    navController: NavController,
    navigator: (BaseAppDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
//        containerColor = colors.containerColor,
//        contentColor = colors.contentColor,
//        tonalElevation = MainBottomNavigationDefaults.Elevation,
        modifier = modifier,
    ) {
        bottomNavItems.forEach { item ->
            val isSelected = currentDestination?.route == item.appDestination.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navigator(item.appDestination)
                },
                icon = {
                    Icon(
                        painter = painterResource(item.iconRes),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = item.title,
//                        style = if (isSelected) styles.selectedTextStyle else styles.unselectedTextStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = colors.itemColors.selectedIconColor,
//                    selectedTextColor = colors.itemColors.selectedTextColor,
//                    indicatorColor = colors.itemColors.indicatorColor,
//                    unselectedIconColor = colors.itemColors.unselectedIconColor,
//                    unselectedTextColor = colors.itemColors.unselectedTextColor,
//                    disabledIconColor = colors.itemColors.disabledIconColor,
//                    disabledTextColor = colors.itemColors.disabledTextColor
                )
            )
        }
    }
}

data class AppBottomNavItem(
    val title: String,
    val iconRes: DrawableResource,
    val appDestination: BaseAppDestination,
)
