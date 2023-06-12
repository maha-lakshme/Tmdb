package com.maha.tmdb.data.repositoryimp.artist.dataSource

import com.maha.tmdb.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDb():List<Artist>
    suspend fun saveArtistToDb(artistList:List<Artist>)
    suspend fun clearAllArtist()
}