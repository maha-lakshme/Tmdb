package com.maha.tmdb.data.repositoryimp.artist.dataSource

import com.maha.tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist():Response<ArtistList>
}