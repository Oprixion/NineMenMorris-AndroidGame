package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class StartScreen extends AppCompatActivity {
    public static MediaPlayer haunt;
    private String onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        onOff = "On";

        Button muteButton = (Button) findViewById(R.id.muteButton);
        haunt = MediaPlayer.create(StartScreen.this,R.raw.haunt);
        haunt.setLooping(true);
    }


    public void toggleMute(View myView){
        Button muteButton = (Button) myView;
        muteButton.setText(onOff);
        if(onOff.equals("On")) {
            haunt.start();
            onOff = "Off";
        }
        else if(onOff.equals("Off")){
            haunt.pause();
            onOff = "On";
        }
    }

    public void openModeSelection(View myView){
        Intent toModeSelect = new Intent(this, ModeSelectionScreen.class);
        haunt.release();
        haunt = null;
        toModeSelect.putExtra("myInfo", onOff);
        startActivity(toModeSelect);
    }
    public void openCreditsScreen(View myView){
        Intent toCreditsScreen = new Intent(this, CreditsScreen.class);
        haunt.release();
        haunt = null;
        toCreditsScreen.putExtra("myInfo", onOff);
        startActivity(toCreditsScreen);
    }
    public void openSettingsScreen(View myView){
        Intent toSettingScreen = new Intent(this, SettingScreen.class);
        haunt.release();
        haunt = null;
        toSettingScreen.putExtra("myInfo", onOff);
        startActivity(toSettingScreen);
    }
    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        haunt.release();
        haunt = null;
        toHelpScreen.putExtra("myInfo", onOff);
        startActivity(toHelpScreen);
    }
}