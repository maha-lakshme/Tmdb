package com.maha.tmdb.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.domain.usecases.GetTvShowUseCase
import com.maha.tmdb.domain.usecases.UpdateTvShowUseCase

class TvShowViewModel(private val getTvShowUseCase: GetTvShowUseCase,
                     private val updateTvShowUseCase: UpdateTvShowUseCase) :ViewModel()

{
    fun getTvShow()= liveData {
        val tvshowList:List<TvShow>? = getTvShowUseCase.execute()
        emit(tvshowList)
    }
    fun updateTvShow()= liveData {
        val tvShowList:List<TvShow>? = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}