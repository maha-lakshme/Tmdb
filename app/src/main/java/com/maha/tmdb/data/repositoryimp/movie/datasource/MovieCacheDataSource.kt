package com.maha.tmdb.data.repositoryimp.movie.datasource

import com.maha.tmdb.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}