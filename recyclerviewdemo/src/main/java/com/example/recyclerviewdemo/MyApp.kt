package com.example.recyclerviewdemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-9-21 下午9:35
 */
class MyApp  : Application () {
    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }


}