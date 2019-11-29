package com.example.fueldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fueldemo.databinding.DBBinding

class DatabindingActivity : AppCompatActivity() {

    private val myViewModel by lazy {MyViewModel() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_databinding)
        val inflate = DBBinding.inflate(layoutInflater)
        setContentView(inflate.root)

    }
}
