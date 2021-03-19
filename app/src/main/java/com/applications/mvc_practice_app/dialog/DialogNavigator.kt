package com.applications.mvc_practice_app.dialog

import androidx.fragment.app.FragmentManager

class DialogNavigator(private val fragmentManager: FragmentManager) {

    fun showConnectionErrorDialog(){
        fragmentManager.beginTransaction().add(ServerErrorDialogFragment.newInstance(),null).commit()
    }
}