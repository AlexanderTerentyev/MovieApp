package ru.myfirstapp.movieapp.ui.movie_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.myfirstapp.movieapp.R
import ru.myfirstapp.movieapp.domain.model.Actor

class ActorsAdapter : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    private var actorList: List<Actor> = emptyList()

    fun bindActors(newActors: List<Actor>) {
        actorList = newActors
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val layout: View) : RecyclerView.ViewHolder(layout) {
        private val nameActor = layout.findViewById<TextView>(R.id.text_view_actor)
        private val avatarActor = layout.findViewById<ImageView>(R.id.image_view_actor)

        fun bind(actorData: Actor) {
            if (actorList.isNotEmpty()) {
                nameActor.text = actorData.name
                Glide.with(layout.context)
                    .load(actorData.picture)
                    .apply(RequestOptions().centerCrop())
                    .placeholder(R.drawable.chris_evans)
                    .into(avatarActor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.actor_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actorList[position])
    }

    override fun getItemCount(): Int = actorList.size
}
