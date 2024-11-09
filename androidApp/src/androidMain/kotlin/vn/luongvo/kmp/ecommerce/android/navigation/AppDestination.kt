package vn.luongvo.kmp.ecommerce.android.navigation

import vn.luongvo.kmp.ecommerce.android.base.BaseAppDestination

sealed class AppDestination : BaseAppDestination() {

    object MainNavGraph : BaseAppDestination("mainNavGraph")

    object Main : BaseAppDestination("main")
}
