package ru.myfirstapp.movieapp.data.repository

import android.content.Context
import ru.myfirstapp.movieapp.data.database.MoviesDatabase
import ru.myfirstapp.movieapp.data.mapper.MovieMapperData
import ru.myfirstapp.movieapp.data.network.RetrofitModule
import ru.myfirstapp.movieapp.data.network.movie.MovieDetailsResponse
import ru.myfirstapp.movieapp.domain.model.Movie

class MovieRepository {
    suspend fun getMovies(): List<Movie> {
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        val movieDataList = RetrofitModule.moviesApi.getMovies().movieList
        return MovieMapperData.mapMovieDataListToDomain(movieDataList, baseUrl)
    }

    suspend fun getMovieById(movieId: Long): Movie {
        val movieDetails: MovieDetailsResponse = RetrofitModule.moviesApi.getMovieDetails(movieId)
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        return MovieMapperData.mapMovieDetailsDataToDomain(movieDetails, baseUrl)
    }

    suspend fun getMovieFromDatabase(context: Context): List<Movie> {
        val movieListEntity =  MoviesDatabase.create(context).movieListDao.getAllMovies()
        return MovieMapperData.mapListMoviesEntityToMovieList(movieListEntity)
    }

    suspend fun setMovieInDatabase(context: Context, movies: List<Movie>) {
        val movieListEntityFromDatabase = MovieMapperData.mapListMovieToListMovieEntity(movies)
        return MoviesDatabase.create(context).movieListDao.insert(movieListEntityFromDatabase)
    }
}
