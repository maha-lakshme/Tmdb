package com.maha.tmdb.presentation.di.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maha.tmdb.R
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<TvShowViewHolder>() {
    private var tvshowList = ArrayList<TvShow>()

    fun setList(tvshow:List<TvShow>){
        tvshowList.clear()
        tvshowList.addAll(tvshow)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,parent,false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvshowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvshowList[position])
    }
}


class TvShowViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(tvshow:TvShow){
        binding.titleTextView.text = tvshow.name
        binding.descriptionTextView.text =tvshow.overview
        val posterUrl:String = "https://image.tmdb.org/t/p/w500"+tvshow.posterPath
        Glide.with(binding.imageView.context).apply {
            load(posterUrl).into(binding.imageView)
        }
    }

}