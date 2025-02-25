package beer.asmz.portfolio.kmp.repository

import beer.asmz.portfolio.kmp.api.ApiClient
import beer.asmz.portfolio.kmp.api.ApiResult
import beer.asmz.portfolio.kmp.model.PostResponse
import beer.asmz.portfolio.kmp.model.PostResponseBody

class ThumblrRepository {
    private val apiClient = ApiClient()

    @Throws(Throwable::class)
    suspend fun getPosts(params: Map<String, String>): PostResponseBody {
        val queryParams = params.plus(mapOf(Pair("npf", "true")))

        when (val result = apiClient.get<PostResponse>(queryParams)) {
            is ApiResult.Success -> {
                return result.data.response
            }

            is ApiResult.Failure -> {
                throw result.error
            }
        }
    }
}