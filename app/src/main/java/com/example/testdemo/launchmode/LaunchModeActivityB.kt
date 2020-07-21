package com.example.testdemo.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testdemo.R


class DeadThreadLock(val lock1: String, val lock2: String) : Runnable {
    override fun run() {

        synchronized(lock1) {

            Log.e("DeadThreadLock", "run ${Thread.currentThread().name} $lock1")

            Thread.sleep(1000)


            Log.e("DeadThreadLock", "死或处罚")
            synchronized(lock2) {
                Log.e("DeadThreadLock", "run11 ${Thread.currentThread().name} $lock1")

            }

        }

    }

}

class LaunchModeActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LaunchModeActivityB", "onCreate ")
        setContentView(R.layout.activity_launch_mode_b)

        val lock1 = "lock1"
        val lock2 = "lock2"

        Thread(DeadThreadLock(lock1, lock2), "线程1").start()
        Thread(DeadThreadLock(lock2, lock1), "线程2").start()


//        sendBroadcast(Intent("action1"))
    }

    fun jumpA(view: View) {
        startActivity(Intent(this, LaunchModeActivityC::class.java).apply {
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        })
    }

    fun close(view: View) {
        finish()
        setResult(101, null)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("LaunchModeActivityB", "onNewIntent ")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LaunchModeActivityB", "onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LaunchModeActivityB", "onResume ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LaunchModeActivityB", "onStop ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LaunchModeActivityB", "onRestart ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LaunchModeActivityB", "onPause ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LaunchModeActivityB", "onDestroy ")
    }
}
