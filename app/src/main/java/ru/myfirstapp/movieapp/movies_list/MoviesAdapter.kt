package ru.myfirstapp.movieapp.movies_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.myfirstapp.movieapp.R

class MoviesAdapter(
    private val onFilmClicked: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(
) {

    companion object {
        const val TYPE_HEADER = R.layout.movies_list_header_item
        const val TYPE_MOVIES = R.layout.movie_item
    }

    private var movieList: List<MovieData> = emptyList()

    fun bindMovies(newMovie: List<MovieData>) {
        movieList = newMovie
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

        fun bind(movieData: MovieData) {
            item.setOnClickListener { onFilmClicked() }
            nameMovie.text = movieData.name
            avatarMovie.setImageResource(movieData.avatar)
            ageMovie.text = movieData.age
            durationMovie.text = movieData.time
            genreMovie.text = movieData.genre
            reviewMovie.text = movieData.review
        }
    }

    inner class HeaderViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        private val item = layout.findViewById<TextView>(R.id.text_view_movies_list)
    }

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

    private fun getItem(position: Int): MovieData = movieList[position - 1]

    override fun getItemCount(): Int = movieList.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_MOVIES
    }
}

