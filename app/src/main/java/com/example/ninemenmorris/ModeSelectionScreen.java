package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModeSelectionScreen extends AppCompatActivity {
    public int gameMode;
    public int gameDifficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection_screen);
    }

    public void updateGameModePvp(View myView){
        gameMode=1;
    }
    public void updateGameModePvc(View myView){
        gameMode=2;
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


}