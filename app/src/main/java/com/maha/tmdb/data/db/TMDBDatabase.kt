package com.maha.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class],
    version = 2, exportSchema = false)
 abstract class TMDBDatabase:RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvshowDao
    abstract fun artistDao(): ArtistDao
}