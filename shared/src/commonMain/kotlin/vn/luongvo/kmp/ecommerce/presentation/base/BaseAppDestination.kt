package vn.luongvo.kmp.ecommerce.presentation.base

import androidx.navigation.NamedNavArgument

abstract class BaseAppDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    open var destination: String = route

    open var parcelableArgument: Pair<String, Any?>? = null

    data class Up(
        val results: HashMap<String, Any> = hashMapOf(),
    ) : BaseAppDestination() {

        fun put(key: String, value: Any) = apply {
            results[key] = value
        }
    }
}
