package vn.luongvo.kmp.ecommerce.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MenuResponse(
    val id: String?,
    val albumId: String?,
    val title: String?,
    val thumbnailUrl: String?,
    val url: String?,
)
