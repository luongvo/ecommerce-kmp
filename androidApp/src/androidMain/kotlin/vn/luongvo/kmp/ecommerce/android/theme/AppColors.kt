package vn.luongvo.kmp.ecommerce.android.theme

import androidx.compose.material3.*
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Base colors here
internal val GreenCitrus = Color(0xFF99CC00)

/**
 * Expand the final [Colors] class to provide more custom app colors.
 */
data class AppColors(
    val themeColors: ColorScheme,

    // Custom colors here
    val topAppBarBackground: Color = GreenCitrus
)

internal val LightColorPalette = AppColors(
    themeColors = lightColorScheme()
)

internal val DarkColorPalette = AppColors(
    themeColors = lightColorScheme()
)

internal val LocalAppColors = staticCompositionLocalOf { LightColorPalette }
