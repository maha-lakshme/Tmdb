package com.maha.tmdb.domain.usecases

import com.maha.tmdb.domain.repository.ArtistRepository
import com.maha.tmdb.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}