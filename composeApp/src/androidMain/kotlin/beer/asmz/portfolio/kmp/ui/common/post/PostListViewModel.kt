package beer.asmz.portfolio.kmp.ui.common.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.repository.ThumblrRepository
import beer.asmz.portfolio.kmp.type.PostTag
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostListViewModel(private val tag: PostTag) : ViewModel() {
    companion object {
        const val LIMIT = 20
    }

    private val repository = ThumblrRepository()
    private var offset = 0
    private var hasNext = true

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?> get() = _error

    fun fetchPosts() {
        if (!hasNext || _isLoading.value) return
        _error.update { null }
        _isLoading.update { true }

        viewModelScope.launch {
            val params = mapOf(
                "offset" to "$offset",
                "limit" to "$LIMIT",
                "tag" to tag.name.lowercase()
            )

            try {
                val response = repository.getPosts(params)
                _posts.update { it + response.posts }
                offset += LIMIT
                hasNext = response.totalPosts > _posts.value.count()
            } catch (throwable: Throwable) {
                _error.update { throwable }
                hasNext = false
            } finally {
                _isLoading.update { false }
                _isRefreshing.update { false }
            }
        }
    }

    fun refresh() {
        _isRefreshing.update { true }
        _posts.update { emptyList() }
        offset = 0
        hasNext = true

        fetchPosts()
    }

    fun hideErrorAlert() {
        _error.update { null }
    }
}