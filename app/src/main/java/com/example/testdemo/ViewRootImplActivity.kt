package com.example.testdemo

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_root_impl.*
import kotlin.concurrent.thread

class ViewRootImplActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_root_impl)

        tv.setOnClickListener {


            thread {
                Looper.prepare()
                val dialog = MyDialog(this)
                dialog.show()
                Looper.loop()
            }
        }
    }

}

class MyDialog(context: Context) : Dialog(context) {

    init {

        setContentView(R.layout.view_root_impl_dialog_layout)

        val tv = findViewById<TextView>(R.id.tv1)?.apply {

        }

        findViewById<Button>(R.id.confirm)?.let {

        }
        findViewById<Button>(R.id.cancel)?.let {
            it.setOnClickListener {
                Log.e("MyDialog","${Thread.currentThread().name} ")
                printViewParentHierarchy(tv, 0)

                mHandler.post {
                    tv?.text = "${tv?.text}?"
                }
            }
        }

    }

    private val mBuffer = StringBuffer()


    private fun printParent(view: Any?) {
//        mBuffer.append("\t")
        view?.let {
            Log.e("MyDialog","${view.javaClass.simpleName}")
            if (view is View) {
                printParent(view.parent as? View)
            }
        }


    }

    private fun printViewParentHierarchy(view: Any?, level: Int) {
        if (view == null) {
            return
        }
        val sb = StringBuilder()
        for (i in 0 until level) {
            sb.append("\t")
        }
        sb.append(view.javaClass.simpleName)
        Log.e("lmj", sb.toString())
        if (view is View) {
            printViewParentHierarchy(view.parent, level + 1)
        }
    }

    private val mHandler = Handler(Looper.getMainLooper())


}
