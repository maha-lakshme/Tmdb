package com.maha.tmdb.data.repositoryimp.movie

import android.util.Log
import com.maha.tmdb.domain.repository.MovieRepository
import com.maha.tmdb.data.model.movie.Movie
import com.maha.tmdb.data.model.movie.MovieList
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieCacheDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieLocalDataSource
import com.maha.tmdb.data.repositoryimp.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRepoImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
     ): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }
    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies= getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi():List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovie()
            val body = response.body()
            if (body != null) {
                movieList =body.movies
            }
        } catch (error: Exception) {
            Log.e("TAG", "Error occured in fetching movies--> ${error.toString()}")
        }
        return movieList
    }
    suspend fun getMoviesFromDb():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (error: Exception) {
            Log.e("TAG", "Error occured ${error.toString()}")
        }
        if(movieList.size>0){
            return movieList
        }else {
        movieList = getMoviesFromApi()
        movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList

    }
    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (error: Exception) {
            Log.e("TAG", "Error occured ${error.toString()}")
        }
        if(movieList.size>0){
            return movieList
        }else {
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList

    }

}