package th.co.toei.pokedex.adapter

import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import th.co.toei.common_utils.extensions.loadImage
import th.co.toei.domain.models.Card
import th.co.toei.pokedex.dex.databinding.ViewHolderPokemonListBinding

class PokedexAdapter : RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    private var pokemonList: MutableList<Card> = mutableListOf()

    private val starRarity = String(Character.toChars(0x2B50))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewHolderPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(pokemonList[position], position)
    }

    override fun getItemCount(): Int = pokemonList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewHolderPokemonListBinding.bind(view)

        fun bindView(mItem: Card, position: Int) {
            var damage = 0
            var rarity = ""

            binding.cardView.preventCornerOverlap =
                itemView.resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT

            mItem.attacks.forEach {
                damage += it.damage.toIntOrNull() ?: 0
            }

            val str = damage - mItem.weaknesses.size

            binding.tvPokemonName.text = mItem.name
            binding.progressHp.progress = mItem.hp
            binding.progressStr.progress = str
            binding.progressWeak.progress = mItem.weaknesses.size * 10

            for (i in 1..mItem.rarity) {
                rarity += starRarity
            }

            binding.tvRarity.text = rarity
            binding.imgPokemon.loadImage(
                mItem.imageUrl, ContextCompat.getDrawable(
                    binding.imgPokemon.context,
                    resource.R.drawable.ic_broken
                )!!
            )
        }
    }

    fun setListData(response: MutableList<Card>) {
        pokemonList.clear()
        pokemonList.addAll(response)
        notifyDataSetChanged()
    }
}