package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeSelectionScreen extends AppCompatActivity {
    public int gameMode=2;
    public int gameDifficulty=2;
    Button pvpButton = (Button)findViewById(R.id.pvpButton);
    Button pvcButton = (Button)findViewById(R.id.pvcButton);
    Button easyButton = (Button)findViewById(R.id.easyButton);
    Button mediumButton = (Button)findViewById(R.id.mediumButton);
    Button hardButton = (Button)findViewById(R.id.hardButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection_screen);
        setDefaultGame();
    }

    public void updateGameModePvp(View myView){
        gameMode=1;
        disableTheDifficulties();
    }
    public void updateGameModePvc(View myView){
        gameMode=2;
        pvpButton.setEnabled(false);
        enableTheDifficulties();
    }
    public void updateGameDifEasy(View myView){
        gameDifficulty=1;
    }
    public void updateGameMedium(View myView){
        gameDifficulty=2;
    }
    public void updateGameHard(View myView){
        gameDifficulty=3;
    }
    public void startGame(View myView){
        Intent toGameScreen;
        if (gameMode==1){
            toGameScreen = new Intent(this, PvpGameScreen.class);
        }else {
            toGameScreen = new Intent(this, PvcGameScreen.class);
        }
        startActivity(toGameScreen);
    }
    private void disableTheDifficulties(){
        easyButton.setEnabled(false);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(false);
    }
    private void enableTheDifficulties(){
        easyButton.setEnabled(true);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(true);
    }
    private void setDefaultGame(){
        pvcButton.setEnabled(true);
        mediumButton.setEnabled(true);
        pvpButton.setEnabled(false);
        easyButton.setEnabled(false);
        hardButton.setEnabled(false);
    }
}