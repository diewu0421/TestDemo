package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import io.reactivex.Emitter
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private var flow: Flow<Int>? = null
    private var job: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate ")
        job = lifecycleScope.launchWhenResumed {

            Log.e("MainActivity", "onCreate launch whenresume")
            val time = measureTimeMillis {
//
//                val sum1 = async(start = CoroutineStart.LAZY) { getSum(5) }
//                val sum2 = async(start = CoroutineStart.LAZY) { getSum(3) }
//                sum2.start()
//                sum1.start()
//
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, "sum = ${sum1.await() + sum2.await()}", Toast.LENGTH_SHORT).show()
//                }
                // 1. 生成一个 Channel
                val channel = Channel<Int>()

                // 2. Channel 发送数据
                launch {
                    for(i in 1..5){
                        delay(200)
                        channel.send(i * i)
                    }
                    delay(1000L)
                    Log.e("MainActivity","onCreate close")
                    channel.close()
                }

                // 3. Channel 接收数据
                launch {
                    for( y in channel)
                        Log.e(TAG, "get $y")
                }
            }
        }

//        lifecycleScope.launchWhenCreated {
//            delay(1500L)
//            Log.e("MainActivity","onCreate start cancel flow")
//            job?.cancel()
//
//
//        }
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show()
    }


    private suspend fun getSum(int: Int): Int {
        Log.e("MainActivity", "getSum $int")
        delay(2000L)
        return int * int

    }
}
