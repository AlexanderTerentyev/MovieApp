package ru.myfirstapp.movieapp.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.myfirstapp.movieapp.R

class FragmentMoviesDetails : Fragment() {
    val actors = listOf<ActorData>(
        ActorData(
            name = "Robert Downey Jr.",
            avatar = R.drawable.robert_downey_jr
        ),
        ActorData(
            name = "Chris Evans",
            avatar = R.drawable.chris_evans
        ), ActorData(
            name = "Mark Ruffalo",
            avatar = R.drawable.mark_ruffalo
        ), ActorData(
            name = "Chris Hemsworth",
            avatar = R.drawable.chris_hemsworth
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerActors = view.findViewById<RecyclerView>(R.id.recycler_actors)

        recyclerActors.adapter = ActorsAdapter().apply {
            bindActors(actors)
        }
    }
}