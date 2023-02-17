package th.co.toei.domain.usecase

import retrofit2.Response
import th.co.toei.domain.models.state.Resource

abstract class BaseAsyncUseCase<in P, R> {
    abstract suspend fun execute(parameter: P): Resource<R>

    fun <T> isResponseSuccess(response: Response<T>): Boolean {
        return (response.code() == 200 && response.body() != null)
    }
}