package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceV1

import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowDataSource  {
    suspend fun getTvShowFromRemoteDataSource():Response<TvShowList>
    suspend fun getTvShowFromDb():List<TvShow>
    suspend fun saveTvShowToDb(tvshow : List<TvShow>)
    suspend fun cleaAll()
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvshow:List<TvShow>)

}