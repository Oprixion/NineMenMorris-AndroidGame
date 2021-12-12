package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RestartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart_screen);
        Bundle winnerInfo = getIntent().getExtras();
        String theWinner = winnerInfo.getString("Winner is");
        //NEED A VARIABLE BUNDLED FROM PREVIOUS ACTIVITYS FOR THIS
        boolean redWon = false;
        boolean isPvp = true;
        int difficulty = 0;
        if(theWinner.equals("P1 ")){
            setRedWinnerHuman(true);
        }
    }

    /*
     * Changes the winnerName to red and changes winnerPortrait red based on gamemode
     * true - PVP gamemode "Changes portrait to human"
     * false - PVE gamemode "Changes portrait to alien"
     */
    public void setRedWinnerHuman(boolean isPvp){
        ImageView winnerName = (ImageView) findViewById(R.id.winnerName);
        ImageView winnerPortrait = (ImageView) findViewById(R.id.winnerPortrait);

        winnerName.setImageResource(R.drawable.indicator_red);

        //Change portrait depending on mode
        if(isPvp){
            winnerPortrait.setImageResource(R.drawable.portrait_red_human_happy);
        }
        else{
            winnerPortrait.setImageResource(R.drawable.portrait_red_alien_happy);
        }
    }//redIsWinner

    public void goToMenu(View MyView){
        Intent toMenu = new Intent(this, StartScreen.class);
        startActivity(toMenu);
        this.finish();
    }//goToMenu
    public void goToPvpGame(View MyView){
        Intent toPvp = new Intent(this, PvpGameScreen.class);
        startActivity(toPvp);
        this.finish();
    }//goToGame
}