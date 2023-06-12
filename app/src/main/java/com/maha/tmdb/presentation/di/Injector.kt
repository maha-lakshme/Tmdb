package com.maha.tmdb.presentation.di

import com.maha.tmdb.presentation.di.artist.ArtistSubComponent
import com.maha.tmdb.presentation.di.movie.MovieSubComponent
import com.maha.tmdb.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createSubComponent():MovieSubComponent
    fun createTvshoeSubComponet():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}