package com.maha.tmdb.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.maha.tmdb.R
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.databinding.ActivityArtistBinding
import com.maha.tmdb.presentation.di.Injector
import com.maha.tmdb.presentation.movie.MovieViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
   private lateinit var binding: ActivityArtistBinding
   private lateinit var viewModel: ArtistViewModel
    @Inject
    lateinit var factory: ArtistViewmodelFactory
   private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        viewModel= ViewModelProvider(this,factory).
        get(ArtistViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.artistRecycleView.layoutManager = LinearLayoutManager(this)
        adapter= ArtistAdapter()
        binding.artistRecycleView.adapter = adapter
        binding.artistProgressBar.visibility = View.VISIBLE
        val artistResLiveData= viewModel.getArtistList().observe(this, Observer {artistList->
            Log.d("TAG","Artist Response -> ${artistList.toString()}")
            if(artistList!=null){
                adapter.setArtistList(artistList)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Log.d("TAG","Error occured")
                Snackbar.make(binding.artistRecycleView,"No data available", Snackbar.LENGTH_SHORT).show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
    private fun updateArtist()
    {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response:LiveData<List<Artist>?> = viewModel.updatArtist()
        response.observe(this,Observer{
            if(it!=null){
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}