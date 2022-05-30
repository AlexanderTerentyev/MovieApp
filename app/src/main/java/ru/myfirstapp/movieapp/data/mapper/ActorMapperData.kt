package ru.myfirstapp.movieapp.data.mapper

import ru.myfirstapp.movieapp.data.network.actor.ActorData
import ru.myfirstapp.movieapp.domain.model.Actor

object ActorMapperData {

    fun mapActorDataListToDomain(actorList: List<ActorData>, baseUrl: String): List<Actor> {
        return actorList.map { actorData ->
            mapActorDataToDomain(actorData, baseUrl)
        }
    }

    private fun mapActorDataToDomain(actorData: ActorData, baseUrl: String): Actor {
        return Actor(
            id = actorData.id,
            name = actorData.name,
            picture = "${baseUrl}original${actorData.profilePath}"
        )
    }
}