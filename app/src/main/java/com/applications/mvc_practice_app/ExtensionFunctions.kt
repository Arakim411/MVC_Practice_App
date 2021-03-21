package com.applications.mvc_practice_app

import android.content.res.Resources

import com.applications.mvc_practice_app.networking.Constants


fun Constants.ListType.toStringResources(resources: Resources): String = when (this) {
    Constants.ListType.MOVIE_POPULAR -> resources.getString(R.string.popularMovies)
    Constants.ListType.MOVIE_TOP_RATED -> resources.getString(R.string.topRatedMovies)
    Constants.ListType.MOVIE_UPCOMING -> resources.getString(R.string.upcomingMovies)
    Constants.ListType.TV_POPULAR -> resources.getString(R.string.popularTvShow)
    Constants.ListType.TV_LATEST -> resources.getString(R.string.latestTvShow)
    Constants.ListType.TV_TOP_RATED -> resources.getString(R.string.topRatedTvShow)

}



