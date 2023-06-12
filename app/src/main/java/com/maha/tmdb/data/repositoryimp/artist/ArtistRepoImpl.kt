package com.maha.tmdb.data.repositoryimp.artist

import android.util.Log
import com.maha.tmdb.domain.repository.ArtistRepository
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.model.artist.ArtistList
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistCacheDataSource
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistLocalDataSource
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRepoImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
     return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newArtistList: List<Artist> = getArtistFromApi()
        artistLocalDataSource.clearAllArtist()
        artistLocalDataSource.saveArtistToDb(newArtistList)
        artistCacheDataSource.saveArtistToCacche(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList=body.artist
            }
        }
        catch (error:Exception){
            Log.e("TAG","Error in fetching artist---> ${error.toString()}")
        }
        return artistList
    }

    suspend fun getArtistFromDb():List<Artist>{
        lateinit var artist: List<Artist>
        try{
           artist= artistLocalDataSource.getArtistFromDb()
        }catch (error:Exception){
            Log.e("TAG","Error in fetching artist---> ${error.toString()}")
        }
        if(artist.size>0){
            return artist
        }else{
            artist = getArtistFromApi()
            artistLocalDataSource.saveArtistToDb(artist)
        }
        return artist
    }
    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artist:List<Artist>
        try {
            artist = artistCacheDataSource.getArtistFromCache()
        }catch (error:Exception){
            Log.e("TAG","Error in fetching artist---> ${error.toString()}")
        }
        if(artist.size>0)
        {
            return artist
        }else{
            artist = getArtistFromDb()
            artistCacheDataSource.saveArtistToCacche(artist)
        }
        return artist
    }
}