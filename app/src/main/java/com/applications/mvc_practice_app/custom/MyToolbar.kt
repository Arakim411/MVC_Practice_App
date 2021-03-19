package com.applications.mvc_practice_app.custom

import android.app.ActionBar
import android.content.Context
import android.drm.DrmStore
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toolbar
import com.applications.mvc_practice_app.R
import kotlinx.android.synthetic.main.my_toolbar.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.title

class MyToolbar(context: Context,attrs: AttributeSet?): Toolbar(context,attrs) {

     private  val view = LayoutInflater.from(context).inflate(R.layout.my_toolbar, this, true)



    override fun setTitle(title: CharSequence?) {
       view.toolBarTitle.text = title
    }

    fun setPage(page: Int, maxPages: Int){
        view.page.text = resources.getString(R.string.Page,page,maxPages)
    }

}