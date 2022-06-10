package ru.myfirstapp.movieapp.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import ru.myfirstapp.movieapp.data.network.actor.ActorsApi
import ru.myfirstapp.movieapp.data.network.configuration.ConfigurationApi
import ru.myfirstapp.movieapp.data.network.movie.MoviesApi

object RetrofitModule {
    private const val baseUrl = "https://api.themoviedb.org/3/"
    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val moviesApi: MoviesApi = retrofit.create()
    val configurationApi: ConfigurationApi = retrofit.create()
    val actorsApi: ActorsApi = retrofit.create()
}
