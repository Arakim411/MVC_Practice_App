package com.applications.mvc_practice_app.screens.detailsFragmentComponent

import android.view.LayoutInflater
import android.view.ViewGroup

class DetailsViewsMvcFactory(private  val layoutInflater: LayoutInflater) {

    fun getDetailsViewsMvc(view: ViewGroup?): DetailsViewsMvc{
        return DetailsViewsMvc(layoutInflater,view)
    }
}