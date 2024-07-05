import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import vn.luongvo.kmp.ecommerce.presentation.AppViewModel
import vn.luongvo.kmp.ecommerce.presentation.MainApp

fun main() = application {
    val viewModel = AppViewModel()
    Window(title = "ecommerce-kmp", onCloseRequest = ::exitApplication) {
        MainApp(viewModel)
    }
}
