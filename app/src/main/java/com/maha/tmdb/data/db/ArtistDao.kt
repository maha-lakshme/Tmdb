package com.maha.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maha.tmdb.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(Artist: List<Artist>)
    @Query("DELETE from POPULAR_ARTIST")
    suspend fun deleteArtist()
    @Query("SELECT * from POPULAR_ARTIST")
    suspend fun getArtist():List<Artist>
}