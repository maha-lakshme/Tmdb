package com.maha.tmdb.presentation.movie

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
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.maha.tmdb.R
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.databinding.ActivityMovieBinding
import com.maha.tmdb.presentation.di.Injector
import com.maha.tmdb.presentation.di.movie.MovieAdapter
import retrofit2.Response
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createSubComponent().inject(this)

        movieViewModel= ViewModelProvider(this,factory).
        get(MovieViewModel::class.java)

        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData =movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {movieList->
            Log.d("TAG","MovieList---> ${movieList.toString()}")
            if(movieList!=null){
                adapter.setList(movieList)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Snackbar.make(binding.movieRecyclerView,"No data available",Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
    private fun updateMovies()
    {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response:LiveData<List<Movie>?> = movieViewModel.upateMovieList()
        response.observe(this,Observer{
            if(it!=null){
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}