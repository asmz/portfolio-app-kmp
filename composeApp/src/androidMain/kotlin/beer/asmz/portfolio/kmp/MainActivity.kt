package beer.asmz.portfolio.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import beer.asmz.portfolio.kmp.ui.AppTheme
import beer.asmz.portfolio.kmp.ui.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Box(Modifier.safeDrawingPadding()) {
                AppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        AppNavHost()
                    }
                }
            }
        }
    }
}