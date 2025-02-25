package beer.asmz.portfolio.kmp.api

import beer.asmz.portfolio.kmp.constant.TUMBLR_API_END_POINT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiClient {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend inline fun <reified T> get(params: Map<String, String>): ApiResult<T> {
        val httpResponse = httpClient.get(TUMBLR_API_END_POINT) {
            url {
                params.forEach {
                    parameters.append(it.key, it.value)
                }
            }
        }
        val httpStatus = httpResponse.status
        if (httpStatus.isSuccess()) {
            return ApiResult.Success(httpResponse.body<T>())
        }

        return ApiResult.Failure(Error("API Error. ${httpStatus.description}(${httpStatus.value})"))
    }
}