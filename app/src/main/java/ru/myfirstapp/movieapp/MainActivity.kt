package ru.myfirstapp.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.myfirstapp.myapplication.MovieDetailsActivity


class MainActivity : AppCompatActivity() {

//    private val fragmentMoviesList = FragmentMoviesList().apply { setListener(this@MainActivity)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesList())
                .commit()
        }
    }

//    override fun selectedAvengersEndGame() {
//        supportFragmentManager.beginTransaction()
//            .add(R.id.main_container, FragmentMoviesDetails())
//            .addToBackStack(null)
//            .commit()
//    }
}