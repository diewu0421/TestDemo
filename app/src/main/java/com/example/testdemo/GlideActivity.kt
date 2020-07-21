package com.example.testdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        loadImage.setOnClickListener {
            Glide.with(this).load(IMAGE_URL).into(iv)
        }
    }
}
