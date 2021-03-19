package com.applications.mvc_practice_app

import androidx.appcompat.app.AppCompatActivity
import com.applications.mvc_practice_app.custom.MyToolbar
import com.applications.mvc_practice_app.roots.PresentationCompositionRoot
import kotlinx.android.synthetic.main.activity_main.view.*

open class BaseActivity(): AppCompatActivity() {
    private  var myToolbar: MyToolbar? = null
    val compositionRoot by lazy { PresentationCompositionRoot(this) }
    fun setMyToolbar(myToolbar: MyToolbar){
        this.myToolbar = myToolbar
    }

    fun getMyToolbar(): MyToolbar?{
        return myToolbar
    }
}