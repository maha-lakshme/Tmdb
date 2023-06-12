package com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl

import com.maha.tmdb.data.db.TvshowDao
import com.maha.tmdb.data.model.tvshow.TvShow
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowLocalDataSorce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvshowDao: TvshowDao): TvShowLocalDataSorce {
    override suspend fun getTvShowFromDb(): List<TvShow> {
        return tvshowDao.getTvShow()
    }

    override suspend fun updateTvShowToDb(tvshowList: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvshows(tvshowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteTvshow()
        }
    }
}