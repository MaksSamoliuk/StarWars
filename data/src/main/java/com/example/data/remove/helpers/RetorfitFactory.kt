package com.example.data.remove.helpers
import com.example.data.remove.services.HeroesService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class RetorfitFactory {
companion object {
    val baseUrl = "https://swapi.dev/api/"

    private fun getOkHttpInstance(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
@UnstableDefault
    private fun getRetrofitClien() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttpInstance())
            .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaType()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
@UnstableDefault
fun getHeroesService( )= RetorfitFactory.getRetrofitClien().create(HeroesService::class.java)


    }
}