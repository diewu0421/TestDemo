package com.example.architecturedemo.view

import android.annotation.SuppressLint
import android.util.ArrayMap
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.*

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-07-18 17:07
 */
@SuppressLint("RestrictedApi")
class NewItemView() : GenericLifecycleObserver {
    override fun onStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {
        
        Log.e("NewItemView","source = $source   event = $event")

        if (event == Lifecycle.Event.ON_DESTROY) {
            map?.clear()
            map = null
            Log.e("NewItemView","clear map")
        }
    }

    private var map: androidx.collection.ArrayMap<String, String>? = null

    init {

        map?.put("name", "zlw")
        map?.put("age","23")

    }

    fun bindData(tv: TextView, str: String) {

        Log.e("NewItemView", "tv is lifeowner = ${tv.context is LifecycleOwner}")

        val lifecycleOwner = tv.context as LifecycleOwner
        lifecycleOwner.lifecycle.addObserver(this)
    }
}