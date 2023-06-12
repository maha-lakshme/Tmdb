package com.maha.tmdb.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.domain.usecases.GetArtistUseCase
import com.maha.tmdb.domain.usecases.UpdateArtistUseCase

class ArtistViewModel(private val getArtistUseCase: GetArtistUseCase,
                      private val updateArtistUseCase: UpdateArtistUseCase):ViewModel()
{
    fun getArtistList()= liveData {
        val artistList:List<Artist>? = getArtistUseCase.execute()
        emit(artistList)
    }
    fun updatArtist()= liveData {
        val artistList:List<Artist>? = updateArtistUseCase.execute()
        emit(artistList)
    }
}