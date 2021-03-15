package com.applications.mvc_practice_app.screens.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.screens.roots.ActivityCompositionRoot
import com.applications.mvc_practice_app.screens.roots.PresentationCompositionRoot

open class BaseFragment: Fragment() {


    //znajdz activityCompositionRoot

    val compositionRoot by lazy { PresentationCompositionRoot(requireActivity() as AppCompatActivity) }
}