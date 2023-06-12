package com.maha.tmdb.domain.usecases

import com.maha.tmdb.domain.repository.MovieRepository
import com.maha.tmdb.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepo: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepo.getMovies()
}