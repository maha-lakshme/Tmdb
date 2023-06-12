package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceV1

import android.util.Log
import com.maha.tmdb.domain.repository.TvShowRepository
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.model.tvshow.TvShowList
import com.maha.tmdb.data.repositoryimp.tvshow.dataSourceV1.TvShowDataSource
import retrofit2.Response

class TvRepoImplV1(private val tvShowDataSource: TvShowDataSource): TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowFromCache()
    }
    override suspend fun updateTvShow(): List<TvShow>? {
        val tvshowList:List<TvShow> = getTvShowFromRemoteDataSource()
        tvShowDataSource.cleaAll()
        tvShowDataSource.saveTvShowToDb(tvshowList)
        tvShowDataSource.saveTvShowToCache(tvshowList)
        return tvshowList
    }

    suspend fun getTvShowFromRemoteDataSource():List<TvShow>{
         lateinit var tvShow: List<TvShow>
         try{
           val response:Response<TvShowList> = tvShowDataSource.getTvShowFromRemoteDataSource()
           val body = response.body()
           if(body!=null){
               tvShow = body.tvshow
           }
         }catch (error:Exception){
             Log.e("TAG","Error in tvshow data---> ${error.toString()}")
         }
        return tvShow
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvshow:List<TvShow>
        try{
           tvshow = tvShowDataSource.getTvShowFromDb()
            if(tvshow.size>0){
                return tvshow
            }else{
                tvshow=getTvShowFromRemoteDataSource()
                tvShowDataSource.saveTvShowToDb(tvshow)
            }
        }catch (error:Exception){
            Log.e("TAG","Error in tvshow data---> ${error.toString()}")
        }
        return tvshow
    }

    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var tvshow:List<TvShow>
        try{
           tvshow = tvShowDataSource.getTvShowFromCache()
           if(tvshow.size>0){
               return tvshow
               tvShowDataSource.saveTvShowToCache(tvshow)
           }else{
               tvshow = getTvShowFromDB()
               tvShowDataSource.saveTvShowToCache(tvshow)
           }
        }catch (error: Exception){
            Log.e("TAG","Error in tvshow data---> ${error.toString()}")
        }
        return tvshow
    }
}