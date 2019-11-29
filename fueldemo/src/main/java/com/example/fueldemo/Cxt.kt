package com.example.fueldemo

import android.content.Context

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-21 14:13
 */
class Cxt {
    companion object {
        @JvmStatic
        var mContext: Context? = null

        @JvmStatic
        fun get()  = mContext
    }
}