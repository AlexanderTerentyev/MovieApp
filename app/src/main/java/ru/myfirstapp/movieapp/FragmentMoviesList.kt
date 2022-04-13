package ru.myfirstapp.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

//    private var listener : FragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.item_film_avengers)
            .setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.main_container, FragmentMoviesDetails())
                    .addToBackStack(null)
                    .commit()
            }
    }

//    fun setListener(listener: FragmentClickListener) {
//        this.listener = listener
//    }

//    interface FragmentClickListener {
//        fun selectedAvengersEndGame()
//    }
}