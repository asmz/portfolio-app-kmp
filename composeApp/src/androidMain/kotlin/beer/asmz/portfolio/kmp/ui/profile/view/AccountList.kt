package beer.asmz.portfolio.kmp.ui.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import beer.asmz.portfolio.kmp.ui.AppTheme

@Composable
fun AccountList() {
    val data = listOf("a", "b", "c", "b", "c", "b", "c", "b", "c")

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.forEach {
            AccountItem(it)
        }
    }
}

@Preview
@Composable
fun AccountListPreview() {
    AppTheme {
        AccountList()
    }
}
