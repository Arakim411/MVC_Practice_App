package com.applications.mvc_practice_app.roots

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.screens.detailsFragmentComponent.FragmentDetails

class FragmentRoots(private  val fragmentManager: FragmentManager) {
    fun addDataFragment(fragment: Fragment, @IdRes containerId: Int){
        Log.d("XD5","XD232")
        fragmentManager.beginTransaction().add(containerId,fragment).addToBackStack("").commit()
    }
    fun addDetailsFragment(data: TMDBData,@IdRes containerId: Int){
        fragmentManager.beginTransaction().add(containerId,FragmentDetails.getInstance(data)).addToBackStack("").commit()
    }
}