package th.co.toei.domain.repositories

import retrofit2.Response
import th.co.toei.domain.models.PokemonResponseModel

interface MainRepository {
    suspend fun getPokeList() : Response<PokemonResponseModel>
}
