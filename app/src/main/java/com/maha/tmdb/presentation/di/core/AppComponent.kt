package com.maha.tmdb.presentation.di.core

import com.maha.tmdb.presentation.di.artist.ArtistSubComponent
import com.maha.tmdb.presentation.di.movie.MovieSubComponent
import com.maha.tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
    fun tvshowSubComponent():TvShowSubComponent.Factory
}