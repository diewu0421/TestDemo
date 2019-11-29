package com.example.aopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = BaseNetTools().getUrl("http://www.baidu.com")
        Log.e("MainActivity","url = $url")
    }
}
