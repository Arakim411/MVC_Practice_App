package com.applications.mvc_practice_app.listeners

import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.networking.Constants
import java.lang.String

interface ViewerEvents {
    fun setTitle(title: kotlin.String)
    fun setPage(page: Int, maxPage: Int)
    fun addFragment(type: Constants.MovieListType)

}