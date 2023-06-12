package com.maha.tmdb.data.repositoryimp.tvshow.dataSource

import com.maha.tmdb.data.model.tvshow.TvShow

interface TvShowLocalDataSorce {
    suspend fun getTvShowFromDb():List<TvShow>
    suspend fun updateTvShowToDb(tvshowList:List<TvShow>)
    suspend fun clearAll()
}