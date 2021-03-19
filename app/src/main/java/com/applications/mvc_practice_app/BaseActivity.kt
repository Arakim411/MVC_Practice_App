package com.applications.mvc_practice_app

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.applications.mvc_practice_app.custom.MyToolbar
import com.applications.mvc_practice_app.roots.PresentationCompositionRoot
import com.applications.mvc_practice_app.screens.common.BaseFragment

private const val BACK_ARROW_KEY = "back_arrow_key"


open class BaseActivity() : AppCompatActivity() {
    private var myToolbar: MyToolbar? = null
    val compositionRoot by lazy { PresentationCompositionRoot(this) }

    init {
        supportFragmentManager.addOnBackStackChangedListener {
            if (myToolbar != null) {
                if (supportFragmentManager.backStackEntryCount > 1) {
                    myToolbar?.setBackArrowEnabled(true)
                } else {
                    myToolbar?.setBackArrowEnabled(false)
                }
                val visibleFragment = getVisibleFragment()
                if(visibleFragment != null)
                    (visibleFragment as BaseFragment).setUpToolBarWithFragmentData()
            }
        }
    }


    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 1)
            finish()

        super.onBackPressed()
    }

    fun setMyToolbar(myToolbar: MyToolbar) {
        this.myToolbar = myToolbar
        setActionBar(myToolbar)
        myToolbar.setBackArrowClick {
            onBackPressed()
        }
    }

    fun getMyToolbar(): MyToolbar? {
        return myToolbar
    }

    private fun getVisibleFragment(): Fragment? {
        val fragments: List<Fragment> = supportFragmentManager.fragments

            for (fragment in fragments.asReversed()) {
                if (fragment.isVisible) return fragment
            }

        return null
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val isBackArrowVisible = savedInstanceState.getBoolean(BACK_ARROW_KEY)
        myToolbar?.setBackArrowEnabled(isBackArrowVisible)
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(BACK_ARROW_KEY,myToolbar?.isBackArrowVisible() ?: false)
        super.onSaveInstanceState(outState)
    }
}