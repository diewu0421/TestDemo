package com.example.gsydemo;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import okio.Buffer;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-08-07 16:09
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Bugly.init(this, "3eb40d61c3", false);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        // 安装tinker
        Beta.installTinker();
    }
}
