package beer.asmz.portfolio.kmp.ui.slide

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import beer.asmz.portfolio.kmp.R
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.type.PostTag
import beer.asmz.portfolio.kmp.ui.common.post.PostList
import beer.asmz.portfolio.kmp.ui.common.post.PostListViewModel

@Composable
fun SlideView() {
    Box(
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.beer),
                contentScale = ContentScale.Crop
            )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Slide")
                },
                backgroundColor = Color.White,
                contentColor = TextColor,
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
                .paint(
                    painterResource(id = R.drawable.beer),
                    contentScale = ContentScale.Crop
                ),
        ) {
            PostList(
                viewModel = PostListViewModel(tag = PostTag.Slide)
            )
        }
    }
}