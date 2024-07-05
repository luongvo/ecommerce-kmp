package vn.luongvo.kmp.ecommerce

interface Platform {
    val name: String
    val type: PlatformType
}

expect fun getPlatform(): Platform

enum class PlatformType {
    ANDROID, IOS, DESKTOP
}
