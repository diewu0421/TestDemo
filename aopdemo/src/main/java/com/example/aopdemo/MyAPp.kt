package com.example.aopdemo

import android.app.Application
import android.util.Log
import com.xuexiang.xaop.XAOP

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-14 00:04
 */
class MyApp() : Application() {

    override fun onCreate() {
        super.onCreate()

        XAOP.init(this)
        XAOP.debug(true)
        XAOP.setIThrowableHandler { flag, throwable ->
            Log.e("MyApp","error ${throwable}")
        }
    }
}

