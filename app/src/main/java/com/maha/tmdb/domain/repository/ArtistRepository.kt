package com.maha.tmdb.domain.repository

import com.maha.tmdb.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}