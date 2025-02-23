package beer.asmz.portfolio.kmp.ui.profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import beer.asmz.portfolio.kmp.R
import beer.asmz.portfolio.kmp.constant.BlurGrayColor
import beer.asmz.portfolio.kmp.constant.SubTextColor
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.model.Account
import beer.asmz.portfolio.kmp.ui.AppTheme

@Composable
fun AccountItem(account: Account) {
    val urlHandler = LocalUriHandler.current
    val onClick: () -> Unit = {
        urlHandler.openUri(account.url)
    }
    val context = LocalContext.current
    val drawableId = remember(account.service) {
        context.resources.getIdentifier(
            account.service,
            "drawable",
            context.packageName
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(BlurGrayColor, shape = RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .height(52.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(drawableId),
                contentDescription = account.service,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(account.name, color = TextColor)
        }
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Default.OpenInNew,
                contentDescription = "link",
                colorFilter = ColorFilter.tint(SubTextColor)
            )
        }
    }
}

@Preview
@Composable
fun AccountItemPreview() {
    AppTheme {
        AccountItem(
            Account(
                service = "twitter",
                name = "_asmz",
                url = "https://x.com/_asmz"
            )
        )
    }
}
