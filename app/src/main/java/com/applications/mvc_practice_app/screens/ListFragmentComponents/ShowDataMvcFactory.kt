package com.applications.mvc_practice_app.screens.ListFragmentComponents

import android.view.LayoutInflater
import android.view.ViewGroup

class ShowDataMvcFactory(private val layoutInflater: LayoutInflater) {

    fun newMovieViewsMvc(parent: ViewGroup?): ShowDataViewsMvc{
        return ShowDataViewsMvc(layoutInflater,parent)
    }
}