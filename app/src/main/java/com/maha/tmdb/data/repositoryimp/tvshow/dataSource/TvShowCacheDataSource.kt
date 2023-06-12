package com.maha.tmdb.data.repositoryimp.tvshow.dataSource

import com.maha.tmdb.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getDataFromCache():List<TvShow>
    suspend fun saveDataToCache(tvshowList:List<TvShow>)

}