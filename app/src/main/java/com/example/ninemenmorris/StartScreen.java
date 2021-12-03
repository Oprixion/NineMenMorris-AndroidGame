package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button playGame = (Button) findViewById(R.id.playButton);
        Button creditsScreen = (Button) findViewById(R.id.creditsButton);
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
}