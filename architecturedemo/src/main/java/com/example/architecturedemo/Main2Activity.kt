package com.example.architecturedemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*
import android.app.ActivityManager
import android.content.Context


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.e("Main2Activity","oncreate")

        tv2.setOnClickListener {
            startActivity(Intent(this,Main3Activity::class.java).apply {
//                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
//                addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            })
        }

        tv3.setOnClickListener {
            Log.e("Main2Activity","set resultok")
            setResult(Activity.RESULT_OK)
            finish()
        }



    }

//    override fun onNewIntent(intent: Intent) {
//        super.onNewIntent(intent)
//
//        //省略部分代码
//
//        if (intent.flags or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT > 0) {
//            mIsRestoredToTop = true
//        }
//    }

}
