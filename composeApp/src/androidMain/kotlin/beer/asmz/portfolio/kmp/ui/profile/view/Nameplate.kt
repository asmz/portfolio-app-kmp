package beer.asmz.portfolio.kmp.ui.profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beer.asmz.portfolio.kmp.R
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.ui.AppTheme

@Composable
fun Nameplate() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(36.dp),
        modifier = Modifier
            .padding(top = 150.dp, bottom = 50.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "avatar",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(48.dp))
            )
            Text(
                text = "asmz",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor,
            )
            Text(
                text = "Akira.Shimizu",
                color = TextColor,
            )
        }
        Text(
            text = "純東北産麦芽系エンジニア",
            color = TextColor,
        )
    }
}

@Preview
@Composable
fun NameplatePreview() {
    AppTheme {
        Nameplate()
    }
}
