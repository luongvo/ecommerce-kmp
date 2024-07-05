package vn.luongvo.kmp.ecommerce

import androidx.compose.ui.window.ComposeUIViewController
import vn.luongvo.kmp.ecommerce.presentation.AppViewModel
import vn.luongvo.kmp.ecommerce.presentation.MainApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val viewModel = AppViewModel()
    return ComposeUIViewController {
        MainApp(viewModel)
    }
}
