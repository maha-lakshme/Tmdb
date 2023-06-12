package com.maha.tmdb.data.repositoryimp.movie.datasource

import com.maha.tmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    //Api returns the instance of type Response<Movie>List
    suspend fun getMovie(): Response<MovieList>
}