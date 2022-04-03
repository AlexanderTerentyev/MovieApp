package ru.myfirstapp.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.myfirstapp.myapplication.MovieDetailsActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textview_start)
        textView.setOnClickListener {
            val intent = Intent(applicationContext, MovieDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}