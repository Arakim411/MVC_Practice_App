package com.applications.mvc_practice_app.networking

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

object Constants {
    const val API_KEY = "39194e6a574f8321e1cb3d9f73617030"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_FOR_PHOTO = "https://image.tmdb.org/t/p/w500"

    @Parcelize
    enum class MovieListType : Parcelable {
        POPULAR,
        TOP_RATED,
        UPCOMING;

    }

    val allMovieListType = arrayListOf<MovieListType>(MovieListType.POPULAR,MovieListType.TOP_RATED,MovieListType.UPCOMING)
}