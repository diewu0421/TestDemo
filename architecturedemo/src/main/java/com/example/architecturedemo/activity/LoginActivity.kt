package com.example.architecturedemo.activity

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.architecturedemo.R
import com.example.architecturedemo.activity.ui.login.LoginFragment
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, LoginFragment.newInstance())
//                .commitNow()
//        }

        test_local_tv.setOnClickListener {
            val heightPixels = resources.displayMetrics.heightPixels

            Log.e("LoginActivity","transy = y = ${test_local_tv.y} ${test_local_tv.translationY} ${test_local_tv.top}")
            test_local_tv.translationY  += heightPixels - test_local_tv.height / 2 - getStatusBarHeight(this@LoginActivity)  - (supportActionBar?.height ?: 0)
//            test_local_tv.y = (heightPixels - test_local_tv.height /2).toFloat()
//            test_local_tv.top = 200


            val rect = Rect()
            it.getGlobalVisibleRect(rect)
            Log.e("LoginActivity","transy = y = ${test_local_tv.y} ${test_local_tv.translationY} ${test_local_tv.top}")
            Log.e("LoginActivity","rect = $rect")
        }
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        /**
         * 获取状态栏的高度
         */
        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

    }

}
