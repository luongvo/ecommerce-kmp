package vn.luongvo.kmp.ecommerce

class DesktopPlatform : Platform {
    override val name: String = "Desktop"
    override val type: PlatformType = PlatformType.DESKTOP
}

actual fun getPlatform(): Platform = DesktopPlatform()
