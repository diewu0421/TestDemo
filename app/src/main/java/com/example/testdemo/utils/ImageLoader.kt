package com.example.testdemo.utils

import android.graphics.Bitmap
import android.util.LruCache

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-3-30 上午10:56
 */
class ImageLoader {

    private val mLruCache by lazy {
        object : LruCache<String, Bitmap>(Runtime.getRuntime().maxMemory().toInt() / 8) {
            override fun sizeOf(key: String?, value: Bitmap?): Int {
                return value?.byteCount ?: 0
            }
        }
    }

    fun addBitmap(key: String, bitmap: Bitmap) {
        val oldBitmap = getBitmap(key)
        if (oldBitmap == null) {

            mLruCache.put(key, bitmap)
        }

    }

    fun getBitmap(key: String): Bitmap? {
        return mLruCache.get(key)
    }

    fun removeBitmap(key:String) {
        mLruCache.remove(key)
    }
}