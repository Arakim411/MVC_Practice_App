package com.applications.mvc_practice_app.screens.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.model.FragmentToolBarData
import com.applications.mvc_practice_app.listeners.ViewerEvents
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.roots.PresentationCompositionRoot
import java.lang.IllegalArgumentException

open class BaseFragment: Fragment() {

     var viewerEvents: ViewerEvents? = null
    private var toolbarData: FragmentToolBarData? = null
    val compositionRoot by lazy { PresentationCompositionRoot(requireActivity() as AppCompatActivity) }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ViewerEvents){
            viewerEvents = context
        }else{
            throw IllegalArgumentException("parent activity must implement ViewerEvents")
        }
    }
    fun setToolBarData(toolbarData: FragmentToolBarData){
        this.toolbarData = toolbarData
        viewerEvents?.setTitle(toolbarData.title)
        setUpToolBarWithFragmentData()
    }

     fun setUpToolBarWithFragmentData(){
        val tempData = toolbarData
        if(tempData != null){
            viewerEvents?.setTitle(tempData.title)
                viewerEvents?.setPage(tempData.page,tempData.maxPage)
        }
    }

}