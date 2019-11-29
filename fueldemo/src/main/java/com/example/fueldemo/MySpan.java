package com.example.fueldemo;

import android.graphics.Paint;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;

import androidx.annotation.NonNull;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-09-21 16:43
 */
public class MySpan extends AbsoluteSizeSpan {

    public MySpan(int size) {
        super(size);
    }

    public MySpan(int size, boolean dip) {
        super(size, dip);
    }

    public MySpan(@NonNull Parcel src) {
        super(src);
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        Paint.FontMetrics fontMetrics = ds.getFontMetrics();
        fontMetrics.bottom -= 10;
        super.updateDrawState(ds);
    }

    @Override
    public void updateMeasureState(@NonNull TextPaint ds) {
        Paint.FontMetrics fontMetrics = ds.getFontMetrics();
        fontMetrics.bottom -= 10;
        super.updateMeasureState(ds);
    }
}
