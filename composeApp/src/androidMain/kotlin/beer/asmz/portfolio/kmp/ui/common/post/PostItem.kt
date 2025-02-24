package beer.asmz.portfolio.kmp.ui.common.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import beer.asmz.portfolio.kmp.constant.BlurGrayColor
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.model.Post

@Composable
fun PostItem(post: Post, onPress: ((post: Post) -> Unit)? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(BlurGrayColor, shape = RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .height(52.dp)
            .clickable(onClick = {
                onPress?.let { it(post) }
            })
            .padding(horizontal = 16.dp),
    ) {
        Text(post.content[0].title!!, color = TextColor)
    }
}

/*
@Preview
@Composable
fun PostItemPreview() {
    AppTheme {
        AccountItem(
            PostItem(
                service = "twitter",
                name = "_asmz",
                url = "https://x.com/_asmz"
            )
        )
    }
}
 */
