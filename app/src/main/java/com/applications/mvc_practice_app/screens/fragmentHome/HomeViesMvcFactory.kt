package com.applications.mvc_practice_app.screens.fragmentHome

import android.view.LayoutInflater
import android.view.ViewGroup

class HomeViesMvcFactory(private  val layoutInflater: LayoutInflater) {

    fun newNavigatorViewsMvc(view: ViewGroup?): HomeViewsMvc{
        return HomeViewsMvc(layoutInflater,view)
    }
}