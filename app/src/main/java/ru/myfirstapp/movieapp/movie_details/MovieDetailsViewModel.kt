package ru.myfirstapp.movieapp.movie_details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.myfirstapp.movieapp.data.Movie
import ru.myfirstapp.movieapp.data.loadMovies

class MovieDetailsViewModel(val app: Application, val movieId: Int) : AndroidViewModel(app) {

    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    val movie: LiveData<Movie> get() = _movie

    fun openMovieDetails() {
        viewModelScope.launch {
            val movies = loadMovies(app.applicationContext)
            val movie: Movie = movies.first {
                it.id == movieId
            }
            _movie.postValue(movie)
        }
    }
}