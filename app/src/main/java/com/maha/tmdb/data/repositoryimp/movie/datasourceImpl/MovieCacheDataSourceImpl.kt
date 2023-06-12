package com.maha.tmdb.data.repositoryimp.movie.datasourceImpl

import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}