package com.example.testdemo

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_leak_test.*

class LeakTestActivity : AppCompatActivity() {
//    companion object {
        var drawable: Drawable? = null

//    }

//    private lateinit var iv: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_test)

        drawable = getDrawable(R.drawable.ic_launcher_background)

//        iv = ImageView(this)
//        iv.layoutParams = ViewGroup.LayoutParams(-2, -2)
        iv.setImageDrawable(drawable)
        iv.setOnClickListener {
            Log.e("LeakTestActivity","onCreate 123411111111111")

//            Log.e("LeakTestActivity","onCreate asdfasdf")
            test()
        }
    }

    private fun test(){
        Toast.makeText(this , "Teasdfas ", Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        iv.setImageDrawable(null)
        drawable = null
    }
}
