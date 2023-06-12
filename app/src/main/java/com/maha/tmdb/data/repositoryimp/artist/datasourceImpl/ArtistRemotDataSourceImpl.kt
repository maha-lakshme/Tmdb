package com.maha.tmdb.data.repositoryimp.artist.datasourceImpl

import com.maha.tmdb.data.api.TMDBService
import com.maha.tmdb.data.model.artist.ArtistList
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemotDataSourceImpl(
    private val api:TMDBService,
    private val api_key:String): ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> {
        return api.getPopularArtists(api_key)
    }
}