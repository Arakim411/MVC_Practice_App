package com.applications.mvc_practice_app.screens.ListFragmentComponents

import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.networking.Apis.MovieApi
import com.applications.mvc_practice_app.networking.Constants
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchMovieListUseCase(private val movieApi: MovieApi) {

    sealed class Result {
        class Success(val movieList: MovieList) : Result()
        object Failure : Result()
    }



    suspend fun getMovieList(page: Int, type: Constants.ListType): Result {

        return withContext(Dispatchers.IO) {
            try {
                val response = when (type) {
                    Constants.ListType.MOVIE_POPULAR -> movieApi.getPopularMovies(Constants.API_KEY, page)
                    Constants.ListType.MOVIE_TOP_RATED -> movieApi.getTopRatedMovies(Constants.API_KEY, page)
                    Constants.ListType.MOVIE_UPCOMING -> movieApi.getUpcomingMovies(Constants.API_KEY, page)
                    else -> throw IllegalArgumentException("It is not movie type")
                }
                val movieList = response.body()

                if (!response.isSuccessful || movieList == null)
                    return@withContext Result.Failure

                return@withContext Result.Success(movieList)
            } catch (t: Throwable) {
                if (t !is CancellationException)
                    return@withContext Result.Failure

                throw  t
            }

        }

    }
}