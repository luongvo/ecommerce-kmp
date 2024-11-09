package vn.luongvo.kmp.ecommerce.android.main

import android.graphics.drawable.Drawable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vn.luongvo.kmp.ecommerce.android.R
import vn.luongvo.kmp.ecommerce.android.base.BaseAppDestination
import vn.luongvo.kmp.ecommerce.android.navigation.AccountAppDestination
import vn.luongvo.kmp.ecommerce.android.navigation.HomeAppDestination
import vn.luongvo.kmp.ecommerce.android.navigation.MainBottomNavGraph
import vn.luongvo.kmp.ecommerce.android.navigation.MenuAppDestination
import vn.luongvo.kmp.ecommerce.android.navigation.OrdersAppDestination

@Composable
fun MainScreen() {
    val bottomNavController: NavHostController = rememberNavController()
    val bottomNavItems = listOf(
        AppBottomNavItem(
            title = stringResource(R.string.bottom_nav_home),
            iconRes = R.drawable.ic_nav_home,
            appDestination = HomeAppDestination.Home,
        ),
        AppBottomNavItem(
            title = stringResource(R.string.bottom_nav_menu),
            iconRes = R.drawable.ic_nav_menu,
            appDestination = MenuAppDestination.Menu
        ),
        AppBottomNavItem(
            title = stringResource(R.string.bottom_nav_orders),
            iconRes = R.drawable.ic_nav_orders,
            appDestination = OrdersAppDestination.Orders
        ),
        AppBottomNavItem(
            title = stringResource(R.string.bottom_nav_account),
            iconRes = R.drawable.ic_nav_account,
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
            navHostController = bottomNavController,
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
    val iconRes: Int,
    val appDestination: BaseAppDestination,
)
