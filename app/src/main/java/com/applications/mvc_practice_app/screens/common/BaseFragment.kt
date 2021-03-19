package com.applications.mvc_practice_app.screens.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.listeners.ViewerEvents
import com.applications.mvc_practice_app.roots.PresentationCompositionRoot
import java.lang.IllegalArgumentException

open class BaseFragment: Fragment() {

    protected var viewerEvents: ViewerEvents? = null
    val compositionRoot by lazy { PresentationCompositionRoot(requireActivity() as AppCompatActivity) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ViewerEvents){
            viewerEvents = context
        }else{
            throw IllegalArgumentException("parent activity must implement ViewerEvents")
        }
    }
}