package th.co.toei.pokedex.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import th.co.toei.core.base.BaseFragment
import th.co.toei.pokedex.adapter.PokedexAdapter
import th.co.toei.pokedex.dex.databinding.FragmentDexBinding

@AndroidEntryPoint
class DexFragment :
    BaseFragment<FragmentDexBinding, DexFragmentViewModel>(FragmentDexBinding::inflate) {

    override val vm: DexFragmentViewModel by viewModels()

    private lateinit var pokedexAdapter: PokedexAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewPokemonList
    }

    override fun init() {
        vm.getPokemonList()
    }

    override fun updateUI(view: View, savedInstanceState: Bundle?) {

    }

    override fun observer() {
        vm.pokemonListLiveData.observe(viewLifecycleOwner) {
            if (!::pokedexAdapter.isInitialized) {
                initAdapter()
            }

            pokedexAdapter.setListData(it)
        }
    }

    private fun initAdapter() {
        pokedexAdapter = PokedexAdapter()

        binding.recyclerViewPokemonList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = pokedexAdapter
        }
    }

    companion object {
        private var TAG = DexFragment::class.java.simpleName

        fun newInstance(): Fragment = DexFragment()
    }
}