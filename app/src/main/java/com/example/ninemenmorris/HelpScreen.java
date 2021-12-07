package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpScreen extends AppCompatActivity {

    public static MediaPlayer haunt;
    private String onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        Bundle onOffValue = getIntent().getExtras();
        onOff = onOffValue.getString("myInfo");

        Button muteButton = (Button) findViewById(R.id.muteButton);
        haunt = MediaPlayer.create(HelpScreen.this,R.raw.haunt);
        haunt.setLooping(true);
    }
    public void toggleMute(View myView){
        Button muteButton = (Button) myView;
        muteButton.setText(onOff);
        if(onOff.equals("On")) {
            haunt.start();
            onOff = "Off";
        }
        else if(onOff.equals("Off") && haunt.isPlaying()){
            haunt.pause();
            onOff = "On";
        }
        else if (onOff.equals("Off")){
            onOff = "On";
        }
    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        haunt.release();
        haunt = null;

        startActivity(goHome);
        this.finish();
    }
}