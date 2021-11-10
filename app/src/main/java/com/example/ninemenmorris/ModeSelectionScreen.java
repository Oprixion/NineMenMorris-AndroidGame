package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeSelectionScreen extends AppCompatActivity {
    public int gameMode=2;
    public int gameDifficulty=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection_screen);
        setDefaultGame();
    }


    public void updateGameModePvp(View myView){
        Button pvpButton = (Button)findViewById(R.id.pvpButton);
        Button pvcButton = (Button)findViewById(R.id.pvcButton);
        pvpButton.setEnabled(false);
        pvcButton.setEnabled(true);
        gameMode=1;
        disableTheDifficulties();
    }
    public void updateGameModePvc(View myView){

        enableTheDifficulties();
        setDefaultGame();

        gameMode=2;

    }
    public void updateGameDifEasy(View myView){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        easyButton.setEnabled(false);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(true);
        gameDifficulty=1;
    }
    public void updateGameMedium(View myView){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        easyButton.setEnabled(true);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(true);
        gameDifficulty=2;
    }
    public void updateGameHard(View myView){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        easyButton.setEnabled(true);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(false);
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
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        easyButton.setEnabled(false);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(false);
    }
    private void enableTheDifficulties(){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        easyButton.setEnabled(true);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(true);
    }
    private void setDefaultGame(){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        Button pvpButton = (Button)findViewById(R.id.pvpButton);
        Button pvcButton = (Button)findViewById(R.id.pvcButton);
        pvcButton.setEnabled(false);
        mediumButton.setEnabled(false);
        pvpButton.setEnabled(true);
        easyButton.setEnabled(true);
        hardButton.setEnabled(true);
    }
}