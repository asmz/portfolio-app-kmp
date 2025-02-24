package beer.asmz.portfolio.kmp.api

import beer.asmz.portfolio.kmp.constant.TUMBLR_API_END_POINT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
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

    suspend inline fun <reified T> get(params: Map<String, String>): T {
        return httpClient.get(TUMBLR_API_END_POINT) {
            url {
                params.forEach {
                    parameters.append(it.key, it.value)
                }
            }
        }.body<T>()
    }
}