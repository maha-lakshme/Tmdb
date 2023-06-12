package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistCacheDataSource
import com.maha.tmdb.data.repositoryimp.artist.datasourceImpl.ArtistCacheDataSourceImple
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieCacheDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowCacheDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImple()
    }
    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource{
        return TVShowCacheDataSourceImpl()
    }
}