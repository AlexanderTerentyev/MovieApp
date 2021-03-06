package ru.myfirstapp.movieapp.ui.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.myfirstapp.movieapp.R
import ru.myfirstapp.movieapp.ui.movie_details.FragmentMoviesDetails

class FragmentMoviesList : Fragment() {

    private val viewModel: MoviesListViewModel by viewModels {
        ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
    }

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
        val adapter = MoviesAdapter { movieId ->
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesDetails.newInstance(movieId))
                .addToBackStack(null)
                .commit()
        }
        recyclerMovie.layoutManager = gridLayoutManager
        recyclerMovie.adapter = adapter
        recyclerMovie.setHasFixedSize(true)

        viewModel.moviesList.observe(this.viewLifecycleOwner) {
            adapter.bindMovies(it)
        }
    }
}