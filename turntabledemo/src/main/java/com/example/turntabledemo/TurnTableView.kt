package com.example.turntabledemo

import android.animation.*
import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.properties.Delegates
import kotlin.random.Random

/**
 * 浙江集商优选电子商务有限公司
 * 音乐转盘动效
 * @author zenglw
 * @date   2019-06-26 15:17
 */
class TurnTableView @JvmOverloads constructor(
    context: Context,
    attrSets: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : ConstraintLayout(context, attrSets, defStyleAttrs) {

    private val musicIconIv: ImageView

    private var musicContainer: ConstraintLayout
    private var mWidth = 0f
    private var mHeight: Float by Delegates.observable(0f) { _, _, newValue ->
        Log.e("TurnTableView", "observable height = $newValue isRunning = ${mBezier1Animator.isRunning}")
//        if (newValue > 0 && !mBezier1Animator.isRunning) {
//            mAnimatorSet.start()
//        }
    }

    private val mNote1PointF = PointF()
    private val mNote2PointF = PointF()
    private val mNote3PointF = PointF()


    private val note1 by lazy {
        scaleBitmap(BitmapFactory.decodeResource(resources, R.drawable.note1), dp2px(10f), dp2px(10f))
    }
    private val note2 by lazy {
        scaleBitmap(BitmapFactory.decodeResource(resources, R.drawable.note2), dp2px(10f), dp2px(10f))
    }
    private val note3 by lazy {
        scaleBitmap(BitmapFactory.decodeResource(resources, R.drawable.note3), dp2px(10f), dp2px(10f))
    }

    private val mRotateAnimator by lazy {

        ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 12000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            interpolator = LinearInterpolator()

        }
    }

    private val mBezier1Animator by lazy {
        Log.e("TurnTableView", "宽度 = $mWidth 高度 = $mHeight")

        ValueAnimator.ofObject(
            BezierEvaluator(PointF(0f, mHeight / 2)),
            PointF(mWidth - dp2px(46f) - note1.width, mHeight - dp2px(46f) / 2 + note1.height),
            PointF(0f, -note1.height.toFloat())
        ).apply {
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                val value = it.animatedValue as PointF
                mNote1PointF.set(value.x, value.y)

                Log.e("TurnTableView","animatefraction = $animatedFraction  isRUnnint = ${mScale1Animator.isRunning}  scale1 = $mScale1")
                if (animatedFraction in 0.7f..0.8f && mScale1 <= 0.0f) {

                    if (!mScale1Animator.isRunning) {
                        Log.e("TurnTableView", "启动")
                        mScale1Animator.start()
                    }
                }

                invalidate()
            }

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    mScale1Animator.cancel()
                    mScale1 = 0.0f

                }

            })
        }
    }
    private val mBezier2Animator by lazy {
        Log.e("TurnTableView", "宽度 = $mWidth 高度 = $mHeight")

        ValueAnimator.ofObject(
            BezierEvaluator(PointF(0f, mHeight / 2)),
            PointF(mWidth - dp2px(46f) - note2.width, mHeight - dp2px(46f) / 2 + note2.height),
            PointF(0f, -note2.height.toFloat())
        ).apply {
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 1500

            addUpdateListener {
                val value = it.animatedValue as PointF
                mNote2PointF.set(value.x, value.y)

                if (animatedFraction >= 0.7f && mScale2 <= 0.0f) {
                    if (!mScale2Animator.isRunning) {
                        Log.e("TurnTableView", "启动")
                        mScale2Animator.start()
                    }
                }

                invalidate()
            }

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    mScale2Animator.cancel()
                    mScale2 = 0.0f

                }

            })
        }
    }
    private val mBezier3Animator by lazy {
        Log.e("TurnTableView", "宽度 = $mWidth 高度 = $mHeight")

        ValueAnimator.ofObject(
            BezierEvaluator(PointF(0f, mHeight / 2)),
            PointF(mWidth - dp2px(46f) - note3.width, mHeight - dp2px(46f) / 2 + note3.height),
            PointF(0f, -note3.height.toFloat())
        ).apply {
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 2500
            addUpdateListener {
                val value = it.animatedValue as PointF
                mNote3PointF.set(value.x, value.y)

                if (animatedFraction >= 0.7f && mScale3 <= 0.0f) {
                    if (!mScale3Animator.isRunning) {
                        Log.e("TurnTableView", "启动")
                        mScale3Animator.start()
                    }
                }

                invalidate()
            }

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    mScale3Animator.cancel()
                    mScale3 = 0.0f
                }

            })
        }
    }

    private val mScale1Animator by lazy {
        ObjectAnimator.ofFloat(0f, 1.0f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = 0
            addUpdateListener {
                //                mScale1 = 1 + (it.animatedValue as Float) / 2
                Log.e("TurnTableView", "scaleanimator = ${it.animatedValue}")

                mScale1 = it.animatedValue as Float
            }
        }
    }
    private val mScale2Animator by lazy {
        ObjectAnimator.ofFloat(0f, 1.0f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = 0
            addUpdateListener {
                //                mScale2 = 1 + (it.animatedValue as Float) / 2
                mScale2 = it.animatedValue as Float
            }
        }
    }
    private val mScale3Animator by lazy {
        ObjectAnimator.ofFloat(0f, 1.0f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = 0
            addUpdateListener {
                //                mScale3 = 1 + (it.animatedValue as Float) / 2
                mScale3 = it.animatedValue as Float
            }
        }
    }

    private var mScale1 = 0f
    private var mScale2 = 0f
    private var mScale3 = 0f

    /** 旋转角度 每次动画随机指定 */
    private var mRotate1 = 0f
    private var mRotate2 = 0f
    private var mRotate3 = 0f

    private val mAnimatorSet by lazy {
        AnimatorSet().apply {
//            playTogether(mBezier1Animator, mBezier2Animator, mBezier3Animator)
            play(mBezier1Animator)
            duration = 3500
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mHeight = MeasureSpec.getSize(heightMeasureSpec).toFloat()
    }

    private fun scaleBitmap(src: Bitmap, newWidth: Int, newHeight: Int): Bitmap {
        val matrix = Matrix().apply {
            postScale(newWidth.toFloat() / src.width, newHeight.toFloat() / src.height)
        }
        return Bitmap.createBitmap(src, 0, 0, src.width, src.height, matrix, true)
    }

    init {
        context.obtainStyledAttributes(attrSets, R.styleable.TurnTableView).let {

            val drawable = it.getResourceId(R.styleable.TurnTableView_turntable_resource, -1)
            musicContainer = ConstraintLayout(context).apply {
                layoutParams = LayoutParams(dp2px(46f), dp2px(46f)).apply {
                    bottomToBottom = LayoutParams.PARENT_ID
                    endToEnd = LayoutParams.PARENT_ID
                }

                //添加外面的黑色音乐转盘背景
                addView(
                    ImageView(context).apply {
                        layoutParams = LayoutParams(-1, -1)
                        takeIf { drawable != -1 }?.setBackgroundResource(drawable)
                    }
                )

                //添加音乐转盘上的图片
                musicIconIv = ImageView(context).apply {
                    layoutParams = LayoutParams(dp2px(22f), dp2px(22f))
                }
                addView(musicIconIv)

            }
            addView(musicContainer)
            it.recycle()
        }

        //应当取消这个监听器 在view释放掉的时候
        mRotateAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            musicContainer.rotation = value
        }

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        Log.e(
            "TurnTableView",
            "onDraw ${mNote1PointF.x}  ${mNote2PointF.x}  ${mNote3PointF.x}  scale1 = $mScale1 scale2 = $mScale2 scale3 = $mScale3"
        )

//        Log.e("TurnTableView","onDraw = scale1 = $mScale1 scale2 = $mScale2 scale3 = $mScale3")
        if (mNote1PointF.x > 0) {
            mMatrix1.setTranslate(mNote1PointF.x, mNote1PointF.y)
            mMatrix1.preScale(1 + mScale1 / 2, 1 + mScale1)
//            mMatrix1.preRotate(mRotate1)
            mPaint.alpha = ((1 - mScale1*0.95) * 255).toInt()
            Log.e("TurnTableView","alpha = ${mPaint.alpha} scale = ${mScale1}")
            canvas?.drawBitmap(note1, mMatrix1, mPaint)
        }

        if (mNote2PointF.x > 0) {
            mMatrix2.setTranslate(mNote2PointF.x, mNote2PointF.y)
            mMatrix2.preScale(1 + mScale2 / 2, 1 + mScale2 / 2)
//            mMatrix2.preRotate(mRotate2)
            mPaint.alpha = ((1 - mScale2*0.95 ) * 255).toInt()
            canvas?.drawBitmap(note2, mMatrix2, mPaint)

        }

        if (mNote3PointF.x > 0) {
            mMatrix3.setTranslate(mNote3PointF.x, mNote3PointF.y)
            mMatrix3.preScale(1 + mScale3 / 2, 1 + mScale3 / 2)
//            mMatrix3.preRotate(mRotate3)
            mPaint.alpha = ((1 - mScale3 *0.95) * 255).toInt()
            canvas?.drawBitmap(note3, mMatrix3, mPaint)
        }
    }

    private val mPaint by lazy {
        Paint().apply {
            isAntiAlias = true
            isDither = true
        }
    }

    private val path by lazy {
        Path().apply {

        }
    }

    /**
     * 停止动画
     */
    fun pause() {
        aboveKITKAT { mRotateAnimator.pause() }
    }

    fun start() {
        mRotateAnimator.start()
        mAnimatorSet.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        release()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e("TurnTableView","attach mwith = $mWidth height = $mHeight")
    }

    fun setMusicIcon(url: String?) {
        //todo
    }

    /**
     * 释放动画
     */
    fun release() {
        mRotateAnimator.end()
        mRotateAnimator.cancel()
        mAnimatorSet.end()
        mAnimatorSet.cancel()
        mBezier1Animator.cancel()
        mBezier2Animator.cancel()
        mBezier3Animator.cancel()

    }

    private val mMatrix1 by lazy { Matrix() }
    private val mMatrix2 by lazy { Matrix() }
    private val mMatrix3 by lazy { Matrix() }

}

/**
 * minApi 大于19才调用方法
 */
fun aboveKITKAT(action: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        action()
    }
}

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

class BezierEvaluator(private val controlPoint: PointF) : TypeEvaluator<PointF> {

    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {

        val temp = 1 - fraction
        return PointF(
            temp * temp * startValue.x + 2 * fraction * temp * controlPoint.x + fraction * fraction * endValue.x,
            temp * temp * startValue.y + 2 * fraction * temp * controlPoint.y + fraction * fraction * endValue.y
        )

    }

}
