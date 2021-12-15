package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        MediaPlayer alien= MediaPlayer.create(StartScreen.this,R.raw.alien);
        alien.start();
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
    public void toHelpScreen(View myView){
        Intent goToHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(goToHelpScreen);
    }
    public void toggleMute(View myView){
        ToggleButton muteButton = (ToggleButton) findViewById(R.id.muteButton);
        if(muteButton.isChecked()){
            muteButton.setBackgroundResource(R.drawable.button_mute_on);
        }
        else{
            muteButton.setBackgroundResource(R.drawable.button_mute_off);
        }

    }
}