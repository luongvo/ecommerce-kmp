package vn.luongvo.kmp.ecommerce.android.base

abstract class BaseAppDestination(val route: String = "") {

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
