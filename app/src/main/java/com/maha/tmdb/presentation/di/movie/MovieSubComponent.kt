package com.maha.tmdb.presentation.di.movie

import com.maha.tmdb.presentation.movie.MovieActivity
import dagger.Subcomponent
import javax.inject.Scope

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject (movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}