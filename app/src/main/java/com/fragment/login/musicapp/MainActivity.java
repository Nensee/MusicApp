package com.fragment.login.musicapp;

import android.media.MediaPlayer;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb=(ToggleButton)findViewById(R.id.tglb);

        mp = MediaPlayer.create(MainActivity.this, R.raw.mujko_teri_jarurat_hai);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb.isChecked()) {
                    mp.start();
                } else {
                    mp.stop();
                    try {
                        mp.prepare();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    mp.seekTo(0);
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mp !=null) {
            mp.release();
            mp = null;
        }
    }
}
