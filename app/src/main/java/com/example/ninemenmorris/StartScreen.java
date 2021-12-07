package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class StartScreen extends AppCompatActivity {
    public static MediaPlayer disco;
    private String onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        onOff = "On";

        Button muteButton = (Button) findViewById(R.id.muteButton);
        disco = MediaPlayer.create(StartScreen.this,R.raw.disco);
        disco.setLooping(true);
    }


    public void toggleMute(View myView){
        Button muteButton = (Button) myView;
        muteButton.setText(onOff);
        if(onOff.equals("On")) {
            disco.start();
            onOff = "Off";
        }
        else if(onOff.equals("Off")){
            disco.pause();
            onOff = "On";
        }
    }

    public void openModeSelection(View myView){
        Intent toModeSelect = new Intent(this, ModeSelectionScreen.class);
        disco.release();
        disco = null;
        toModeSelect.putExtra("myInfo", onOff);
        startActivity(toModeSelect);
    }
    public void openCreditsScreen(View myView){
        Intent toCreditsScreen = new Intent(this, CreditsScreen.class);
        disco.release();
        disco = null;
        toCreditsScreen.putExtra("myInfo", onOff);
        startActivity(toCreditsScreen);
    }
    public void openSettingsScreen(View myView){
        Intent toSettingScreen = new Intent(this, SettingScreen.class);
        disco.release();
        disco = null;
        toSettingScreen.putExtra("myInfo", onOff);
        startActivity(toSettingScreen);
    }
    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        disco.release();
        disco = null;
        toHelpScreen.putExtra("myInfo", onOff);
        startActivity(toHelpScreen);
    }
}