package com.maha.tmdb.domain.usecases

import com.maha.tmdb.domain.repository.MovieRepository
import com.maha.tmdb.data.model.movie.Movie

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?=movieRepository.updateMovies()
}