package ru.myfirstapp.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myfirstapp.movieapp.R
import ru.myfirstapp.movieapp.ui.movies_list.FragmentMoviesList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesList())
                .commit()
        }
    }
}