package com.applications.mvc_practice_app.networking.Apis

import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.model.tv_show.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {

    @GET("tv/latest")
    suspend fun getLatestTvShows(
            @Query("api_key")
            api_key: String,
            @Query("page") page: Int = 1
    ): Response<TvShowList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
            @Query("api_key")
            api_key: String,
            @Query("page")
            page: Int = 1
    ): Response<TvShowList>

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int = 1
    ): Response<TvShowList>
}