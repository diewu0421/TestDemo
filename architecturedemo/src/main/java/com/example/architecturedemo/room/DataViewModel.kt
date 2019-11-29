package com.example.architecturedemo.room

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-07-18 16:20
 */
class DataViewModel() : ViewModel() {

    internal val listData by lazy {
        ListDataLiveData().apply {
            value = "Hello"
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("DataViewModel","onCleared")
    }

}

class ListDataLiveData : MutableLiveData<String>(){

    override fun onActive() {
        super.onActive()
        Log.e("ListDataLiveData","onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.e("ListDataLiveData","onInactive")
    }
}