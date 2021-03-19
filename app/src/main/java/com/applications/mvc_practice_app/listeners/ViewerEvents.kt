package com.applications.mvc_practice_app.listeners

import android.provider.ContactsContract
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.networking.Constants

interface ViewerEvents {
    fun setTitle(title: kotlin.String)
    fun setPage(page: Int?, maxPage: Int?)
    fun addDataFragment(type: Constants.ListType)
    fun addDetailsFragment(data: TMDBData)

}