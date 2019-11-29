package com.example.architecturedemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-09 17:26
 */
@BindingMethods(BindingMethod(type = DatabindingTestView::class, attribute = "bgColor", method = "setColor"))

class DatabindingTestView @JvmOverloads constructor(context: Context, attrSets: AttributeSet? = null, defStyleAttrs: Int = 0)
    : View(context, attrSets, defStyleAttrs) {
    private var bgColor = "nihao"

    init {

    }

    fun setColor(color:String) {
        bgColor = color
    }

    fun printBgColor() {
        Toast.makeText(context, bgColor, Toast.LENGTH_SHORT).show()
    }


}
