package com.example.architecturedemo

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.architecturedemo.entity.AppDataBase

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-12 20:52
 */
class MyApp : Application() {
    val appDataBase by lazy {
        Room.databaseBuilder(this.applicationContext,AppDataBase::class.java,"login_info")
            .addCallback(object : RoomDatabase.Callback() {

                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.e("MyApp","onCreate $db")
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    Log.e("MyApp","onOpen $db")
                }

            })
            .build()
    }

    override fun onCreate() {
        super.onCreate()

    }


}