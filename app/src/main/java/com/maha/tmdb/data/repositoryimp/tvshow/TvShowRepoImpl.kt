package com.maha.tmdb.data.repositoryimp.tvshow

import android.util.Log
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.data.model.movie.MovieList
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.model.tvshow.TvShowList
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TVShowRemotDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowCacheDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowLocalDataSorce
import com.maha.tmdb.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepoImpl(private val tvShowRemotDataSource: TVShowRemotDataSource,
                     private val tvShowLocalDataSorce: TvShowLocalDataSorce,
                     private val tvShowCacheDataSource: TvShowCacheDataSource):TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val tvShowList:List<TvShow> = getTvShowFromApi()
        tvShowLocalDataSorce.clearAll()
        tvShowLocalDataSorce.updateTvShowToDb(tvShowList)
        tvShowCacheDataSource.saveDataToCache(tvShowList)
        return tvShowList
    }

    suspend fun getTvShowFromApi():List<TvShow> {
        lateinit var TvShowList:List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemotDataSource.getTvShowList()
            val body = response.body()
            if (body != null) {
                TvShowList =body.tvshow
            }
        } catch (error: Exception) {
            Log.e("TAG", "Error occured in fetching movies--> ${error.toString()}")
        }
        return TvShowList
    }
    suspend fun getTvShowFromDb():List<TvShow>{
        lateinit var TvShowList:List<TvShow>
        try {
            TvShowList = tvShowLocalDataSorce.getTvShowFromDb()
        } catch (error: Exception) {
            Log.e("TAG", "Error occured ${error.toString()}")
        }
        if(TvShowList.size>0){
            return TvShowList
        }else {
            TvShowList = getTvShowFromApi()
            tvShowLocalDataSorce.updateTvShowToDb(TvShowList)
        }
        return TvShowList

    }
    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var TvShowList:List<TvShow>
        try {
            TvShowList = tvShowCacheDataSource.getDataFromCache()
        } catch (error: Exception) {
            Log.e("TAG", "Error occured ${error.toString()}")
        }
        if(TvShowList.size>0){
            return TvShowList
        }else {
            TvShowList = getTvShowFromDb()
            tvShowCacheDataSource.saveDataToCache(TvShowList)
        }
        return TvShowList

    }

}