package ru.myfirstapp.movieapp.movie_details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyViewModelFactory(private val mApplication: Application, private val movieId: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(mApplication, movieId) as T
    }
}