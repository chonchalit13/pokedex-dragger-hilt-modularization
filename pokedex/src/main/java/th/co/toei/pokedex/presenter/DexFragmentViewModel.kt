package th.co.toei.pokedex.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import th.co.toei.core.base.BaseViewModel
import th.co.toei.domain.models.Card
import th.co.toei.domain.models.state.Resource
import th.co.toei.domain.usecase.GetPokemonListUseCase
import javax.inject.Inject

@HiltViewModel
class DexFragmentViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase) :
    BaseViewModel() {

    val pokemonListLiveData: MutableLiveData<MutableList<Card>> = MutableLiveData()

    fun getPokemonList() {
        viewModelScope.launch {
            loadingLiveData.postValue(true)
            val result = withContext(Dispatchers.IO) {
                getPokemonListUseCase.execute(Unit)
            }

            when (result) {
                is Resource.Success -> {
                    loadingLiveData.postValue(false)
                    pokemonListLiveData.postValue(result.data.cards)
                }
                is Resource.Error -> {
                    loadingLiveData.postValue(false)
                    errorMessageLiveData.postValue(result.exception)
                }
            }
        }
    }
}