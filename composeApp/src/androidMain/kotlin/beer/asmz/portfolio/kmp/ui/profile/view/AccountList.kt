package beer.asmz.portfolio.kmp.ui.profile.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import beer.asmz.portfolio.kmp.model.Account
import beer.asmz.portfolio.kmp.ui.AppTheme

@Composable
fun AccountList() {
    val accounts = Account.getAccountList()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        accounts.forEach { account ->
            AccountItem(account)
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
