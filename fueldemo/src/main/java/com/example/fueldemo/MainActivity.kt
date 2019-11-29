package com.example.fueldemo

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Layout
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.format.DateUtils
import android.text.style.*
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.LayoutInflaterCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private lateinit var dialog : AlertDialog
    private lateinit var mIv:ImageView
    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
//        startActivity(Intent(this, Main2Activity::class.java))
        LayoutInflaterCompat.setFactory2(layoutInflater, object : LayoutInflater.Factory2 {
            override fun onCreateView(
                parent: View?,
                name: String?,
                context: Context?,
                attrs: AttributeSet?
            ): View? {

                Log.e("MainActivity","onCreateView 四餐")
                return null
            }

            override fun onCreateView(
                name: String?,
                context: Context?,
                attrs: AttributeSet?
            ): View? {
                Log.e("MainActivity","onCreateView 三参")
                return null
            }

        })
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        mIv = findViewById(R.id.iv)
//        val str1 = "rgba(255,255,255,255)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas)按时发斯蒂芬asf阿萨德发斯蒂芬asas"
//        Log.d("MainActivity", "onCreate ${
//        measureTimeMillis { str1.contains("gba") }
//        }")
//
//
//        val myBo:MyBo.DataBean? = MyBo.DataBean()
//
//        Log.e("MainActivity","onCreate ${myBo?.fans}")
//        Toast.makeText(this, "onCreate ${myBo?.fans}", Toast.LENGTH_SHORT).show()
//
//
//        testTv.setText(SpanUtils()
//            .append("Niasdfasf")
//            .setBold()
//            .setForegroundColor(Color.RED)
//            .setFontSize(20,true)
//            .append("我看见asf")
//            .setFontSize(10)
//            .create())

        val str1  = "你好手动阀"
        val str2 = "你好"
//        testTv.setBackgroundColor(Color.RED)
//        AlignmentSpan.Standard standard=new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
//        spanstr.setSpan(standard,0,67,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        testTv.setText(SpannableStringBuilder(str1 + str2).apply {

            setSpan(
                MySpan(30, true),
                str1.length + 1,
                (str1 + str2).length,
                SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
            )



            setSpan(
                SuperscriptSpan(),
                str1.length + 1,
                (str1 + str2).length,
                SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
            )

            setSpan(
                BackgroundColorSpan(Color.YELLOW),
                0, (str1+ str2).length , Spannable.SPAN_INCLUSIVE_INCLUSIVE)

            setSpan(
                BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID),
                0, (str1+ str2).length , Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        })

//        bt.postDelayed({
//            guideline2.setGuidelinePercent(0.7f)
//        }, 2000)
//
//
//        mIv.setOnClickListener {
//
////            if (flag) {
////               tv2.visibility = View.VISIBLE
////            } else {
////                tv2.visibility = View.GONE
////            }
//
////            startActivity(Intent(this, DatabindingActivity::class.java))
////            val process = Runtime.getRuntime().exec(arrayOf("logcat", "-d", "-v", "threadtime"))
////            val logTxt = getSysLogInfo(process.inputStream)
////            Log.e("MainActivi" +
////                    "ty","onCreate ${String(process.inputStream.readBytes())}")
//
//            Log.e("MainActivity","onCreate calculator after")
//        }
//
//        window.decorView.setPadding(0, 0, 0, 0)
//
//        root.post {
//
//            BitmapFactory.decodeResource(resources, R.mipmap.bit).let { bitmap ->
//                Log.e("MainActivity","onCreate bitmap alph size = " + bitmap.allocationByteCount / 1024)
//
////                val bitmap1 = compressByQuality(bitmap, 100 * 1024L, true)
//
////                Log.e("MainActivity","onCreate bitmap size = " + (bitmap1?.allocationByteCount?.div(
////                    1024
////                ) ?: 0))
//                mIv.setImageBitmap(bitmap)
//            }
//
////            compressByQuality()
//
////            Bitmap.createBitmap(root.width, root.height, Bitmap.Config.ARGB_8888).let {bitmap ->
////                Canvas(bitmap).let {canvas ->
////                   root.draw(canvas)
////                }
////
////                Log.e("MainActivity","onCreate bitmap ${bitmap.byteCount}")
////                iv2.layoutParams.let { params ->
////                    params.width = bitmap.width
////                    params.height = bitmap.height
////                }
////                iv2.requestLayout()
////                iv2.setImageBitmap(bitmap)
////            }
//        }
////        dialog = AlertDialog.Builder(this).setMessage("asdffas")
////            .setIcon(R.drawable.ic_launcher_background)
////            .create()
////        dialog.show()
//
////        lifecycle.addObserver(this)
//
////        tv.setOnClickListener {
////        }
//
////        Handler().postDelayed({
//////           finish()
//////            1/ 0
////            myview.remove()
////        }, 2000)
////
////        Handler().postDelayed({
////            myview.postInvalidateDelayed(800)
////
////        },4000)

    }

    fun calculator() {
        for (i in IntRange(0, 100000000)) {
            Log.e("MainActivity", "calculator $i")
        }
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","onPause ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","onResume ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopTest() {
//       dialog.dismiss()
    }

    fun test(view: View) {

        MyDialog(this).show()
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName

        fun getUrl() =
            "https://sc-tx.yunjiglobal.com/yunjiscapp/app/queryRecommendList.json?consumerId=35072&isTodayFirstVisited=1&version=1&ticket=ticket%7C2_1e2cc69a7de070f76eb4ab575caff61b"

    }

}

class MyDialog(context: Context) : Dialog(context) {

    private lateinit var mRootView: View

   init {

       LayoutInflater.from(context).inflate(R.layout.dialog_test_layout, null).let {view ->
           mRootView = view


//           view.layoutParams.takeIf { it == null }?.let {
//
//           }
           window.decorView.setPadding(0, 0, 0, 0)
//           window.decorView.setBackgroundColor(Color.TRANSPARENT)

           val let = window.attributes.let { attr ->
               attr.width =Resources.getSystem().displayMetrics.widthPixels
               attr.height = Resources.getSystem().displayMetrics.heightPixels
//               attr.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
               attr
           }

           window.attributes = let
           if (mRootView.layoutParams == null) {
               mRootView.layoutParams = ViewGroup.LayoutParams(Resources.getSystem().displayMetrics.widthPixels,
                   Resources.getSystem().displayMetrics.heightPixels)
           } else {
               Log.e("MyDialog","show ")
               mRootView.layoutParams.width = Resources.getSystem().displayMetrics.widthPixels
               mRootView.layoutParams.height = Resources.getSystem().displayMetrics.heightPixels
           }
           mRootView.requestLayout()


           setContentView(view)
       }

   }

    override fun show() {

        super.show()
    }

}
