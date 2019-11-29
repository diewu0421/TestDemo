package com.example.testdemo

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed
import com.example.mylibrary.MyUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val kodein = Kodein {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTv.text = """${Resources.getSystem().displayMetrics.widthPixels} + "\n" + ${Resources.getSystem().displayMetrics.heightPixels} + "\n"+ ${Resources.getSystem().displayMetrics.density} + "\n" + ${Resources.getSystem().displayMetrics.densityDpi}
            versionname = ${packageManager.getPackageInfo(packageName,0).versionName}
            productFlavors = ${resources.getString(R.string.yj_found_chinese)}
        """.trimMargin()

//
//        val identifier = resources.getIdentifier("test", "mipmap", packageName)
//
//        val drawable = getDrawable(identifier)
//        drawable?.let {
//            searchTv.background = it
//        }
        searchTv.setOnClickListener {
            Log.e("MainActivity","name = ${this.localClassName}")
        }

        MyUtils.printObject("Nihao")
        //内存泄漏
                val handler = Handler()
        handler.postDelayed({
            Log.e("MainActivity","handler")
        }, 500)
        TestClass("nihao")
        thread {

            val time = System.currentTimeMillis()
            var sum = 0
            for (i in 0 until 200000) {
                for (j in 0 until 200000) {

                    sum += i * j
                }
            }
            handler.post {
                searchTv.text = "sum = $sum time = ${System.currentTimeMillis() - time}"
            }
        }

    }
}


interface OnClick {
    fun onclick ()

    class OnClickImpl :OnClick {
        override fun onclick() {
        }

    }
}
