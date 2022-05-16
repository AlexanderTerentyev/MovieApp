package ru.myfirstapp.movieapp.movies_list

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.myfirstapp.movieapp.data.Movie
import ru.myfirstapp.movieapp.data.loadMovies

class MoviesListViewModel(app: Application) : AndroidViewModel(app) {

    init {
        loadMovies()
    }

    private val _moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesList: LiveData<List<Movie>> get() = _moviesList

    private fun loadMovies() {
        viewModelScope.launch {
            val newMovie = loadMovies(getApplication<Application>().applicationContext)
            _moviesList.postValue(newMovie)
        }
    }
}