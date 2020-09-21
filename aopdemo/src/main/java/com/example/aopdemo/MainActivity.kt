package com.example.aopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    private var name:String ? = "zenglw0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val url = BaseNetTools().getUrl("http://www.baidu.com")
//        Log.e("MainActivity","url = $url")
        TestKotlinClass().test()
        resources.displayMetrics.widthPixels
        onClick()
//        resources.displayMetrics.widthPixels

        MyInnerClass().innerMethod()

        val linkedList = LinkedList<String>()
        linkedList.add("niasdf")
        Log.e("MainActivity","onCreate list ${linkedList.get(1)}")

        Log.e("MainActivity","onCreate $name")
    }

    fun onClick() {
        Log.e("MainActivity","onClick ")

    }

    inner class MyInnerClass {
        fun innerMethod() {
            Log.e("MainActivity","innerMethod ")
            1/ 0
        }
    }
}
