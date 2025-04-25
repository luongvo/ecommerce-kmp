package vn.luongvo.kmp.ecommerce.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val id: String?,
    val title: String?,
    val price: Double?,
    val description: String?,
    val category: String?,
    val image: String?,
    val rating: Rating?,
) {
    @Serializable
    data class Rating(
        val rate: Double?,
        val count: Int?,
    )
}
