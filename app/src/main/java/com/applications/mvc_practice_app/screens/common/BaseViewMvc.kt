package com.applications.mvc_practice_app.screens.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

open  class BaseViewMvc<LISTENER_TYPE>(private val layoutInflater: LayoutInflater,private val parent: ViewGroup?, @LayoutRes layoutId: Int) {

    val rootView: View = layoutInflater.inflate(layoutId,parent,false)

   protected  val listeners = HashSet<LISTENER_TYPE>()
    protected val context: Context get() = rootView.context

    fun addListener(listener: LISTENER_TYPE){
        listeners.add(listener)
    }

    fun removeListener(listener: LISTENER_TYPE){
        listeners.remove(listener)
    }

}