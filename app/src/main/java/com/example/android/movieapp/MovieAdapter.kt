package com.example.android.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.movieapp.models.Movie

class MovieAdapter (
    private val movies : List<Movie>
        ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        private var m_t : TextView = itemView.findViewById(R.id.movie_title)
        private var m_r_d : TextView = itemView.findViewById(R.id.movie_release_date)

        fun bindMovie(movie: Movie) {
            m_t.text = movie.title
            m_r_d.text = movie.release
//            itemView.movie_title.text = movie.title
//            itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.findViewById(R.id.movie_poster))
        }

    }
}