package ru.myfirstapp.movieapp.ui.movie_details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.myfirstapp.movieapp.data.repository.ActorRepository
import ru.myfirstapp.movieapp.data.repository.MovieRepository
import ru.myfirstapp.movieapp.domain.model.Actor
import ru.myfirstapp.movieapp.domain.model.Movie

class MovieDetailsViewModel(val app: Application, private val movieId: Long) : AndroidViewModel(app) {

    init {
        loadMovie()
    }

    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    val movie: LiveData<Movie> get() = _movie

    private val _actors: MutableLiveData<List<Actor>> = MutableLiveData()
    val actors: LiveData<List<Actor>> get() = _actors

    private fun loadMovie() {
        viewModelScope.launch {
            val movie: Movie = MovieRepository.getMovieById(movieId)
            _movie.postValue(movie)
            val actors = ActorRepository().getActorsByMovieId(movieId)
            _actors.postValue(actors)
        }
    }
}
