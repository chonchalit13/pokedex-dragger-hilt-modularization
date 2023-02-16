package th.co.toei.core.base

import retrofit2.Response

abstract class BaseAsyncUseCase<in P, R> {
    abstract suspend fun execute(parameter: P): Resource<R>

    fun <T> isResponseSuccess(response: Response<T>): Boolean {
        return (response.code() == 200 && response.body() != null)
    }
}