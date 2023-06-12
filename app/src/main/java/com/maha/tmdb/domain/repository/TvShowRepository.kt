package com.maha.tmdb.domain.repository

import com.maha.tmdb.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShow():List<TvShow>?
    suspend fun updateTvShow():List<TvShow>?
}