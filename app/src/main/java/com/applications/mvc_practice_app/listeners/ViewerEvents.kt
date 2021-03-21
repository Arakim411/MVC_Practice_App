package com.applications.mvc_practice_app.listeners

import com.applications.mvc_practice_app.model.TMDBData
import com.applications.mvc_practice_app.networking.Constants

interface ViewerEvents {
    fun setTitle(title: kotlin.String)
    fun setPage(page: Int?, maxPage: Int?)
    fun addDataFragment(type: Constants.ListType)
    fun addDetailsFragment(data: TMDBData)

}