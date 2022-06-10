package ru.myfirstapp.movieapp.ui.movies_list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.myfirstapp.movieapp.data.repository.MovieRepository
import ru.myfirstapp.movieapp.domain.model.Movie

class MoviesListViewModel(val app: Application) : AndroidViewModel(app) {

    init {
        loadMovies()
    }

    private val _moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesList: LiveData<List<Movie>> get() = _moviesList

    private fun loadMovies() {
        viewModelScope.launch {
            val localMovies = withContext(Dispatchers.IO) {
                MovieRepository.getMovieFromDatabase(app.applicationContext)
            }
            if (localMovies.isNotEmpty()) {
                _moviesList.value = localMovies
            }

            try {
                val movieFromNetwork: List<Movie> = MovieRepository.getMovies()
                withContext(Dispatchers.IO) {
                    MovieRepository.setMovieInDatabase(app, movieFromNetwork)
                    _moviesList.postValue(movieFromNetwork)
                }
            } catch (error: Throwable) {
                Log.e(
                    "MoviesListViewModel",
                    "Ошибка загрузки из сети ${error.message}",
                    error
                )
            }
        }
    }
}
