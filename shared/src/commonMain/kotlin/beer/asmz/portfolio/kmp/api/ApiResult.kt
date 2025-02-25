package beer.asmz.portfolio.kmp.api

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Failure(val error: Error) : ApiResult<Nothing>()
}