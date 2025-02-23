package beer.asmz.portfolio.kmp.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import beer.asmz.portfolio.kmp.constant.AccentColor
import beer.asmz.portfolio.kmp.constant.LightGrayColor

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = AccentColor,
            secondary = LightGrayColor
        ),
        content = content
    )
}