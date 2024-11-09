package vn.luongvo.kmp.ecommerce.data.api

import io.ktor.client.call.body
import io.ktor.client.request.get
import vn.luongvo.kmp.ecommerce.data.model.MenuResponse
import vn.luongvo.kmp.ecommerce.data.model.PostResponse

suspend fun getPosts(): List<PostResponse> =
    httpClient.get("posts").body<List<PostResponse>>()

suspend fun getPhotos(): List<MenuResponse> =
    httpClient.get("photos").body<List<MenuResponse>>()
