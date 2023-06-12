package com.maha.tmdb.data.repositoryimp.artist.datasourceImpl

import com.maha.tmdb.data.db.ArtistDao
import com.maha.tmdb.data.model.artist.Artist
import com.maha.tmdb.data.repositoryimp.artist.dataSource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDb(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistToDb(artistList: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artistList)
        }
    }

    override suspend fun clearAllArtist() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtist()
        }
    }
}