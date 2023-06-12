package com.maha.tmdb.presentation

import android.app.Application
import com.maha.tmdb.BuildConfig
import com.maha.tmdb.presentation.di.Injector
import com.maha.tmdb.presentation.di.artist.ArtistSubComponent
import com.maha.tmdb.presentation.di.core.*
import com.maha.tmdb.presentation.di.movie.MovieSubComponent
import com.maha.tmdb.presentation.di.tvshow.TvShowSubComponent

class App: Application(),Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
       appComponent =  DaggerAppComponent.builder().
       appModule(AppModule(applicationContext)).
               netModule(NetModule(BuildConfig.BASE_URL)).
               remoteDataModule(RemoteDataModule(BuildConfig.API_KEY)).build()
    }

    override fun createSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvshoeSubComponet(): TvShowSubComponent {
        return appComponent.tvshowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}