package com.example.testdemo

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_root_impl.*

class ViewRootImplActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_root_impl)

        tv.setOnClickListener {

            val dialog = MyDialog(this)
            dialog.show()
        }
    }


}

class MyDialog(context: Context) : Dialog(context) {

    init {

        setContentView(R.layout.view_root_impl_dialog_layout)

        findViewById<TextView>(R.id.tv1)?.let {

        }
        findViewById<Button>(R.id.confirm)?.let {

        }
        findViewById<Button>(R.id.cancel)?.let {

        }
    }

}
