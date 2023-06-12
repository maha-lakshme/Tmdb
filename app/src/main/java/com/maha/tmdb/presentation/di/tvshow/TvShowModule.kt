package com.maha.tmdb.presentation.di.tvshow

import com.maha.tmdb.domain.usecases.GetTvShowUseCase
import com.maha.tmdb.domain.usecases.UpdateTvShowUseCase
import com.maha.tmdb.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvshowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,
                                      updateTvShowUseCase: UpdateTvShowUseCase):
            TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)

    }
}