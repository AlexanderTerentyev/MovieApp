package ru.myfirstapp.movieapp.movies_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.myfirstapp.movieapp.R
import ru.myfirstapp.movieapp.data.Movie

class MoviesAdapter(
    private val onFilmClicked: (movieId: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(
) {

    companion object {
        const val TYPE_HEADER = R.layout.movies_list_header_item
        const val TYPE_MOVIES = R.layout.movie_item
    }

    private var moviesList: List<Movie> = emptyList()

    fun bindMovies(newMovie: List<Movie>) {
        moviesList = newMovie
        notifyDataSetChanged()
    }

    inner class MoviesViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        private val item = layout.findViewById<ConstraintLayout>(R.id.item_movies)
        private val nameMovie = layout.findViewById<TextView>(R.id.text_view_movie_name)
        private val avatarMovie =
            layout.findViewById<ImageView>(R.id.image_view_movies_avatar)
        private val ageMovie = layout.findViewById<TextView>(R.id.text_view_movie_list_age)
        private val durationMovie = layout.findViewById<TextView>(R.id.text_view_duration)
        private val genreMovie = layout.findViewById<TextView>(R.id.text_view_genre)
        private val reviewMovie = layout.findViewById<TextView>(R.id.text_view_reviews)
        private val ratings = layout.findViewById<RatingBar>(R.id.rating_bar_movie_list)


        fun bind(movieData: Movie) {
            item.setOnClickListener { onFilmClicked(movieData.id) }
            nameMovie.text = movieData.title
            Glide.with(item.context)
                .load(movieData.poster)
                .into(avatarMovie)
            ageMovie.text = movieData.minimumAge.toString() + "+"
            ratings.rating = movieData.ratings/2
            durationMovie.text = movieData.runtime.toString() + " MIN"
            genreMovie.text = movieData.genres.map { it.name }.joinToString()
            reviewMovie.text = movieData.numberOfRatings.toString() + " REVIEWS"
        }
    }

    inner class HeaderViewHolder(layout: View) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_MOVIES -> MoviesViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
            )
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movies_list_header_item, parent, false)
            )
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MoviesViewHolder -> holder.bind(getItem(position))
        }
    }

    private fun getItem(position: Int): Movie = moviesList[position - 1]

    override fun getItemCount(): Int = moviesList.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_MOVIES
        }
    }
}

