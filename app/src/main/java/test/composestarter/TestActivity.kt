package test.composestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import test.composestarter.ui.theme.ComposeStarterTheme


class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainScreen()
                }
            }
        }
    }
}