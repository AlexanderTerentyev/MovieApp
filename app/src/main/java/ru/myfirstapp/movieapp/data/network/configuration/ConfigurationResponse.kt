package ru.myfirstapp.movieapp.data.network.configuration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationResponse(
    val images: ImagesResponse
)

@Serializable
data class ImagesResponse(
    @SerialName("secure_base_url")
    val baseUrl: String
)

