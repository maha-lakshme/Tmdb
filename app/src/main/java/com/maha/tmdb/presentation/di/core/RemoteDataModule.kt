package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.data.api.TMDBService
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistRemoteDataSource
import com.maha.tmdb.data.repositoryimp.artist.datasourceImpl.ArtistRemotDataSourceImpl
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieRemoteDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TVShowRemotDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val api_key:String){
    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,api_key
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemotDataSourceImpl(tmdbService,api_key)
    }

    @Singleton
    @Provides
    fun provideTVshowRemoteDataSource(tmdbService: TMDBService):TVShowRemotDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,api_key)
    }

}