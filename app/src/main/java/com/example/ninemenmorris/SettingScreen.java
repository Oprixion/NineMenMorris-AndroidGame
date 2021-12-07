package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class SettingScreen extends AppCompatActivity {
    MediaPlayer disco;
    private String onOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);
        Bundle onOffValue = getIntent().getExtras();
        onOff = onOffValue.getString("myInfo");

        Button muteButton = (Button) findViewById(R.id.muteButton);
        disco = MediaPlayer.create(this, R.raw.disco);
        disco.setLooping(true);

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

    public void toggleMute(View myView){
        Button muteButton = (Button) myView;
        muteButton.setText(onOff);
        if(onOff.equals("On")) {
            disco.start();
            onOff = "Off";
        }
        else if(onOff.equals("Off") && disco.isPlaying()){
            disco.pause();
            onOff = "On";
        }
        else if (onOff.equals("Off")){
            onOff = "On";
        }
    }

    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        disco.release();
        disco = null;
        toHelpScreen.putExtra("myInfo", onOff);
        startActivity(toHelpScreen);
    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        disco.release();
        disco = null;
        startActivity(goHome);
        this.finish();
    }

}