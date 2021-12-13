package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

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
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);

        startActivity(goHome);
        this.finish();
    }
}