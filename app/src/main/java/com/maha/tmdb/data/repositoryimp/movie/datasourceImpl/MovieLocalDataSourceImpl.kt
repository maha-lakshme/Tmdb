package com.maha.tmdb.data.repositoryimp.movie.datasourceImpl

import com.maha.tmdb.data.db.MovieDao
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val MovieDao:MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return MovieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            MovieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            MovieDao.deleteMovies()
        }
    }
}