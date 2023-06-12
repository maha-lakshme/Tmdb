package com.maha.tmdb.domain.usecases

import com.maha.tmdb.domain.repository.TvShowRepository
import com.maha.tmdb.data.model.tvshow.TvShow

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository)  {
    suspend fun execute():List<TvShow>?=tvShowRepository.getTvShow()
}