package beer.asmz.portfolio.kmp.ui.slide

import androidx.compose.runtime.Composable
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.type.TagType
import beer.asmz.portfolio.kmp.ui.common.post.PostList
import beer.asmz.portfolio.kmp.ui.common.post.PostListViewModel

@Composable
fun SlideView() {
    val onPress: ((post: Post) -> Unit) = { post ->
        println("~~~~~~~~~~~~~~ from SlideView: $post")
    }
    PostList(
        viewModel = PostListViewModel(tag = TagType.Slide),
        onPress = onPress
    )
}