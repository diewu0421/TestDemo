package com.example.testdemo

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.mylibrary.IMAGE2_APNG
import com.example.mylibrary.IMAGE2_GIF
import com.example.mylibrary.IMAGE2_WEBP_GIF
import com.example.testdemo.utils.ImageLoader
import com.example.testdemo.utils.ImageUtils
import com.github.sahasbhop.apngview.ApngImageLoader
import com.github.sahasbhop.apngview.ApngImageLoader.ApngConfig
import kotlinx.android.synthetic.main.lru_layout.*


/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-3-30 上午10:43
 */
class LruActivity : AppCompatActivity() {

    private val mImageLoader by lazy { ImageLoader() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lru_layout)
        ApngImageLoader.getInstance().init(applicationContext);


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 0, 0) == PackageManager.PERMISSION_GRANTED) {
//                load()
//            } else {
//                requestPermissions(
//                    arrayOf(
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    ), 100
//                )
//            }
//        } else {
//            load()
//        }


    }

    private fun load() {

        loadImage(iv1, IMAGE2_WEBP_GIF)
        loadImage(iv2, IMAGE2_APNG)
        loadImage(iv3, IMAGE2_GIF)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size >= 1 && requestCode == 100) {
        }
    }

    private fun loadImage(iv: ImageView, url:String) {
        val bitmap = mImageLoader.getBitmap(ImageUtils.hashKeyForCache(IMAGE2_WEBP_GIF) ?: "")
        if (bitmap != null) {
            iv.setImageBitmap(bitmap)

            Log.e("LruActivity","onCreate 从缓存取")
        } else {
            if (false) {
                ApngImageLoader.getInstance()
                    .displayApng(
                        url, iv,
                        ApngConfig(234234234, true)
                    )

            } else {

                val circleCrop: Transformation<Bitmap> = CircleCrop()
                Glide.with(this@LruActivity)
//                    .load(File("/sdcard/webp.webp"))
                    .load(url)

//                .optionalTransform(circleCrop)
//                    .optionalTransform(WebpDrawableTransformation(circleCrop))
//                    .transform(circleCrop)
                    .into(iv)

//                Glide.with(this@LruActivity).load(Uri.parse(IMAGE2_WEBP_GIF)).addListener(object :
//                    RequestListener<Drawable> {
//                    override fun onLoadFailed(
//                        e: GlideException?,
//                        model: Any?,
//                        target: Target<Drawable>?,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        Log.e("LruActivity", "onLoadFailed ")
//                        return true
//                    }
//
//                    override fun onResourceReady(
//                        resource: Drawable?,
//                        model: Any?,
//                        target: Target<Drawable>?,
//                        dataSource: DataSource?,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        iv.post {
////                            mImageLoader.addBitmap(
////                                ImageUtils.hashKeyForCache(IMAGE1) ?: "",
////                                (resource as BitmapDrawable).bitmap
////
////                            )
//                            iv.setImageDrawable(resource)
//                        }
//
//                        Log.e("LruActivity", "onResourceReady ")
//                        return true
//                    }
//                }).submit()
            }

        }
    }

    companion object {
        val TAG = this::class.java.simpleName
    }
}