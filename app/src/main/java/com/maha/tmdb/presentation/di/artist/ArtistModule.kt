package com.maha.tmdb.presentation.di.artist

import com.maha.tmdb.domain.usecases.GetArtistUseCase
import com.maha.tmdb.domain.usecases.UpdateArtistUseCase
import com.maha.tmdb.presentation.artist.ArtistViewmodelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @AristScope
    @Provides
    fun provideArtistViewModelFactory(getArtistUseCase: GetArtistUseCase,
                                      updateArtistUseCase: UpdateArtistUseCase):
            ArtistViewmodelFactory{
        return ArtistViewmodelFactory(getArtistUseCase, updateArtistUseCase)
    }
}