package th.co.toei.data.repositories

import retrofit2.Response
import th.co.toei.data.network.EndpointInterface
import th.co.toei.domain.models.PokemonResponseModel
import th.co.toei.domain.repositories.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: EndpointInterface) : MainRepository {
    override suspend fun getPokeList(): Response<PokemonResponseModel> = apiService.getPokemonList()
}
