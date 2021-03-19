package com.applications.mvc_practice_app.custom

import android.app.ActionBar
import android.content.Context
import android.drm.DrmStore
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.applications.mvc_practice_app.R
import kotlinx.android.synthetic.main.my_toolbar.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.title


class MyToolbar(context: Context,attrs: AttributeSet?): Toolbar(context,attrs) {

     private  val view = LayoutInflater.from(context).inflate(R.layout.my_toolbar, this, true)


     fun setTitle(title: String) {
       view.toolBarTitle.text = title
    }

    fun setPage(page: Int, maxPages: Int){
        view.page.text = resources.getString(R.string.Page,page,maxPages)
    }

    fun setPageEnabled(value: Boolean){
        view.page.visibility = if(value) View.VISIBLE else View.GONE
    }

    fun setBackArrowClick(clickEvent:() -> Unit?){
        view.backArrow.setOnClickListener {
            clickEvent()
        }
    }

    fun setBackArrowEnabled(value: Boolean){
        view.backArrow.isEnabled = value
        view.backButton.visibility = if(value) View.VISIBLE else View.GONE
    }

    fun isBackArrowVisible(): Boolean{
       if(view.backButton.visibility == View.VISIBLE)
           return true

        return false
    }

}