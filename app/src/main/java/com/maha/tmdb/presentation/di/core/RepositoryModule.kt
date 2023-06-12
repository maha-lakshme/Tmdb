package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.data.repositoryimp.artist.ArtistRepoImpl
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistCacheDataSource
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistLocalDataSource
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistRemoteDataSource
import com.maha.tmdb.data.repositoryimp.movie.MovieRepoImpl
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieCacheDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieLocalDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieRemoteDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.TvShowRepoImpl
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TVShowRemotDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowCacheDataSource
import com.maha.tmdb.data.repositoryimp.tvshow.dataSource.TvShowLocalDataSorce
import com.maha.tmdb.domain.repository.ArtistRepository
import com.maha.tmdb.domain.repository.MovieRepository
import com.maha.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource,
                               movieLocalDataSource: MovieLocalDataSource,
                               movieCacheDataSource: MovieCacheDataSource):MovieRepository{
        return MovieRepoImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(TvShowRemoteDataSource:TVShowRemotDataSource ,
                                TvShowLocalDataSource: TvShowLocalDataSorce,
                                TvShowCacheDataSource: TvShowCacheDataSource):TvShowRepository{
        return TvShowRepoImpl(TvShowRemoteDataSource,TvShowLocalDataSource,TvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(artistRemoteDataSource: ArtistRemoteDataSource,
                                artistLocalDataSource: ArtistLocalDataSource,
                                artistCacheDataSource: ArtistCacheDataSource):ArtistRepository{
        return ArtistRepoImpl(artistRemoteDataSource,artistLocalDataSource,artistCacheDataSource)
    }
}