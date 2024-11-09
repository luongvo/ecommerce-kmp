package vn.luongvo.kmp.ecommerce.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: String?,
    val userId: String?,
    val title: String?,
    val body: String?,
)
