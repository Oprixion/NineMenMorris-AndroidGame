package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class SettingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);
    }
    public void toHelpScreen(View myView){
        Intent goToHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(goToHelpScreen);
    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }
    public void toggleMute(View myView){
        //Visual
        ToggleButton muteButton = (ToggleButton) findViewById(R.id.settingsMuteButton);
        if(muteButton.isChecked()){
            muteButton.setBackgroundResource(R.drawable.button_mute_on);
        }
        else{
            muteButton.setBackgroundResource(R.drawable.button_mute_off);
        }
    }//toggleMute

}