package com.example.testdemo.launchmode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.testdemo.R
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.File
import kotlin.math.log

class LaunchModeActivityA : AppCompatActivity() {

    private val myReceiver: MyReceiver
        get() {
            val receiver = MyReceiver()
            return receiver
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode_activity)
        Log.e("LaunchModeActivityA","onCreate $applicationContext")
//        Thread.sleep(20 * 1000L)

        registerReceiver(myReceiver, IntentFilter("action1"))
    }

    fun jump(view: View) {

//        Log.e("LaunchModeActivityA","jump before")
//        Thread.sleep(6000L)
//        Log.e("LaunchModeActivityA","jump after")
        startActivityForResult(Intent(this, LaunchModeActivityB::class.java).apply {
//            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }, 100)
//        Handler().postDelayed({
//
//            startActivity(Intent(this, LaunchModeActivityB::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//            })
//        }, 2000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("LaunchModeActivityA", "onActivityResult ")
    }


    override fun onStart() {
        super.onStart()
        Log.e("LaunchModeActivityA","onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LaunchModeActivityA","onResume ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LaunchModeActivityA","onStop ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LaunchModeActivityA","onRestart ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LaunchModeActivityA","onPause ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LaunchModeActivityA","onDestroy ")
        myReceiver?.let {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(it)
        }
    }
}

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("MyReceiver","onReceive before")
        Thread.sleep(22000)
//        Thread.sleep(30 * 1000L)
//        for (i in 0..100000000000) {

//            Log.e("MyReceiver","onReceive i = $i")
            Thread.sleep(1)
//        }
        Log.e("MyReceiver","onReceive after")
    }

}
