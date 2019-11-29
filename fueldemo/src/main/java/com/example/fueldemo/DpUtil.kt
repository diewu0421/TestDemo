package com.example.fueldemo

import android.content.res.Resources

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-21 14:15
 */
class DpUtil {
    companion object {
        @JvmStatic
        fun dp2px(size: Float): Int {

            /**
             * Value of dp to value of px.
             *
             * @param dpValue The value of dp.
             * @return value of px
             */
            fun dp2px(dpValue: Float): Int {
                val scale = Resources.getSystem().displayMetrics.density
                return (dpValue * scale + 0.5f).toInt()
            }


            return dp2px(size)


        }

        /**
         * 将sp值转换为px值，保证文字大小不变
         */
        @JvmStatic
        fun sp2px(spValue: Float): Float {

            val fontScale = Resources.getSystem().displayMetrics.scaledDensity
            return spValue * fontScale + 0.5f
        }
    }
}