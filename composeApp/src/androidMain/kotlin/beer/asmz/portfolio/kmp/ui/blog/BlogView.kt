package beer.asmz.portfolio.kmp.ui.blog

import androidx.compose.runtime.Composable
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.type.PostTag
import beer.asmz.portfolio.kmp.ui.common.post.PostList
import beer.asmz.portfolio.kmp.ui.common.post.PostListViewModel

@Composable
fun BlogView() {
    val onPress: ((post: Post) -> Unit) = { post ->
        println("~~~~~~~~~~~~~~ from BlogView: $post")
    }
    PostList(
        viewModel = PostListViewModel(tag = PostTag.Blog),
        onPress = onPress
    )
}