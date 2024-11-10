package vn.luongvo.kmp.ecommerce

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import vn.luongvo.kmp.ecommerce.presentation.AppViewModel
import vn.luongvo.kmp.ecommerce.presentation.MainApp

fun MainViewController(): UIViewController {
    val viewModel = AppViewModel()
    return ComposeUIViewController {
        MainApp(viewModel)
    }
}
