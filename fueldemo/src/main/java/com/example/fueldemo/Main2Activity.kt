package com.example.fueldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.e("Main2Activity","onCreate ")
    }

    override fun onResume() {
        super.onResume()
//        recreate()
        Log.e("Main2Activity","onResume ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Main2Activity","onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Main2Activity","onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Main2Activity","onDestroy")
    }
}
