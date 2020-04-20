package com.example.testdemo.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-3-30 上午11:00
 */
class ImageUtils {

    companion object {

        @JvmStatic
        fun hashKeyForCache(key: String): String? {
            val cacheKey: String?
            cacheKey = try {
                val mDigest: MessageDigest = MessageDigest.getInstance("MD5")
                mDigest.update(key.toByteArray())
                bytesToHexString(mDigest.digest())
            } catch (e: NoSuchAlgorithmException) {
                key.hashCode().toString()
            }
            return cacheKey
        }

        @JvmStatic
        private fun bytesToHexString(bytes: ByteArray): String? {
            val sb = StringBuilder()
            for (i in bytes.indices) {
                val hex = Integer.toHexString(0xFF and bytes[i].toInt())
                if (hex.length == 1) {
                    sb.append('0')
                }
                sb.append(hex)
            }
            return sb.toString()
        }
    }
}