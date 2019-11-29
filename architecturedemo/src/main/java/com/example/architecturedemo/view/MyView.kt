package com.example.architecturedemo.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.ObservableField

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-08-09 17:36
 */
//@BindingMethods(BindingMethod(type = TextView::class, attribute = "name", method = "showZhangPhilToast"))
@BindingMethods(
    value = [BindingMethod(


        type = MyView::class,
        attribute = "name",
        method = "showZhangPhilToast"
    )]
)

class MyView(context: Context, attrs: AttributeSet?) : TextView(context, attrs) {
    var name = "zlw"
        private set

    fun showZhangPhilToast(s: ObservableField<String>) {
        if (TextUtils.isEmpty(s.get())) {
            return
        }

        Toast.makeText(context, s.get(), Toast.LENGTH_LONG).show()
    }
}

