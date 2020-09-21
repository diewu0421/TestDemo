package com.example.aopdemo.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.aopdemo.R

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-8-4 下午3:41
 */
class MyView @JvmOverloads constructor(context: Context, attrSets: AttributeSet? = null, defStyleAttrs: Int = 0)
    : View(context, attrSets, defStyleAttrs) {
    private var mWidth:Int = 0
    private var mHeight: Int = 0

    private val mPaint by lazy { Paint().apply {
        isDither = true
        isAntiAlias = true
        style = Paint.Style.FILL

    }}

    private val mTextPaint by lazy { Paint().apply {
        isDither = true
        isAntiAlias = true

        textSize = dp2px(16.0f)
    }}


    private val mBgRectF by lazy { RectF() }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        mWidth = MeasureSpec.getSize(widthMeasureSpec)
//        mHeight = MeasureSpec.getSize(heightMeasureSpec)
        val modeWidth = MeasureSpec.getMode(widthMeasureSpec)

        mWidth = if (modeWidth == MeasureSpec.EXACTLY) {
            MeasureSpec.getSize(widthMeasureSpec)
        } else {
            dp2px(110.0f).toInt()

        }
        val modeHeight = MeasureSpec.getMode(heightMeasureSpec)

        mHeight = if (modeHeight == MeasureSpec.EXACTLY) {
            MeasureSpec.getSize(heightMeasureSpec)
        } else {
            dp2px(14.0f).toInt()
        }
        mBgRectF.apply {
            set(0f, 0f, mWidth.toFloat(), mHeight.toFloat())
        }
        setMeasuredDimension(mWidth, mHeight)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        mPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        canvas.drawRoundRect(mBgRectF, mHeight / 2.0f, mHeight / 2.0f, mPaint)

        val rect = getBound("Hello World")

        canvas.drawText("Hello World", 0, "Hello World".length, 10.0f, mHeight.toFloat() - (mHeight / 2f - (rect.bottom - rect.top) / 2f), mTextPaint)

    }

    private fun getBound(str:String): Rect {
        val rect = Rect()
        mTextPaint.getTextBounds(str, 0, str.length, rect)
        return rect
    }

    /**
     * Value of dp to value of px.
     *
     * @param dpValue The value of dp.
     * @return value of px
     */
    fun dp2px(dpValue: Float): Float {
        val scale =
            Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f)
    }
}