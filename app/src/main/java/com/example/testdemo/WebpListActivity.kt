package com.example.testdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mylibrary.IMAGE2_GIF
import com.example.mylibrary.IMAGE2_WEBP_GIF
import kotlinx.android.synthetic.main.activity_webp_list.*

class WebpListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webp_list)
        startActivity(Intent(this, LeakTestActivity::class.java))

        rv.apply {

            layoutManager = LinearLayoutManager(this@WebpListActivity)

            val list = arrayListOf<String>()
            (0..100).mapTo(list) { if (it % 2 == 0) IMAGE2_GIF else IMAGE2_WEBP_GIF }

            adapter = object: BaseQuickAdapter<String, BaseViewHolder>(R.layout.webp_item_layout, list) {
                override fun convert(helper: BaseViewHolder, item: String) {

                    helper.getView<ImageView>(R.id.iv)?.let {imageView->
                        Glide.with(this@WebpListActivity)
                            .load(Uri.parse(item))
                            .into(imageView)
                    }
                }

            }
        }
    }
}
