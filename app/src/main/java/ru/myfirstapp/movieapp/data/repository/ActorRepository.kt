package ru.myfirstapp.movieapp.data.repository

import ru.myfirstapp.movieapp.data.mapper.ActorMapperData
import ru.myfirstapp.movieapp.data.network.RetrofitModule
import ru.myfirstapp.movieapp.data.network.actor.ActorData
import ru.myfirstapp.movieapp.domain.model.Actor

class ActorRepository {
    suspend fun getActorsByMovieId(movieId: Long): List<Actor> {
        val actorList: List<ActorData> = RetrofitModule.actorsApi.getActors(movieId).cast
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        return ActorMapperData.mapActorDataListToDomain(actorList = actorList, baseUrl)
    }
}