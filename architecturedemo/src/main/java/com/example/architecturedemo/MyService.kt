package com.example.architecturedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-07-05 18:06
 */
class MyService : Service () {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("MyService","myservice")
        return super.onStartCommand(intent, flags, startId)
    }
}
