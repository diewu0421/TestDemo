package com.example.inflatefactory

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        root.numColumns = 2
        root.stretchMode = GridView.NO_STRETCH
        root.adapter = object : BaseAdapter() {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
               return layoutInflater.inflate(R.layout.wechat_popwin_item, parent ,false).apply {
                   if (position == 0)  setBackgroundColor(Color.BLUE) else setBackgroundColor(Color.BLACK)
               }

            }

            override fun getItem(position: Int): Any {
                return "content"
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getCount(): Int {
                return 2
            }

        }
    }
}
