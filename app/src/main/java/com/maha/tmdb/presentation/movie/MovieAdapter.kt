package com.maha.tmdb.presentation.di.movie

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maha.tmdb.R
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.databinding.ListItemBinding

class MovieAdapter():RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bindindg:ListItemBinding = DataBindingUtil.inflate(layoutInflater,
        R.layout.list_item,parent,false)
        return MovieViewHolder(bindindg)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}

class MovieViewHolder(val bindindg:ListItemBinding):RecyclerView.ViewHolder(bindindg.root){

    fun bind(movie:Movie){
        bindindg.titleTextView.text = movie.title
        bindindg.descriptionTextView.text=movie.overview
        val posterUrl:String = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(bindindg.imageView.context).
        load(posterUrl).into(bindindg.imageView)
    }

}