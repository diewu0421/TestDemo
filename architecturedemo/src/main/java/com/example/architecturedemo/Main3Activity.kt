package com.example.architecturedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
//        tv3.setOnClickListener { finish() }
        tv3.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java).apply {
               setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            })
        }
    }
}
