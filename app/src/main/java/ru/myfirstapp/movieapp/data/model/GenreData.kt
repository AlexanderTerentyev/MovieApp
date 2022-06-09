package ru.myfirstapp.movieapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GenreData(
    val id: Int,
    val name: String
)
