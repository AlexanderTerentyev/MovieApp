package ru.myfirstapp.movieapp.data.mapper

import ru.myfirstapp.movieapp.data.model.GenreData
import ru.myfirstapp.movieapp.domain.model.Genre

object GenreMapperData {

    fun mapGenreDataListToDomain(genreList: List<GenreData>): List<Genre> {
        return genreList.map { genreData ->
            mapGenreDataToDomain(genreData)
        }
    }

    private fun mapGenreDataToDomain(genreData: GenreData): Genre {
        return Genre(
            id = genreData.id,
            name = genreData.name
        )
    }
}