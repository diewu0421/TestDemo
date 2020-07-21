package com.example.testdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup

class ProcessLifeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process_life).apply {

        }
        startActivity(Intent(this, LeakTestActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        (window.decorView as ViewGroup).getChildAt(1).visibility = View.GONE

    }
}