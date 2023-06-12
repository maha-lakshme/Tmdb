package com.maha.tmdb.presentation.di.movie

import com.maha.tmdb.domain.usecases.GetMoviesUseCase
import com.maha.tmdb.domain.usecases.UpdateMovieUseCase
import com.maha.tmdb.presentation.di.artist.AristScope
import com.maha.tmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                     updateMovieUseCase: UpdateMovieUseCase):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}