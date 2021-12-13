package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditsScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);

        MusicService.musicInitialize = 2;


    }

    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }

}
