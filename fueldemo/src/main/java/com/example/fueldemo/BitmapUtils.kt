package com.example.fueldemo

import android.graphics.BitmapFactory
import android.graphics.Bitmap.CompressFormat
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream


/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-03 19:25
 */
/**
 * Return the compressed bitmap using quality.
 *
 * @param src         The source of bitmap.
 * @param maxByteSize The maximum size of byte.
 * @param recycle     True to recycle the source of bitmap, false otherwise.
 * @return the compressed bitmap
 */

private fun isEmptyBitmap(src: Bitmap?): Boolean {
    return src == null || src.width == 0 || src.height == 0
}

fun compressByQuality(
    src: Bitmap,
    maxByteSize: Long,
    recycle: Boolean
): Bitmap? {
    if (isEmptyBitmap(src) || maxByteSize <= 0) return null
    val baos = ByteArrayOutputStream()
    src.compress(CompressFormat.WEBP, 100, baos)
    val bytes: ByteArray
    if (baos.size() <= maxByteSize) {
        bytes = baos.toByteArray()
    } else {
        baos.reset()
        src.compress(CompressFormat.WEBP, 0, baos)
        if (baos.size() >= maxByteSize) {
            bytes = baos.toByteArray()
        } else {
            // find the best quality using binary search
            var st = 0
            var end = 100
            var mid = 0
            while (st < end) {
                mid = (st + end) / 2
                baos.reset()
                src.compress(CompressFormat.WEBP, mid, baos)
                val len = baos.size()
                if (len.toLong() == maxByteSize) {
                    break
                } else if (len > maxByteSize) {
                    end = mid - 1
                } else {
                    st = mid + 1
                }
            }
            if (end == mid - 1) {
                baos.reset()
                src.compress(CompressFormat.WEBP, st, baos)
            }
            bytes = baos.toByteArray()
        }
    }
    if (recycle && !src.isRecycled) src.recycle()
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}