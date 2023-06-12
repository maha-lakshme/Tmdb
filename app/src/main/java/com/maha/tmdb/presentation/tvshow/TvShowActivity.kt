package com.maha.tmdb.presentation.tvshow

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
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.snackbar.Snackbar
import com.maha.tmdb.R
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.databinding.ActivityTvShowBinding
import com.maha.tmdb.presentation.di.Injector
import com.maha.tmdb.presentation.di.tvshow.TvShowAdapter
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvshoeSubComponet().inject(this)

        viewModel = ViewModelProvider(this,factory).get(TvShowViewModel::class.java)

        initRecycleView()
    }

    fun initRecycleView(){
        adapter = TvShowAdapter()
       binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tvShowRecyclerView.adapter = adapter
        binding.tvShowPrgressBar.visibility = View.VISIBLE
         viewModel.getTvShow().observe(this, Observer {tvShowList->
             Log.d("TAG","TvShow Response -> ${tvShowList.toString()}")
             if(tvShowList!=null){
                binding.tvShowPrgressBar.visibility = View.GONE
                adapter.setList(tvShowList)
                adapter.notifyDataSetChanged()

            }else{
                binding.tvShowPrgressBar.visibility = View.GONE
                Snackbar.make(binding.tvShowRecyclerView,"Error Occured",Snackbar.LENGTH_SHORT).show()

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
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
    private fun updateTvShow()
    {
        binding.tvShowPrgressBar.visibility = View.VISIBLE
        val response: LiveData<List<TvShow>?> = viewModel.updateTvShow()
        response.observe(this,Observer{
            if(it!=null){
                adapter.notifyDataSetChanged()
                binding.tvShowPrgressBar.visibility = View.GONE
            }else{
                binding.tvShowPrgressBar.visibility = View.GONE
            }
        })
    }
}