package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class RestartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart_screen);
        //NEED A VARIABLE BUNDLED FROM PREVIOUS ACTIVITYS FOR THIS
        boolean redWon = false;
        if(redWon){
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
}