package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceV1

import com.maha.tmdb.data.api.TMDBService
import com.maha.tmdb.data.db.TvshowDao
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.model.tvshow.TvShowList
import com.maha.tmdb.data.repositoryimp.tvshow.dataSourceV1.TvShowDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class TvShowDataSourceImpl(
    private val tmdbService: TMDBService,
    private val api_key:String,
    private val tvDao:TvshowDao)
    : TvShowDataSource {
    override suspend fun getTvShowFromRemoteDataSource(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(api_key)
    }

    override suspend fun getTvShowFromDb(): List<TvShow> {
        return tvDao.getTvShow()
    }
    override suspend fun saveTvShowToDb(tvshow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch{
            tvDao.saveTvshows(tvshow)
        }
    }
    override suspend fun cleaAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteTvshow()
        }
    }

    override suspend fun getTvShowFromCache(): List<TvShow> {
        var tvShowList = ArrayList<TvShow>()
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvshow: List<TvShow>) {
        var tvShowList = ArrayList<TvShow>()
        tvShowList.clear()
        tvShowList = ArrayList(tvshow)
    }
}