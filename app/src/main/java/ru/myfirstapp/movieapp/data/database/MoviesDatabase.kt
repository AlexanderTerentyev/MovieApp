package ru.myfirstapp.movieapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.myfirstapp.movieapp.data.database.movies.MoviesDao
import ru.myfirstapp.movieapp.data.database.movies.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 3)
internal abstract class MoviesDatabase : RoomDatabase() {

    abstract val movieListDao: MoviesDao

    companion object {
        fun create(context: Context): MoviesDatabase {
            return Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                MovieContract.DATABASE_NAME
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
