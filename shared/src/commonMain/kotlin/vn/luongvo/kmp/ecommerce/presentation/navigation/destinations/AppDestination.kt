package vn.luongvo.kmp.ecommerce.presentation.navigation.destinations

import vn.luongvo.kmp.ecommerce.presentation.base.BaseAppDestination

sealed class AppDestination : BaseAppDestination() {

    object MainNavGraph : BaseAppDestination("mainNavGraph")

    object Main : BaseAppDestination("main")
}
