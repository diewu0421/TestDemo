package com.example.testdemo

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDex

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2020/6/29 3:00 PM
 */
class MyApp: Application() {
    private val mProcessLifeObserver by lazy { ProcessLifecycleObserver()}

    override fun onCreate() {
        super.onCreate()
        Log.e("MyApp","onCreate $this")

        ProcessLifecycleOwner.get().lifecycle.addObserver(mProcessLifeObserver)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}

class ProcessLifecycleObserver : DefaultLifecycleObserver {


    override fun onCreate(owner: LifecycleOwner) {
        Log.e("ProcessLifecycle","onCreate $owner")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.e("ProcessLifecycle","onPause $owner")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.e("ProcessLifecycle","onResume $owner")
    }
}