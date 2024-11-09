package vn.luongvo.kmp.ecommerce.android.navigation

import vn.luongvo.kmp.ecommerce.android.base.BaseAppDestination

sealed class MenuAppDestination : BaseAppDestination() {

    object Menu : BaseAppDestination("menu")
}
