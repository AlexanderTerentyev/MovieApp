package ru.myfirstapp.movieapp.data.database

import android.provider.BaseColumns

object MovieContract {
    const val DATABASE_NAME = "MoviesDataBase"

    object Movies {
        const val TABLE_NAME = "movies"

        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_POSTER = "poster"
    }
}