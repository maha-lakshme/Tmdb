package com.maha.tmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.domain.usecases.GetMoviesUseCase
import com.maha.tmdb.domain.usecases.UpdateMovieUseCase

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase,
                     private val updateMovieUseCase: UpdateMovieUseCase)
    :ViewModel() {
        fun getMovies()= liveData {
            val movieList:List<Movie>? = getMoviesUseCase.execute()
            emit(movieList)
        }
    fun upateMovieList()= liveData {
        val movieList:List<Movie>? = updateMovieUseCase.execute()
        emit(movieList)
    }
}