package ru.myfirstapp.movieapp.ui.movie_details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MovieDetailsViewModelFactory(private val mApplication: Application, private val movieId: Long) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(mApplication, movieId) as T
    }
}