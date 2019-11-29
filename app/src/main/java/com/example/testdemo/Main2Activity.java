package com.example.testdemo;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.widget.PopupWindowCompat;
import com.bumptech.glide.load.engine.Resource;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {

                TextView textView = new TextView(Main2Activity.this);
                textView.setBackgroundColor(Color.RED);
                textView.setText("button");
                PopupWindow popupWindow = new PopupWindow(textView);
//                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(Resources.getSystem().getDisplayMetrics().widthPixels);
                popupWindow.setHeight(200);
                popupWindow.setFocusable(false);
                popupWindow.setOutsideTouchable(false);
                popupWindow.setBackgroundDrawable(null);
                View root = (View) findViewById(R.id.root);
                root.setBackgroundColor(Color.BLACK);

                PopupWindowCompat.showAsDropDown(popupWindow, root, 0, -200, Gravity.BOTTOM);
                findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                popupWindow.showAsDropDown(root, Gravity.BOTTOM, 0, 0);
//                popupWindow.showAtLocation(root, Gravity.BOTTOM, 0, 0);
                    }
                });

                SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
                int heightPixels = Resources.getSystem().getDisplayMetrics().heightPixels;
                int widthPixels = Resources.getSystem().getDisplayMetrics().widthPixels;
                seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Log.e("Main2Activity", "onProgressChanged: progress = " + progress);

                        popupWindow.update(0, (int) (progress * 1.0f * heightPixels / 100), widthPixels, 100);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
//        Handler handler = new Handler();
//
//        new Thread(() -> {
//            long sum = 0;
//            long start = System.currentTimeMillis();
//
//            for (int i = 0; i < 200000; i++) {
//                for (int j = 0; j < 200000; j++) {
//
//                    sum += i * j;
//
//                }
//            }
//
//            long finalSum = sum;
//            runOnUiThread(() -> ((TextView) findViewById(R.id.tv)).setText("sum = " + finalSum + "  time = " + (System.currentTimeMillis() - start)));
//        }).start();

    }
}
