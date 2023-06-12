package com.maha.tmdb.data.repositoryimp.artist.dataSource

import com.maha.tmdb.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCacche(artistList:List<Artist>)
}