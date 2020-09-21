package com.example.aopdemo.aspectj

import android.util.Log
import android.widget.Toast
import com.example.aopdemo.MainActivity
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-08-14 00:06
 */
@Aspect
class TestAspectj {
    @Pointcut("execution(* com.example.aopdemo.BaseNetTools.getUrl(..))")
    fun getUrl() {

    }

    @Around("getUrl()")
    @Throws(Throwable::class)
    fun beforeGetUrl(point: ProceedingJoinPoint): Any {
        Log.e("TestAspectj", "beforeGetUrl: ")
        val args = point.args
        args[0] = args[0].toString() + "zenglw"
        return point.proceed(args)
    }

    @AfterThrowing(value = "getUrl()", throwing = "throwable")
    fun exception(throwable: Throwable?) {
        Log.e("TestAspectj", "exception: ")
    }


    @Pointcut("execution(* android.app.Activity.onCreate(..))")
    fun onCreate() {
    }

    @Around("onCreate()")
    fun aroundOnCreate(joinPoint: ProceedingJoinPoint) {
        Log.e("TestAspectj","aroundOnCreate ")
        joinPoint.proceed()
    }

    @Pointcut("execution(* com.example.aopdemo.TestKotlinClass.test(..))")
    fun kotlinTest() {
    }

    @Around("kotlinTest()")
    fun aroundKotlinTest(joinPoint: ProceedingJoinPoint) {
        Log.e("TestAspectj","aroundKotlinTest $this")
        joinPoint.proceed()
    }

    @Pointcut("execution(* com.example.aopdemo.MainActivity.onClick(..))")
    fun onClick() {
    }

    @Around("onClick()")
    fun aroundOnClick(joinPoint: ProceedingJoinPoint) {
        Log.e("TestAspectj","aroundOnClick $this")
        joinPoint.proceed()
    }

    @Pointcut("execution(* android.content.res.Resources.getDisplayMetrics(..))")
    fun getDisplay() {
    }

    /**
     * 这里用Around就会有问题
     */
    @After("getDisplay()")
    fun aroundGetDisplay(joinPoint: JoinPoint) {
        Log.e("TestAspectj","aroundGetDisplay ")
//        joinPoint.proceed()
        val thisObj = joinPoint.`this`
        if (thisObj is MainActivity) {
            Toast.makeText(thisObj, "阿斯顿发收款", Toast.LENGTH_LONG).show()
        }
    }

    @Pointcut("execution(* com.example.aopdemo.MainActivity..innerMethod(..))")
    fun innerMethod() {}

    @Around("innerMethod()")
    fun aroundInnerMethod(point: ProceedingJoinPoint) {
        Log.e("TestAspectj","aroundInnerMethod $this")
        kotlin.runCatching {
            point.proceed()
        }.onFailure {
            Log.e("TestAspectj","aroundInnerMethod 异常了")
        }
    }

    @Pointcut("call(* java.util.LinkedList.get(..))")
    fun linkedList() {}

    @Around("linkedList()")
    fun aroundLinkedList(joinPoint: ProceedingJoinPoint) : Any? {
        Log.e("TestAspectj","1111111111111 aroundLinkedList $this")
        var result:Any? = null
        kotlin.runCatching {

            result = joinPoint.proceed()

        }.onFailure {
            result = "我是错误的信息"
        }
        return result;
    }

//    @Pointcut("")

//
//    @Pointcut("execution(* com.example.aopdemo.BaseNetTools.getUrl(..))")
//    fun testst() {}
//
//    @Around("testst()")
//    fun getDisplayMetricsBefore(joinPoint: ProceedingJoinPoint) {
//        Log.e("TestAspectj", "getDisplayMetricsBefore: " + joinPoint.target)
//    }

//    companion object {
//        var INSTANCE: TestAspectj? = null
//
//        @JvmStatic
//        fun aspectOf(): TestAspectj? {
//            if (INSTANCE == null) {
//                INSTANCE = TestAspectj()
//            }
//            return INSTANCE
//        }
//    }
}