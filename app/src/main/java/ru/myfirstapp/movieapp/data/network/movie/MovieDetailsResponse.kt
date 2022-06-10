package ru.myfirstapp.movieapp.data.network.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.myfirstapp.movieapp.data.model.GenreData

@Serializable
data class MovieDetailsResponse(
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("vote_count")
    val voteCount: Long,
    val genres: List<GenreData>,
    val id: Long,
    val runtime: Long,
    val title: String,
    val overview: String,
    val adult: Boolean
    )
