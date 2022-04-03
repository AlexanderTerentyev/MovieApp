package ru.myfirstapp.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.myfirstapp.movieapp.R

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}