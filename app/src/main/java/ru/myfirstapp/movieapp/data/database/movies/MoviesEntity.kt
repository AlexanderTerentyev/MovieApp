package ru.myfirstapp.movieapp.data.database.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.myfirstapp.movieapp.data.database.MovieContract
import ru.myfirstapp.movieapp.domain.model.Genre

@Entity(tableName = MovieContract.Movies.TABLE_NAME)
data class MoviesEntity(
    @PrimaryKey
    @ColumnInfo(name = MovieContract.Movies.COLUMN_NAME_ID)
    val id: Long,
    @ColumnInfo(name = MovieContract.Movies.COLUMN_NAME_TITLE)
    val title: String,
    @ColumnInfo(name = MovieContract.Movies.COLUMN_NAME_OVERVIEW)
    val overview: String,
    @ColumnInfo(name = MovieContract.Movies.COLUMN_NAME_POSTER)
    val poster: String,
    @ColumnInfo(name = "backdrop")
    val backdrop: String,
    @ColumnInfo(name = "ratings")
    val ratings: Float,
    @ColumnInfo(name = "numberOfRatings")
    val numberOfRatings: Long,
    @ColumnInfo(name = "minimumAge")
    val minimumAge: Int,
    @ColumnInfo(name = "runtime")
    val runtime: Int,
//    @ColumnInfo(name = "genres")
//    val genres: List<Genre>,
)