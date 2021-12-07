package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditsScreen extends AppCompatActivity {
    public static MediaPlayer disco;
    private String onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);

        Bundle onOffValue = getIntent().getExtras();
        onOff = onOffValue.getString("myInfo");

        Button muteButton = (Button) findViewById(R.id.muteButton);
        disco = MediaPlayer.create(CreditsScreen.this,R.raw.disco);
        disco.setLooping(true);
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
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        disco.release();
        disco = null;
        startActivity(goHome);
        this.finish();
    }

}
