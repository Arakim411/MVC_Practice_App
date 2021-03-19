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
                it.onButtonClick(Constants.MovieListType.POPULAR)
            }
        }

        rootView.top_rated_movies.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.MovieListType.TOP_RATED)
            }
        }

        rootView.upcoming_movies.setOnClickListener {
            listeners.forEach {
                it.onButtonClick(Constants.MovieListType.UPCOMING)
            }
        }

    }

    interface FragmentHomeEvent {
        fun onButtonClick(type: Constants.MovieListType)
    }
}