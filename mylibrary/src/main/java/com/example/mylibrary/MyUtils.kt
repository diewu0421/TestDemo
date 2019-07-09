package com.example.mylibrary

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-07-08 23:32
 */
class MyUtils {
    companion object {

        @JvmStatic
        fun printObject(any: Any?) {
            any?.let{
                //修复bug版本本
                println("fixed bug object = $any")
            }
        }
    }
}