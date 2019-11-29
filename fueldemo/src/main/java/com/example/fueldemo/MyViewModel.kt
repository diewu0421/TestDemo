package com.example.fueldemo

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-09-12 09:58
 */
class MyViewModel : ViewModel() {


    fun onClick(view: View) {

        when (view.id) {
            R.id.button -> {
                Log.e("MyViewModel","onClick ")
            }
        }

    }
}