package com.maha.tmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maha.tmdb.domain.usecases.GetArtistUseCase
import com.maha.tmdb.domain.usecases.UpdateArtistUseCase

class ArtistViewmodelFactory(private val getArtistUseCase: GetArtistUseCase,
                             private val updateArtistUseCase: UpdateArtistUseCase) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}