package com.example.testdemo

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2020-04-17 14:49
 */
class LeakTestActivity : AppCompatActivity() {

//    companion object {
        var drawable: Drawable? = null
//    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawable = getDrawable(R.drawable.test)

        setContentView(ImageView(this).apply {
            setImageDrawable(drawable)
        })
    }

    override fun finish() {
//        drawable?.toBitmap()
//        drawable = null
        super.finish()
    }
}