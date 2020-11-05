package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import io.reactivex.Flowable
import io.reactivex.Observable

//import io.reactivex.Observable
//import io.reactivex.functions.Consumer
//import io.reactivex.subjects.BehaviorSubject

class MainActivity : AppCompatActivity() {

//    private val mSubject by lazy { BehaviorSubject.create<ActivityEvent>() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Observable.just(1)
//            .takeUntil(mSubject.first)

//        mSubject
//
//            .subscribe(Consumer {
//                Log.e("MainActivity","it = ${it.name}")
//            })


        Flowable.just(1,2,3)
            .take(2)
            .map {
                Log.e("MainActivity","onCreate map $it")
                it
            }
            .subscribe {
                Log.e("MainActivity","onCreate $it")
            }
        
    }
}

enum class ActivityEvent(
){
    onCreate,
    onStart,
    onResume,
    onPause,
    onStop,
    onDestory,
}
