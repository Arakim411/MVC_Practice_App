package com.applications.mvc_practice_app.roots

import androidx.appcompat.app.AppCompatActivity

class PresentationCompositionRoot(appCompatActivity: AppCompatActivity) {

    // other roots
    private  val activityCompositionRoot = ActivityCompositionRoot(appCompatActivity)
    val fragmentRoots = FragmentRoots(appCompatActivity.supportFragmentManager)

    val fetchMovieUseCase get() = activityCompositionRoot.fetchMovieUseCase
    // views Mvc Factory
    val movieViewsMvcFactory get() =  activityCompositionRoot.moviesViewsMvc
    val navigatorViewsMvcFactory get() = activityCompositionRoot.navigatorViewsMvc


    // other
    val dialogNavigator get() = activityCompositionRoot.dialogNavigator





}