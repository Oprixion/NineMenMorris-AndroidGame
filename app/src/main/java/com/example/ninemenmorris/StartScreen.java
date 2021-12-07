package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;


public class StartScreen extends AppCompatActivity {
    MediaPlayer among;
    private String onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        onOff = "Off";

        Button muteButton = (Button) findViewById(R.id.muteButton);
        among = MediaPlayer.create(StartScreen.this,R.raw.among);
    }

    public void toggleMute(View myView){
        Button muteButton = (Button) myView;
        muteButton.setText(onOff);

        if(onOff.equals("Off")){
            onOff = "On";
            muteButton.setText(onOff);
            among.start();
        }
        else{
            onOff = "Off";
            muteButton.setText(onOff);
            among.pause();
        }
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
        toSettingScreen.putExtra("myInfo", onOff);
        startActivity(toSettingScreen);
    }
    public void toHelpScreen(View myView){
        Intent goToHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(goToHelpScreen);
    }
}