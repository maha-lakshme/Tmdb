package com.maha.tmdb.domain.usecases

import com.maha.tmdb.domain.repository.ArtistRepository
import com.maha.tmdb.data.model.artist.Artist

class GetArtistUseCase (private val artistRepository: ArtistRepository){
    suspend fun execute(): List<Artist>? {
       val artoist:List<Artist>?= artistRepository.getArtist()
        return artoist
    }
}