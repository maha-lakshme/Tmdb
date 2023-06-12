package com.maha.tmdb.data.repositoryimp.artist.datasourceImpl

import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistCacheDataSource

class ArtistCacheDataSourceImple: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCacche(artist: List<Artist>) {
        artistList.clear()
        artistList= ArrayList(artist)

    }
}