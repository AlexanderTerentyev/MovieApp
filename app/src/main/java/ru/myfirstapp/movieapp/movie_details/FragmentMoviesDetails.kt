package ru.myfirstapp.movieapp.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.myfirstapp.movieapp.R

class FragmentMoviesDetails : Fragment() {

    companion object {
        const val MOVIE_ID = "MOVIE_ID"

        fun newInstance(movieId: Int): FragmentMoviesDetails {
            val bundle = Bundle()
            bundle.putInt(MOVIE_ID, movieId)
            return FragmentMoviesDetails().apply {
                arguments = bundle
            }
        }
    }

    private val movieId: Int by lazy { requireNotNull(arguments?.getInt(MOVIE_ID)) }

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels {
        MyViewModelFactory(
            requireActivity().application,
            movieId
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerActors = view.findViewById<RecyclerView>(R.id.recycler_actors)
        val titleView = view.findViewById<TextView>(R.id.text_title)
        val backdrop = view.findViewById<ImageView>(R.id.image_view_header)
        val overview = view.findViewById<TextView>(R.id.text_view_description)
        val minimumAge = view.findViewById<TextView>(R.id.text_view_age)
        val ratings = view.findViewById<RatingBar>(R.id.rating_bar_movie_list)
        val numberOfRatings = view.findViewById<TextView>(R.id.text_view_reviews)
        val genres = view.findViewById<TextView>(R.id.text_view_genre)
        val cast = view.findViewById<TextView>(R.id.text_cast)

        val adapter = ActorsAdapter()
        recyclerActors.adapter = adapter
        recyclerActors.setHasFixedSize(true)

        movieDetailsViewModel.movie.observe(this.viewLifecycleOwner) { movie ->
            adapter.bindActors(movie.actors)
            titleView.text = movie.title
            Glide.with(view.context)
                .load(movie.backdrop)
                .into(backdrop)
            overview.text = movie.overview
            minimumAge.text = movie.minimumAge.toString() + "+"
            ratings.rating = movie.ratings / 2
            numberOfRatings.text = movie.numberOfRatings.toString() + " REVIEWS"
            genres.text = movie.genres.map { it.name }.joinToString()
            if (movie.actors.isEmpty()) {
                cast.visibility = View.GONE
            } else {
                cast.visibility = View.VISIBLE
            }
        }
    }
}