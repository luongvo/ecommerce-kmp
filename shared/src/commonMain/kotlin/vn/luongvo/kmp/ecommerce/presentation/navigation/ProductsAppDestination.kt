package vn.luongvo.kmp.ecommerce.presentation.navigation

import vn.luongvo.kmp.ecommerce.presentation.base.BaseAppDestination

sealed class ProductsAppDestination : BaseAppDestination() {

    object Products : BaseAppDestination("products")
}
