package th.co.toei.core.di

import android.content.Context
import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import th.co.toei.common_utils.utils.BaseUrl
import th.co.toei.common_utils.utils.OKHttp
import th.co.toei.core.di.builder.RetrofitBuilder
import th.co.toei.data.network.EndpointInterface
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CONNECTION_TIME_OUT = 60L
    private const val READ_CONNECTION_TIME_OUT = 60L
    private const val WRITE_CONNECTION_TIME_OUT = 60L

    @Singleton
    @Provides
    fun provideGsonConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

    @OKHttp
    @Singleton
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(READ_CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideApiService(
        @BaseUrl baseUrl: String,
        @OKHttp okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): EndpointInterface =
        RetrofitBuilder(
            okHttpClient,
            converterFactory
        ).build(baseUrl)
}