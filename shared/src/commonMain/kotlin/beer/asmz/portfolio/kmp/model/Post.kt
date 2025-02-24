package beer.asmz.portfolio.kmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val response: PostResponseBody
)

@Serializable
data class PostResponseBody(
    val posts: List<Post>,
    @SerialName("total_posts") val totalPosts: Int
)

@Serializable
data class Post(
    @SerialName("id_string") val idString: String,
    val timestamp: Int,
    val tags: List<String>,
    val content: List<PostContent>
)

@Serializable
data class PostContent(
    val type: String,
    val description: String? = null,
    val title: String? = null,
    val url: String? = null,
    val poster: List<PostContentPoster>? = null
)

@Serializable
data class PostContentPoster(
    val url: String
)
