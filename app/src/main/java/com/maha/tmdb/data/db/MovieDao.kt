package com.maha.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maha.tmdb.data.model.movie.Movie

@Dao
interface MovieDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Movie>)
    @Query("DELETE from MOVIES")
    suspend fun deleteMovies()
    @Query("SELECT * from MOVIES")
    suspend fun getMovies():List<Movie>
}