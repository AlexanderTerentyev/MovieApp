package ru.myfirstapp.movieapp.data.network.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("results")
    val movieList: List<MovieData>,
    @SerialName("total_pages")
    val totalPages: Long,
    val page: Long
)

@Serializable
data class MovieData(
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("genre_ids")
    val genreIDS: List<Long>,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("vote_count")
    val voteCount: Long,
    val adult: Boolean,
    val id: Long,
    val title: String,
    val overview: String
)
