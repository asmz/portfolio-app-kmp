package beer.asmz.portfolio.kmp.ui.common.post

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import beer.asmz.portfolio.kmp.model.Post
import beer.asmz.portfolio.kmp.repository.ThumblrRepository
import beer.asmz.portfolio.kmp.type.TagType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale

class PostListViewModel(private val tag: TagType) : ViewModel() {
    private val repository = ThumblrRepository()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts

    companion object {
        const val LIMIT = 20
    }

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        _isLoading.update { true }

        viewModelScope.launch {
            val params = mapOf(
                "offset" to "0",
                "limit" to "$LIMIT",
                "tag" to tag.name.lowercase()
            )

            val response = repository.getPosts(params)
            _posts.update { response.posts }
            _isLoading.update { false }
        }
    }
}