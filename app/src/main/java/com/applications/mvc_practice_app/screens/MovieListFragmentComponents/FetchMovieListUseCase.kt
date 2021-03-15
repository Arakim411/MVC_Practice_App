package com.applications.mvc_practice_app.screens.MovieListFragmentComponents

import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.networking.Apis.MovieApi
import com.applications.mvc_practice_app.networking.Constants
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class FetchMovieListUseCase(private val movieApi: MovieApi) {

    sealed class Result {
        class Success(val movieList: MovieList) : Result()
        object Failure : Result()
    }



    suspend fun getMovieList(page: Int, type: Constants.MovieListType): Result {

        return withContext(Dispatchers.IO) {
            try {
                val response = when (type) {
                    Constants.MovieListType.POPULAR -> movieApi.getPopularMovies(Constants.API_KEY, page)
                    Constants.MovieListType.TOP_RATED -> movieApi.getTopRatedMovies(Constants.API_KEY, page)
                    Constants.MovieListType.UPCOMING -> movieApi.getUpcomingMovies(Constants.API_KEY, page)
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