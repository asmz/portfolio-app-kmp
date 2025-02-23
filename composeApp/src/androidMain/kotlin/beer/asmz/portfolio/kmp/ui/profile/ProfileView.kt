package beer.asmz.portfolio.kmp.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import beer.asmz.portfolio.kmp.R
import beer.asmz.portfolio.kmp.ui.AppTheme
import beer.asmz.portfolio.kmp.ui.profile.view.AccountList
import beer.asmz.portfolio.kmp.ui.profile.view.Nameplate

@Composable
fun ProfileView() {
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.beer),
                    contentScale = ContentScale.Crop
                )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 30.dp)
                .padding(horizontal = 32.dp),
        ) {
            Nameplate()
            AccountList()
        }
    }
}

@Preview
@Composable
fun ProfileViewPreview() {
    AppTheme {
        ProfileView()
    }
}
