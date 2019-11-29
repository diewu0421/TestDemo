package com.example.fueldemo

import android.graphics.Paint
import android.text.TextPaint
import android.text.style.AbsoluteSizeSpan

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-21 16:35
 */
class AbsoluteSize(size: Int, isDp: Boolean) : AbsoluteSizeSpan(size, isDp) {

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.fontMetrics
    }
}