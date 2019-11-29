package com.example.inflatefactory

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.LayoutInflaterCompat

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
            override fun onCreateView(parent: View?, name: String?, context: Context, attrs: AttributeSet): View? {
                Log.e("MainActivity", "parent = $parent\nname = $name\ncontext=$context\nattrs=$attrs\n***************************************************************\n")

                var tempName = name
                if (name == "Button") {
                    tempName = "TextView"
                }
                val view = delegate.createView(parent, tempName, context, attrs)

                return view

            }

            override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
                return null
            }

        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
