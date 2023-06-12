package com.maha.tmdb.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maha.tmdb.domain.usecases.GetMoviesUseCase
import com.maha.tmdb.domain.usecases.UpdateMovieUseCase

class MovieViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase,
                            private val updateMovieUseCase: UpdateMovieUseCase):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMovieUseCase) as T
    }


}