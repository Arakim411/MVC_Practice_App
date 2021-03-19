package com.applications.mvc_practice_app.networking

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

object Constants {
    const val API_KEY = "39194e6a574f8321e1cb3d9f73617030"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_FOR_PHOTO = "https://image.tmdb.org/t/p/w500"

    @Parcelize
    enum class ListType : Parcelable {
        MOVIE_POPULAR,
        MOVIE_TOP_RATED,
        MOVIE_UPCOMING,
        TV_LATEST,
        TV_POPULAR,
        TV_TOP_RATED
    }

    val allMovieListType = arrayListOf(ListType.MOVIE_POPULAR,ListType.MOVIE_TOP_RATED,ListType.MOVIE_UPCOMING)
    val allTvShowListType = arrayListOf(ListType.TV_TOP_RATED,ListType.TV_POPULAR,ListType.TV_LATEST)
}