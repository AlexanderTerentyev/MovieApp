package ru.myfirstapp.movieapp.data.network.actor

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorsApi {
    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") id: Long,
        @Query("api_key") apiKey: String = "6b4b0151a33d742a934a7bf86ee80d92",
        @Query("language") language: String = "en-US",
    ): ActorsResponse
}
