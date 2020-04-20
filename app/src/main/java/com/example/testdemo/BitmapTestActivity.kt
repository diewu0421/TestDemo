package com.example.testdemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bitmap_test.*


class BitmapTestActivity : AppCompatActivity() {
    private val iv by lazy { findViewById<ImageView>(R.id.iv) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_test)
        load_img.setOnClickListener {
            //            Glide.with(this@BitmapTestActivity).load(R.mipmap.test).into(iv)
//            val options = BitmapFactory.Options()
//            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.test, options)
//            Log.i(TAG, "bitmap：ByteCount = " + bitmap.byteCount + ":::bitmap：AllocationByteCount = " + bitmap.allocationByteCount)
//            Log.i(TAG, "width:" + bitmap.width + ":::height:" + bitmap.height)
//            Log.i(TAG, "inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity)
//
//            val options_setParams = BitmapFactory.Options()
//            options_setParams.inDensity = 320
//            options_setParams.inTargetDensity = 320
//            val bitmap_setParams =
//                BitmapFactory.decodeResource(resources, R.drawable.test, options_setParams)
//            Log.i(
//                TAG,
//                "bitmap_setParams：ByteCount = " + bitmap_setParams.byteCount + ":::bitmap_setParams：AllocationByteCount = " + bitmap_setParams.allocationByteCount
//            )
//            Log.i(
//                TAG,
//                "width:" + bitmap_setParams.width + ":::height:" + bitmap_setParams.height
//            )
//            Log.i(
//                TAG,
//                "inDensity:" + options_setParams.inDensity + ":::inTargetDensity:" + options_setParams.inTargetDensity
//            )

//            val options = BitmapFactory.Options()
//            // 图片复用，这个属性必须设置；
//            options.inMutable = true
//            // 手动设置缩放比例，使其取整数，方便计算、观察数据；
//            options.inDensity = 320
//            options.inTargetDensity = 320
//            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.test, options)
//            // 对象内存地址；
//            Log.i(TAG, "bitmap = $bitmap")
//            Log.i(
//                TAG,
//                "bitmap：ByteCount = " + bitmap.byteCount + ":::bitmap：AllocationByteCount = " + bitmap.allocationByteCount
//            )
//
//            // 使用inBitmap属性，这个属性必须设置；
//            options.inBitmap = bitmap
//            options.inDensity = 320
//            // 设置缩放宽高为原始宽高一半；
//            options.inTargetDensity = 160
//            options.inMutable = true
//            val bitmapReuse =
//                BitmapFactory.decodeResource(resources, R.drawable.test, options)
//            // 复用对象的内存地址；
//            Log.i(TAG, "bitmapReuse = $bitmapReuse")
//            Log.i(
//                TAG,
//                "bitmap：ByteCount = " + bitmap.byteCount + ":::bitmap：AllocationByteCount = " + bitmap.allocationByteCount
//            )
//            Log.i(
//                TAG,
//                "bitmapReuse：ByteCount = " + bitmapReuse.byteCount + ":::bitmapReuse：AllocationByteCount = " + bitmapReuse.allocationByteCount
//            )


//            bitmap.recycle()
            val bitmap = buildBitmap(this, 1600, 2500)
            iv.setImageBitmap(bitmap)
            iv2.setImageBitmap(bitmap)
        }
    }

    companion object {
        val TAG = BitmapTestActivity::class.java.simpleName

        fun buildBitmap(context: Context, reqWidth: Int, reqHeight: Int): Bitmap? {

            val opt = BitmapFactory.Options()

            opt.inJustDecodeBounds = true

            BitmapFactory.decodeResource(context.resources, R.drawable.test, opt)

            Log.e(
                "BitmapTestActivity",
                "buildBitmap width: = ${opt.outWidth} height: ${opt.outHeight} "
            )
            opt.inJustDecodeBounds = false
            opt.inSampleSize = 4
            return BitmapFactory.decodeResource(context.resources, R.drawable.test, opt)



        }

        private fun calculatorSample(opt:BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
            val width = opt.outWidth
            val height = opt.outHeight
            var sampleSize = 1

            if (width > reqWidth || height > reqHeight) {
//                val halfWidth = width / 2
//                val halfHeight = height / 2
                sampleSize *= 2

                while ((width / sampleSize) > reqWidth && (height / sampleSize) > reqHeight) {
                    sampleSize *= 2
                }
            }
            return sampleSize
        }
    }

}
