package com.applications.mvc_practice_app.screens.roots

import androidx.annotation.UiThread
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.networking.Apis.MovieApi
import com.applications.mvc_practice_app.networking.Apis.TvShowApi
import com.applications.mvc_practice_app.screens.MovieListFragmentComponents.FetchMovieListUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
class AppCompositionRoot {

   private val retrofit by lazy {
        Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() }

    private  val movieApi by lazy { retrofit.create(MovieApi::class.java) }

    private  val tvShowApi by lazy { retrofit.create(TvShowApi::class.java) }

    val fetchMovieUseCase = FetchMovieListUseCase(movieApi)
}