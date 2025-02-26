package beer.asmz.portfolio.kmp.ui.slide

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import beer.asmz.portfolio.kmp.constant.TextColor
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.type.PostTag
import beer.asmz.portfolio.kmp.ui.common.post.PostList
import beer.asmz.portfolio.kmp.ui.common.post.PostListViewModel

@Composable
fun SlideView() {
    val onPress: ((post: Post) -> Unit) = { post ->
        println("~~~~~~~~~~~~~~ from SlideView: $post")
    }

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
        Box(modifier = Modifier.padding(innerPadding)) {
            PostList(
                viewModel = PostListViewModel(tag = PostTag.Slide),
                onPress = onPress
            )
        }
    }
}