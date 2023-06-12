package com.maha.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maha.tmdb.data.model.tvshow.TvShow

@Dao
interface TvshowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvshows(tvshow:List<TvShow>)
    @Query("DELETE from TV_SHOWS")
    suspend fun deleteTvshow()
    @Query("SELECT * from TV_SHOWS")
    suspend fun getTvShow(): List<TvShow>
}