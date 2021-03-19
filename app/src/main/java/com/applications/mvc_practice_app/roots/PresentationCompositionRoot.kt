package com.applications.mvc_practice_app.roots

import androidx.appcompat.app.AppCompatActivity

class PresentationCompositionRoot(appCompatActivity: AppCompatActivity) {

    // other roots
    private  val activityCompositionRoot = ActivityCompositionRoot(appCompatActivity)
    val fragmentRoots = FragmentRoots(appCompatActivity.supportFragmentManager)

    val fetchMovieUseCase get() = activityCompositionRoot.fetchMovieUseCase
    val fetchTvShowUseCase get() = activityCompositionRoot.fetchTvShowUseCase
    // views Mvc Factory
    val movieViewsMvcFactory get() =  activityCompositionRoot.showDataViewsMvc
    val homeViewsMvcFactory get() = activityCompositionRoot.navigatorViewsMvc
    val detailsViewsMvcFactory get() = activityCompositionRoot.detailsViewsMvc


    // other
    val dialogNavigator get() = activityCompositionRoot.dialogNavigator





}