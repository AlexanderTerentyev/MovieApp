package ru.myfirstapp.movieapp.data.mapper

import ru.myfirstapp.movieapp.data.network.movie.MovieData
import ru.myfirstapp.movieapp.data.network.movie.MovieDetailsResponse
import ru.myfirstapp.movieapp.domain.model.Movie

object MovieMapperData {
    fun mapMovieDataListToDomain(movieList: List<MovieData>, baseUrl: String): List<Movie> {
        return movieList.map { movieData ->
            mapMovieDataToDomain(movieData, baseUrl)
        }
    }

    fun mapMovieDetailsDataToDomain(movieDetailsResponse: MovieDetailsResponse, baseUrl: String): Movie {
        return Movie(
            id = movieDetailsResponse.id,
            title = movieDetailsResponse.title,
            overview = movieDetailsResponse.overview,
            poster = "${baseUrl}original${movieDetailsResponse.posterPath}",
            backdrop = "${baseUrl}original${movieDetailsResponse.backdropPath}",
            ratings = movieDetailsResponse.voteAverage,
            numberOfRatings = movieDetailsResponse.voteCount,
            minimumAge = if (movieDetailsResponse.adult) 16 else 13,
            runtime = 0, //TODO()
            genres = GenreMapperData.mapGenreDataListToDomain(movieDetailsResponse.genres)
        )
    }

    private fun mapMovieDataToDomain(movieData: MovieData, baseUrl: String): Movie {
        return Movie(
            id = movieData.id,
            title = movieData.title,
            overview = movieData.overview,
            poster = "${baseUrl}original${movieData.posterPath}",
            backdrop = "${baseUrl}original${movieData.backdropPath}",
            ratings = movieData.voteAverage,
            numberOfRatings = movieData.voteCount,
            minimumAge = if (movieData.adult) 16 else 13,
            runtime = 0, //TODO()
            genres = emptyList(), // TODO()
        )
    }
}