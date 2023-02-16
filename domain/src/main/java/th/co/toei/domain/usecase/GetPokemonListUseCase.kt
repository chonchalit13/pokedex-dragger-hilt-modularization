package th.co.toei.domain.usecase

import th.co.toei.core.base.BaseAsyncUseCase
import th.co.toei.core.base.Resource
import th.co.toei.domain.models.PokemonResponseModel
import th.co.toei.domain.repositories.MainRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val mainRepository: MainRepository) :
    BaseAsyncUseCase<Unit, PokemonResponseModel>() {
    override suspend fun execute(parameter: Unit): Resource<PokemonResponseModel> {
        return try {
            val response = mainRepository.getPokeList()
            if (isResponseSuccess(response)) {
                Resource.Success(response.body() ?: PokemonResponseModel())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}
