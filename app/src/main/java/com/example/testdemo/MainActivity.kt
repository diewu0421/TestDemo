package com.example.testdemo

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.testdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTv.text = """${Resources.getSystem().displayMetrics.widthPixels} + "\n" + ${Resources.getSystem().displayMetrics.heightPixels} + "\n"+ ${Resources.getSystem().displayMetrics.density} + "\n" + ${Resources.getSystem().displayMetrics.densityDpi}"""


    }
}
