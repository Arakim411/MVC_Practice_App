package com.applications.mvc_practice_app

import android.app.Activity
import android.content.res.Resources
import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.networking.Constants

fun Constants.MovieListType.toStringResources(resources: Resources): String = when (this) {
    Constants.MovieListType.POPULAR -> resources.getString(R.string.popularMovies)
    Constants.MovieListType.TOP_RATED -> resources.getString(R.string.topRatedMovies)
    Constants.MovieListType.UPCOMING -> resources.getString(R.string.upcomingMovies)

}

