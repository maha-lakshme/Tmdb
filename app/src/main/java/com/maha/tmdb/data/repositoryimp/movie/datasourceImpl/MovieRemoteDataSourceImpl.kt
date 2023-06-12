package com.maha.tmdb.data.repositoryimp.movie.datasourceImpl

import com.maha.tmdb.data.api.TMDBService
import com.maha.tmdb.data.model.movie.MovieList
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbServies:TMDBService,
    private val ApiKey:String): MovieRemoteDataSource {
    override suspend fun getMovie(): Response<MovieList> {
return tmdbServies.getPopularMovies(ApiKey)
    }
}