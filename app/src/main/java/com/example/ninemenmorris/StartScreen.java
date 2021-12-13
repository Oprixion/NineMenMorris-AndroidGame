package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;


import android.widget.Button;
import android.widget.ImageButton;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        int audioCheck = 1;
        if(audioCheck == MusicService.musicInitialize){
            MusicService.audioMusic = MediaPlayer.create(this,R.raw.haunt);
            MusicService.startAudio();
        }
        else{
            //do nothing
        }
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

    public void openModeSelection(View myView){
        Intent toModeSelect = new Intent(this, ModeSelectionScreen.class);
        startActivity(toModeSelect);
    }
    public void openCreditsScreen(View myView){
        Intent toCreditsScreen = new Intent(this, CreditsScreen.class);
        startActivity(toCreditsScreen);
    }
    public void openSettingsScreen(View myView){
        Intent toSettingScreen = new Intent(this, SettingScreen.class);
        startActivity(toSettingScreen);
    }
    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(toHelpScreen);
    }


}