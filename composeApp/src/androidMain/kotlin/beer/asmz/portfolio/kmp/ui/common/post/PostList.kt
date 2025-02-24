package beer.asmz.portfolio.kmp.ui.common.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import beer.asmz.portfolio.kmp.model.Post

@Composable
fun PostList(
    viewModel: PostListViewModel,
    onPress: ((post: Post) -> Unit)? = null
) {
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    LazyColumn {
        items(posts) { post ->
            PostItem(post = post, onPress = onPress)
        }
    }
}
