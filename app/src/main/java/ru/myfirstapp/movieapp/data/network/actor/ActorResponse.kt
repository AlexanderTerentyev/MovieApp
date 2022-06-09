package ru.myfirstapp.movieapp.data.network.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorsResponse(
    val id: Long,
    val cast: List<ActorData>
)

@Serializable
data class ActorData(
    val id: Long,
    val name: String,
    @SerialName("profile_path")
    val profilePath: String?,
)
