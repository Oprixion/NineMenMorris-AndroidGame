package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.SeekBar;

public class SettingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        DisplayMetrics settingsPopup = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(settingsPopup);

        int width = settingsPopup.widthPixels;
        int height = settingsPopup.heightPixels;

        getWindow().setLayout((int)(width*.93),(int)(height*.93));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);


        MusicService.musicInitialize = 2;

        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        if (MusicService.getMuteStatus() == "muted"){
            muted.setVisibility(View.VISIBLE);
            unmuted.setVisibility(View.GONE);
            muted.bringToFront();
        }
        else if (MusicService.getMuteStatus() == "unmuted"){
            unmuted.setVisibility(View.VISIBLE);
            muted.setVisibility(View.GONE);
            unmuted.bringToFront();
        }

        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volControl = (SeekBar)findViewById(R.id.adjustVolume);
        volControl.setMax(maxVolume);
        volControl.setProgress(curVolume);
        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });
    }

    public void muteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        muted.setVisibility(View.VISIBLE);

        Button unmuted = (Button) findViewById(R.id.unmuted);
        unmuted.setVisibility(View.GONE);

        muted.bringToFront();

        MusicService.setMuteStatus("muted");

    }

    public void unMuteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        muted.setVisibility(View.GONE);

        Button unmuted = (Button) findViewById(R.id.unmuted);
        unmuted.setVisibility(View.VISIBLE);

        unmuted.bringToFront();

        MusicService.setMuteStatus("unmuted");


    }

    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(toHelpScreen);
    }

}