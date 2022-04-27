package ru.myfirstapp.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myfirstapp.movieapp.movies_list.FragmentMoviesList


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