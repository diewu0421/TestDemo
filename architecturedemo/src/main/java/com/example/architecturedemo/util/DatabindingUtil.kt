package com.example.architecturedemo.util

import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.architecturedemo.view.MyView

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-08-09 18:56
 */
object DatabindingUtil {
    @JvmStatic
    @BindingAdapter(value = ["age"])
    fun setAge(myView: MyView, age: Int) {
        Toast.makeText(myView.context,"age = $age ",Toast.LENGTH_SHORT).show()
    }
}
