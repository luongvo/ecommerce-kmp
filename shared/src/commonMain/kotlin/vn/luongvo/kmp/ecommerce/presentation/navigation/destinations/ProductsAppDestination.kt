package vn.luongvo.kmp.ecommerce.presentation.navigation.destinations

import androidx.navigation.NavType
import androidx.navigation.navArgument
import vn.luongvo.kmp.ecommerce.presentation.base.BaseAppDestination

const val ProductIdKey = "ProductIdKey"

sealed class ProductsAppDestination : BaseAppDestination() {

    object Products : BaseAppDestination("products")

    object Product : BaseAppDestination("product/{$ProductIdKey}") {
        override val arguments = listOf(
            navArgument(ProductIdKey) { type = NavType.StringType },
        )

        fun createRoute(productId: String) = apply {
            destination = "product/$productId"
        }
    }
}
