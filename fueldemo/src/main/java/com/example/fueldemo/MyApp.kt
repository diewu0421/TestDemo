package com.example.fueldemo

import android.app.Application
import android.util.Log

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-12 20:01
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Cxt.mContext = this
        Log.e("MyApp","onCreate ")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        
        Log.e("MyApp","onLowMemory ")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e("MyApp","onTrimMemory ")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.e("MyApp","onTerminate ")
    }
}