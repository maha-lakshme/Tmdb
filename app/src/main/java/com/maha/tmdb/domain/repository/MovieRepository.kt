package com.maha.tmdb.domain.repository

import com.maha.tmdb.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
    }