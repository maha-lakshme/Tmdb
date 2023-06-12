package com.maha.tmdb.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maha.tmdb.R
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.databinding.ListItemBinding

class ArtistAdapter():RecyclerView.Adapter<ArtistViewHolder> (){
   private val artistList = ArrayList<Artist>()

   fun setArtistList(artist:List<Artist>){
       artistList.clear()
       artistList.addAll(artist)

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInlfator =LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(layoutInlfator,
            R.layout.list_item,parent,false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

}


class ArtistViewHolder(private val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTextView.text=artist.name
        val posterUrl:String = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context).apply {
            load(posterUrl).into(binding.imageView)
        }
        binding.descriptionTextView.text =artist.popularity.toString()
    }

}