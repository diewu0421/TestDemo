package com.example.fueldemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-09-11 17:11
 */
public class DBConvert {

    @BindingConversion
    public static String setText(String text) {
        Log.e("DBConvert", "setText: ");
        return text + "zenglwniha";
    }

    @BindingConversion
    public static Drawable setDrawable(String text) {
//        if (text.equals("red")) {
//            return new ColorDrawable(Color.RED);
//        }

        Log.e("DBConvert", "setDrawable: text =" + text);
//        if (text.contains("#")) {
            return new ColorDrawable(Color.parseColor(text));
//        }
//        return new ColorDrawable(Color.YELLOW);
    }

    @BindingAdapter({"stroke", "background", "radius"})
    public static void setShape(View view, int stroke, int background, int radius) {
//        view.setBackground(new ShapeDrawable().);
        Log.e("DBConvert", "setShape: ");
    }
}
