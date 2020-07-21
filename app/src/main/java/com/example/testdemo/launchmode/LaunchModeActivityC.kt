package com.example.testdemo.launchmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testdemo.R

class LaunchModeActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LaunchModeActivityC","onCreate ")
        setContentView(R.layout.activity_launch_mode_c)
    }

    override fun onStart() {
        super.onStart()
        Log.e("LaunchModeActivityC","onStart ")
    }
    
    override fun onResume() {
        super.onResume()
        Log.e("LaunchModeActivityC","onResume ")
    }
    
    override fun onStop() {
        super.onStop()
        Log.e("LaunchModeActivityC","onStop ")
    }
    
    override fun onRestart() {
        super.onRestart()
        Log.e("LaunchModeActivityC","onRestart ")
    }
    
    override fun onPause() {
        super.onPause()
        Log.e("LaunchModeActivityC","onPause ")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.e("LaunchModeActivityC","onDestroy ")
    }
}
