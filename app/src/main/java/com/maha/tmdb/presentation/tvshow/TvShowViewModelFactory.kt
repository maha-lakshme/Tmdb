package com.maha.tmdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maha.tmdb.domain.usecases.GetTvShowUseCase
import com.maha.tmdb.domain.usecases.UpdateTvShowUseCase

class TvShowViewModelFactory(private val getTvShowUseCase: GetTvShowUseCase,
                             private val updateTvShowUseCase: UpdateTvShowUseCase):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }
}