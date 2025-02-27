package beer.asmz.portfolio.kmp.ui.common.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import beer.asmz.portfolio.kmp.constant.AccentColor
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.ui.common.error.ApiErrorAlert

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostList(
    viewModel: PostListViewModel,
    onPressItem: ((post: Post) -> Unit)? = null
) {
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { viewModel.refresh() }
    )
    Box(
        modifier = Modifier
            .pullRefresh(pullRefreshState)
            .background(Color.Transparent)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp),
        ) {
            items(posts, key = { it.idString }) { post ->
                PostItem(post = post, onPressItem = onPressItem)
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (isLoading && !isRefreshing) {
                        CircularProgressIndicator(
                            modifier = Modifier.width(32.dp),
                            color = AccentColor,
                        )
                    }
                }
            }
            item {
                LaunchedEffect(true) {
                    viewModel.fetchPosts()
                }
            }
        }
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter),
            contentColor = AccentColor,
        )
    }

    if (error != null) {
        ApiErrorAlert(error!!) {
            viewModel.hideErrorAlert()
        }
    }
}
