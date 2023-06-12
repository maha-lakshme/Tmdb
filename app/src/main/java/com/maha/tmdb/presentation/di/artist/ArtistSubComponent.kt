package com.maha.tmdb.presentation.di.artist

import com.maha.tmdb.presentation.artist.ArtistActivity
import dagger.Subcomponent
@AristScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}