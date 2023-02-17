package th.co.toei.pokedex_dragger_hilt_modularization.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import th.co.toei.pokedex.presenter.DexFragment
import th.co.toei.pokedex_dragger_hilt_modularization.R
import th.co.toei.pokedex_dragger_hilt_modularization.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.frameLayout.id, DexFragment.newInstance())
            .commit()
    }
}