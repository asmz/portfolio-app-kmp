package beer.asmz.portfolio.kmp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import beer.asmz.portfolio.kmp.ui.BaseTabView

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "base"
) {
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(route = "base", startDestination = "base/entry") {
            composable("base/entry") {
                BaseTabView()
            }
        }
    }
}