package com.mramirez.labo4_00120717.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mramirez.labo4_00120717.R
import com.mramirez.labo4_00120717.pojos.Movie
import kotlinx.android.synthetic.main.cardview_movie.view.*
import java.text.FieldPosition

class MovieAdapter(var movies:List<Movie>,val clickListener:(Movie) -> Unit):RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    /* Infla cada uno de los eltos de nuestra List en la vista*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position],clickListener)

    fun changeList(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Movie,ClickListener: (Movie)->Unit) = with(itemView){
            Glide.with(itemView.context)
                .load(item.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image_cv)

            movie_title_cv.text = item.Title
            movie_plot_cv.text = item.Plot
            movie_rate_cv.text = item.imdbRating
            movie_runtime_cv.text = item.Runtime
            this.setOnClickListener { ClickListener(item) }
        }
    }

}