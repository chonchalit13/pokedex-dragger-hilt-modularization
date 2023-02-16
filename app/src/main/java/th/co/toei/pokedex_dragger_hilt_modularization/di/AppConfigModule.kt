package th.co.toei.pokedex_dragger_hilt_modularization.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import th.co.toei.common_utils.utils.BaseUrl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppConfigModule {

    @Singleton
    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://run.mocky.io/"
}

