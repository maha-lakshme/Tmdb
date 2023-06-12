package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl

import com.maha.tmdb.data.api.TMDBService
import com.maha.tmdb.data.model.tvshow.TvShowList
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TVShowRemotDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbApiService:TMDBService,
                                 private val api_key:String): TVShowRemotDataSource {

    override suspend fun getTvShowList(): Response<TvShowList> {
        val tvShowList:Response<TvShowList> = tmdbApiService.getPopularTvShows(api_key)
        return tvShowList
    }
}