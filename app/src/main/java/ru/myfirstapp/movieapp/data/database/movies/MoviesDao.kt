package ru.myfirstapp.movieapp.data.database.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies():List<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movies: List<MoviesEntity>)
}
