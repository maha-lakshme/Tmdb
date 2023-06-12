package com.maha.tmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.maha.tmdb.R
import com.maha.tmdb.databinding.ActivityHomeBinding
import com.maha.tmdb.presentation.artist.ArtistActivity
import com.maha.tmdb.presentation.movie.MovieActivity
import com.maha.tmdb.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

     private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener{
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}