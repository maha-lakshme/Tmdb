package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.domain.repository.ArtistRepository
import com.maha.tmdb.domain.repository.MovieRepository
import com.maha.tmdb.domain.repository.TvShowRepository
import com.maha.tmdb.domain.usecases.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

}