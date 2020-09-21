package com.example.testdemo

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_practice.*
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class KotlinPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_practice)

        Log.e("KotlinPracticeActivity", "onCreate 100dp t0 px  = ${100.dp}")
        Log.e("KotlinPracticeActivity", "onCreate 100px t0 px  = ${100.px}")
        Log.e("KotlinPracticeActivity", "onCreate px to dp = ${px2dp(100f)}")
        Log.e("KotlinPracticeActivity", "onCreate dp to px = ${dp2px(100f)}")

        view.post {
            view.translationY = 3000f
            Log.e("KotlinPracticeActivity", "onCreate ${view.inScreen}")
        }

        view.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View?) {
                Log.e("KotlinPracticeActivity", "onViewDetachedFromWindow ")
                view.removeOnAttachStateChangeListener(this)
            }

            override fun onViewAttachedToWindow(v: View?) {
                Log.e("KotlinPracticeActivity", "onViewAttachedToWindow ")
            }
        })

        data class Person(var name: String, var age: Int)

        val persons = listOf(
            Person("Peter", 16),
            Person("Anna", 28),
            Person("Anna", 23),
            Person("Sonya", 39)
        )

        persons.print { "${it.name}_${it.age}" }.let { Log.v("test",it) }

        Person("Peter", 16).ofMap()?.print { it.toString() }.let { Log.e("test1111111111","$it") }
    }
}

val Int.dp: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
    }

val Int.px: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
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

/**
 * Value of px to value of dp.
 *
 * @param pxValue The value of px.
 * @return value of dp
 */
fun px2dp(pxValue: Float): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}


data class Person(val name: String, val age: Int, val school: String) {
    init {
        require(name.isNotEmpty()) { "name is not be empty!" }
    }
}

fun <T> Collection<T>.print(map: (T) -> String): String =
    StringBuilder("\n[").also { sb ->
        this.forEach { e -> sb.append("\n\t${map(e)}") }
        sb.append("\n")
    }.toString()
fun <K, V> Map<K, V?>.print(map: (V?) -> String): String =
    StringBuilder("\n{").also { sb ->
        this.iterator().forEach { entry ->
            sb.append("\n\t[${entry.key}] = ${map(entry.value)}")
        }
        sb.append("\n}")
    }.toString()

fun Any.ofMap() =
    this::class.takeIf { it.isData }
        ?.members?.filterIsInstance<KProperty<Any>>()
        ?.map { it.name to it.call(this) }
        ?.toMap()
