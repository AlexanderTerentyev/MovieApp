package ru.myfirstapp.movieapp.domain.model

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val numberOfRatings: Long,
    val minimumAge: Int,
    val runtime: Int,
    val genres: List<Genre>
)
