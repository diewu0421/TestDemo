package com.example.architecturedemo.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-07-02 17:54
 */
class WeatherResult : ViewModel() {


    val weatherResult by lazy {
        MutableLiveData<String>().apply {
            value = "Hello World"
        }
    }

}