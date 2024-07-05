package vn.luongvo.kmp.ecommerce.presentation.navigation

import vn.luongvo.kmp.ecommerce.presentation.base.BaseAppDestination

sealed class MenuAppDestination : BaseAppDestination() {

    object Menu : BaseAppDestination("menu")
}
