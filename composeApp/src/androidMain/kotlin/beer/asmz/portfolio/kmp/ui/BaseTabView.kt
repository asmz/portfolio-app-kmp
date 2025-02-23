package beer.asmz.portfolio.kmp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import beer.asmz.portfolio.kmp.constant.AccentColor
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.type.TabType
import beer.asmz.portfolio.kmp.ui.blog.BlogView
import beer.asmz.portfolio.kmp.ui.profile.ProfileView
import beer.asmz.portfolio.kmp.ui.slide.SlideView

@Composable
fun BaseTabView() {
    val nestedNavController = rememberNavController()
    val navBackStackEntry by nestedNavController.currentBackStackEntryAsState()
    val currentTab = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
            ) {
                TabType.entries.forEachIndexed { index, tab ->
                    BottomNavigationItem(
                        unselectedContentColor = TextColor,
                        selectedContentColor = AccentColor,
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) },
                        selected = currentTab == tab.id,
                        onClick = { nestedNavController.navigate(tab.id) }
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(
                navController = nestedNavController,
                startDestination = "base/profile",
                modifier = Modifier,
            ) {
                composable("base/profile") {
                    ProfileView()
                }
                composable("base/blog") {
                    BlogView()
                }
                composable("base/slide") {
                    SlideView()
                }
            }
        }
    }
}

@Preview
@Composable
fun BaseTabViewPreview() {
    AppTheme {
        BaseTabView()
    }
}
