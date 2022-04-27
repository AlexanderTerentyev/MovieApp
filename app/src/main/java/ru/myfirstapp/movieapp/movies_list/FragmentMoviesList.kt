package ru.myfirstapp.movieapp.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.myfirstapp.movieapp.R
import ru.myfirstapp.movieapp.movie_details.FragmentMoviesDetails

class FragmentMoviesList : Fragment() {

    private val movies = listOf<MovieData>(
        MovieData(
            name = "Avengers: End Game",
            avatar = R.drawable.movie_list_avengers_end_game,
            age = "13+",
            time = "137 MIN",
            genre = "Action, Adventure, Drama",
            review = "125 reviews"
        ),
        MovieData(
            name = "Avengers: End Game2",
            avatar = R.drawable.movie_list_avengers_end_game,
            age = "13+",
            time = "137 MIN",
            genre = "Action, Adventure, Drama",
            review = "125 reviews"
        ),
        MovieData(
            name = "Avengers: End Game3",
            avatar = R.drawable.movie_list_avengers_end_game,
            age = "13+",
            time = "137 MIN",
            genre = "Action, Adventure, Drama",
            review = "125 reviews"
        ),
        MovieData(
            name = "Avengers: End Game4 ",
            avatar = R.drawable.movie_list_avengers_end_game,
            age = "13+",
            time = "137 MIN",
            genre = "Action, Adventure, Drama",
            review = "125 reviews"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerMovie = view.findViewById<RecyclerView>(R.id.recycler_movies_list)
        val spanSize = 2
        val gridLayoutManager = GridLayoutManager(requireContext(), spanSize)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = when (position) {
                0 -> spanSize
                else -> 1
            }
        }
        recyclerMovie.layoutManager = gridLayoutManager
        recyclerMovie.adapter = MoviesAdapter {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesDetails())
                .addToBackStack(null)
                .commit()
        }.apply {
            bindMovies(movies)
        }
    }
}