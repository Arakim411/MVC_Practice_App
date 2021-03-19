package com.applications.mvc_practice_app.screens.fragmentHome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseViewMvc
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeViewsMvc(layoutInflater: LayoutInflater, view: ViewGroup?) :
        BaseViewMvc<HomeViewsMvc.FragmentHomeEvent>(layoutInflater, view, R.layout.fragment_home) {

    init {
        rootView.popular_movies.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.ListType.MOVIE_POPULAR)
            }
        }

        rootView.top_rated_movies.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.ListType.MOVIE_TOP_RATED)
            }
        }

        rootView.upcoming_movies.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.ListType.MOVIE_UPCOMING)
            }
        }

        rootView.latest_tvShow.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.ListType.TV_LATEST)
            }
        }

        rootView.popular_tvShow.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.ListType.TV_POPULAR)
            }
        }

        rootView.topRated_tvShow.setOnClickListener{
            listeners.forEach {
                it.onButtonClick(Constants.ListType.TV_TOP_RATED)
            }
        }

    }

    interface FragmentHomeEvent {
        fun onButtonClick(type: Constants.ListType)
    }
}