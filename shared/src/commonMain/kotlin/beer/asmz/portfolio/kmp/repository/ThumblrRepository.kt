package beer.asmz.portfolio.kmp.repository

import beer.asmz.portfolio.kmp.api.ApiClient
import beer.asmz.portfolio.kmp.model.PostResponse
import beer.asmz.portfolio.kmp.model.PostResponseBody

class ThumblrRepository {
    private val apiClient = ApiClient()

    suspend fun getPosts(params: Map<String, String>): PostResponseBody {
        val queryParams = params.plus(mapOf(Pair("npf", "true")))

        val result = apiClient.get<PostResponse>(queryParams)
        return result.response
    }
}