package com.maha.tmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.maha.tmdb.data.db.ArtistDao
import com.maha.tmdb.data.db.MovieDao
import com.maha.tmdb.data.db.TMDBDatabase
import com.maha.tmdb.data.db.TvshowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Provides
    @Singleton
    fun provideMovieDataBase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .fallbackToDestructiveMigration().build()
    }
    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase:TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Provides
    @Singleton
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvshowDao{
        return tmdbDatabase.tvDao()
    }
    @Provides
    @Singleton
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }

}