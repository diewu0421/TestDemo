package com.example.fueldemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-29 10:47
 */
class MyView @JvmOverloads constructor(context: Context, attrSets: AttributeSet? = null, defStyleAttrs: Int = 0)
    : ViewGroup(context, attrSets, defStyleAttrs) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }


    init {


//        setWillNotDraw(false)
//        setBackgroundColor(Color.RED)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        Log.e("MyView","onDraw")

//        postInvalidateDelayed(2000)
    }

    fun remove() {
        handler.removeCallbacksAndMessages(null)
    }
}