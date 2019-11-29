package com.example.gsydemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import okio.Buffer;
import okio.Okio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Class<StandardGSYVideoPlayer> standardGSYVideoPlayerClass = StandardGSYVideoPlayer.class;

        Class<Buffer> bufferClass = Buffer.class;
    }
}
