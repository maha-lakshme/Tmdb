package com.maha.tmdb.data.repositoryimp.tvshow.dataSource

import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TVShowRemotDataSource {
    suspend fun getTvShowList():Response<TvShowList>
}