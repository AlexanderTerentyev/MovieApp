package ru.myfirstapp.movieapp.ui.movies_list

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.myfirstapp.movieapp.data.repository.MovieRepository
import ru.myfirstapp.movieapp.domain.model.Movie

class MoviesListViewModel(app: Application) : AndroidViewModel(app) {

    init {
        loadMovies()
    }

    private val _moviesList: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesList: LiveData<List<Movie>> get() = _moviesList

    private fun loadMovies() {
        viewModelScope.launch {
            val loadMovie: List<Movie> = MovieRepository().getMovies()
            _moviesList.postValue(loadMovie)
        }
    }
}


