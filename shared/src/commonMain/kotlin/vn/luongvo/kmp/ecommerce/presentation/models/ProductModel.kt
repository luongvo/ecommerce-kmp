package vn.luongvo.kmp.ecommerce.presentation.models

import vn.luongvo.kmp.ecommerce.data.model.ProductResponse

data class ProductModel(
    val id: String,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating?,
) {
    data class Rating(
        val rate: Double,
        val count: Int,
    )
}

fun ProductResponse.toModel() = ProductModel(
    id = id.orEmpty(),
    title = title.orEmpty(),
    price = price ?: 0.0,
    description = description.orEmpty(),
    category = category.orEmpty(),
    image = image.orEmpty(),
    rating = rating?.run {
        ProductModel.Rating(
            rate = rate ?: 0.0,
            count = count ?: 0,
        )
    },
)
