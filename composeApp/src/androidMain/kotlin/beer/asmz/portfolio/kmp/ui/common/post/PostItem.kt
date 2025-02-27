package beer.asmz.portfolio.kmp.ui.common.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import beer.asmz.portfolio.kmp.R
import beer.asmz.portfolio.kmp.constant.BlurGrayColor
import beer.asmz.portfolio.kmp.constant.LightGrayColor
import beer.asmz.portfolio.kmp.constant.SubTextColor
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.model.PostContent
import beer.asmz.portfolio.kmp.model.PostContentPoster
import beer.asmz.portfolio.kmp.ui.AppTheme
import beer.asmz.portfolio.kmp.ui.common.chrome_tabs.launchCustomTabs
import coil3.compose.AsyncImage
import java.net.URL
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@Composable
fun PostItem(post: Post, onPressItem: ((post: Post) -> Unit)? = null) {
    val context = LocalContext.current

    val content = remember { post.content[0] }
    val poster = remember { content.poster?.get(0) }
    val hostname = remember { URL(content.url).host }
    val formattedDate = remember {
        val instant = Instant.ofEpochSecond(post.timestamp.toLong())
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        dtf.format(localDateTime)
    }

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(BlurGrayColor, shape = RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .clickable(onClick = {
                onPressItem?.let { onPress ->
                    onPress(post)
                } ?: run {
                    context.launchCustomTabs(content.url)
                }
            })
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            if (poster != null) {
                AsyncImage(
                    model = poster.url,
                    placeholder = painterResource(R.drawable.no_image),
                    contentDescription = content.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 112.dp, height = 88.dp)
                        .padding(end = 16.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.no_image),
                    contentDescription = "no image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 112.dp, height = 88.dp)
                        .padding(end = 16.dp)
                )
            }
            Column {
                Text(
                    text = content.title ?: "",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(hostname, color = SubTextColor)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            post.tags.forEach { tag ->
                Text(
                    text = "#$tag",
                    color = SubTextColor,
                    modifier = Modifier
                        .background(LightGrayColor, shape = RoundedCornerShape(5.dp))
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Text(formattedDate, color = SubTextColor)
    }
}


@Preview
@Composable
fun PostItemPreview() {
    val post = Post(
        idString = "111",
        timestamp = 1672531200,
        tags = listOf("blog", "contribution"),
        content = listOf(
            PostContent(
                type = "link",
                description = "test description",
                title = "test title abc def ghi jkl mno pqr stu vwx yz - 123 456 789 0",
                url = "https://asmz.beer",
                poster = listOf(
                    PostContentPoster(url = "https://static.tumblr.com/nibuxm5/Q0yo2heyn/beer.jpg")
                )
            )
        )
    )

    AppTheme {
        PostItem(post)
    }
}
