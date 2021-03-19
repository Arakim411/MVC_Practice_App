package com.applications.mvc_practice_app.screens.movieListFragmentComponents

import android.view.LayoutInflater
import android.view.ViewGroup

class MovieViewsMvcFactory(private val layoutInflater: LayoutInflater) {

    fun newMovieViewsMvc(parent: ViewGroup?): ShowMoviesViewsMvc{
        return ShowMoviesViewsMvc(layoutInflater,parent)
    }
}