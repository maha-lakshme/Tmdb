package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl

import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowCacheDataSource

class TVShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getDataFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveDataToCache(tvshow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvshow)

    }
}