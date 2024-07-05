package vn.luongvo.kmp.ecommerce.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import vn.luongvo.kmp.ecommerce.presentation.AppViewModel
import vn.luongvo.kmp.ecommerce.presentation.MainApp
import vn.luongvo.kmp.ecommerce.presentation.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AppViewModel()
        setContent {
            MainApp(viewModel)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    AppTheme {
        GreetingView("Hello, Android!")
    }
}
