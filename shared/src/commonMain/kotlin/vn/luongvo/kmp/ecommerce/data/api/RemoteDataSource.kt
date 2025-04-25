package vn.luongvo.kmp.ecommerce.data.api

import io.ktor.client.call.body
import io.ktor.client.request.get
import vn.luongvo.kmp.ecommerce.data.model.PostResponse
import vn.luongvo.kmp.ecommerce.data.model.ProductResponse

suspend fun getPosts(): List<PostResponse> =
    httpClient.get("posts").body<List<PostResponse>>()

suspend fun getProducts(): List<ProductResponse> =
    httpClient.get("products").body<List<ProductResponse>>()
