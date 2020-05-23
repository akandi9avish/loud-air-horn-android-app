package com.example.loudairhorn;
import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player,player1;
    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-9196374672206434~1216887712");

        mAdview = (AdView)findViewById(R.id.adView);
        AdRequest  adRequest = new  AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

    }

    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer1() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }


    public void play1(View v) {
        if (player1 == null) {
            player1 = MediaPlayer.create(this, R.raw.song1);
            player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player1.start();
    }

    public void pause1(View v) {
        if (player1 != null) {
            player1.pause();
        }
    }

    public void stop1(View v) {
        stopPlayer1();
    }

    private void stopPlayer() {
        if (player1 != null) {
            player1.release();
            player1 = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer1();
    }
}
