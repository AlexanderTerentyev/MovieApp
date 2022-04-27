package ru.myfirstapp.movieapp.movie_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.myfirstapp.movieapp.R

class ActorsAdapter : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    private var actorList: List<ActorData> = emptyList()

    fun bindActors(newActors: List<ActorData>) {
        actorList = newActors
        notifyDataSetChanged()
    }

    inner class ViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        private val nameView = layout.findViewById<TextView>(R.id.text_view_actor)
        private val avatarView = layout.findViewById<ImageView>(R.id.image_view_actor)

        fun bind(actorData: ActorData) {
            nameView.text = actorData.name

            avatarView.setImageResource(actorData.avatar)
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
