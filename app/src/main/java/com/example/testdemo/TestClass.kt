package com.example.testdemo

import android.util.Log

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-06-06 11:54
 */
class TestClass(name:String,age:Int) {
    constructor(name: String) : this(name,23) {
        Log.e("TestClass","name is $name")
    }


    init {

        Log.e("TestClass","init")
    }

    init{
        Log.e("TestClass","init2")
    }
}