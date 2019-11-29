package com.example.touchdelegate

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TouchDelegate
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setOnClickListener {
            Toast.makeText(this@MainActivity, "child", Toast.LENGTH_SHORT).show()
        }
        tv.parent
            .let { it as View }
            .run {
                post {
                    Rect().apply {
                        tv.getHitRect(this)
                    }.let {
                        it.top -= 100
                        it.bottom += 100
                        it.left  -= 100
                        it.right += 100
                        touchDelegate = TouchDelegate(it, tv)

                    }
                }
                setOnClickListener {
                    Toast.makeText(this@MainActivity, "parent", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this@MainActivity, "parent", Toast.LENGTH_SHORT).show()

                }
            }
    }
}
