package ru.myfirstapp.movieapp.data.network.configuration

import retrofit2.http.GET
import retrofit2.http.Query

interface ConfigurationApi {
    @GET("configuration")
    suspend fun getConfiguration(
        @Query("api_key")
        apiKey: String = "6b4b0151a33d742a934a7bf86ee80d92",
    ): ConfigurationResponse
}
