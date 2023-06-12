package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.data.db.ArtistDao
import com.maha.tmdb.data.db.MovieDao
import com.maha.tmdb.data.db.TvshowDao
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistLocalDataSource
import com.maha.tmdb.data.repositoryimp.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieLocalDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowLocalDataSorce
import com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesMoviesLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao:TvshowDao):TvShowLocalDataSorce{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}