package com.applications.mvc_practice_app.roots

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentRoots(private  val fragmentManager: FragmentManager) {
    fun addFragment(fragment: Fragment,@IdRes containerId: Int){
        Log.d("XD5","XD232")
        fragmentManager.beginTransaction().add(containerId,fragment).addToBackStack("").commit()
    }
}