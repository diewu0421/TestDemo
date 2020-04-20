package com.example.inflatefactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.asynclayoutinflater.view.AsyncLayoutInflater

class AsyncInflateActivity : AppCompatActivity() {
    private var start = System.currentTimeMillis()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e("AsyncInflateActivity","onAttachedToWindow ${System.currentTimeMillis() - start}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        start = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
//        AsyncLayoutInflater.OnInflateFinishedListener { view, resid, parent ->
//
//        }
//        setContentView(R.layout.activity_async_inflate)
//        Log.e("AsyncInflateActivity","onCreate time = ${System.currentTimeMillis() - start}")
        AsyncLayoutInflater(this).inflate(R.layout.activity_async_inflate, null
        ) { view, resid, parent ->
            setContentView(resid)
            Log.e("AsyncInflateActivity","onCreate time = ${System.currentTimeMillis() - start}")
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.e("AsyncInflateActivity","onWindowFocusChanged ${System.currentTimeMillis() - start}")
    }

    override fun onResume() {
        super.onResume()
        Log.e("AsyncInflateActivity","onResume ${System.currentTimeMillis() - start}")
    }
}
