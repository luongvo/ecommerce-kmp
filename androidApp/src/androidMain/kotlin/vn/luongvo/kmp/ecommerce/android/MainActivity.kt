package vn.luongvo.kmp.ecommerce.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AppViewModel()
        setContent {
            MainApp(viewModel)
        }
    }
}
