package ru.myfirstapp.movieapp.data.network.movie

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/top_rated")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = "6b4b0151a33d742a934a7bf86ee80d92",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Long,
        @Query("api_key") apiKey: String = "6b4b0151a33d742a934a7bf86ee80d92",
        @Query("language") language: String = "en-US",
        ): MovieDetailsResponse
}
