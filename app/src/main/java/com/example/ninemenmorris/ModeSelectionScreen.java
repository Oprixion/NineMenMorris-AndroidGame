package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * When ever a button is chosen it will be disabled, the disabled state should be change into
 * something more clear.
 */
public class ModeSelectionScreen extends AppCompatActivity {
    public int gameMode=2;
    public int gameDifficulty=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection_screen);
        setDefaultGame();

        //Ensures that multiple counts of audio doesn't occur
        MusicService.musicInitialize = 2;

        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        if (MusicService.getMuteStatus() == "muted"){
            muted.setVisibility(View.VISIBLE);
            unmuted.setVisibility(View.GONE);
            muted.bringToFront();
        }
        else if (MusicService.getMuteStatus() == "unmuted"){
            unmuted.setVisibility(View.VISIBLE);
            muted.setVisibility(View.GONE);
            unmuted.bringToFront();
        }

    }

    public void muteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        muted.setVisibility(View.VISIBLE);
        unmuted.setVisibility(View.GONE);
        muted.bringToFront();
        MusicService.setMuteStatus("muted");

    }

    public void unMuteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        muted.setVisibility(View.GONE);
        unmuted.setVisibility(View.VISIBLE);
        unmuted.bringToFront();
        MusicService.setMuteStatus("unmuted");


    }


    public void updateGameModePvp(View myView){
        disableTheDifficulties();
        gameMode=1;

    }

    public void updateGameModePvc(View myView){
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

        setSelectedEasy(true);
        setSelectedMedium(false);
        setSelectedHard(false);

        gameDifficulty=1;
    }

    public void updateGameMedium(View myView){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);

        easyButton.setEnabled(true);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(true);

        setSelectedEasy(false);
        setSelectedMedium(true);
        setSelectedHard(false);

        gameDifficulty=2;
    }

    public void updateGameHard(View myView){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);

        easyButton.setEnabled(true);
        mediumButton.setEnabled(true);
        hardButton.setEnabled(false);

        setSelectedEasy(false);
        setSelectedMedium(false);
        setSelectedHard(true);

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
        Button pvpButton = (Button)findViewById(R.id.pvpButton);
        Button pvcButton = (Button)findViewById(R.id.pvcButton);
        ImageView redPlayer = (ImageView)findViewById(R.id.redPortrait);

        pvcButton.setEnabled(true);
        pvpButton.setEnabled(false);

        easyButton.setEnabled(false);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(false);

        setDifficultyVisability(false);
        setSelectedPvc(false);
        setSelectedPvp(true);
        redPlayer.setImageResource(R.drawable.portrait_red_human);
    }

    private void setDefaultGame(){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        Button pvpButton = (Button)findViewById(R.id.pvpButton);
        Button pvcButton = (Button)findViewById(R.id.pvcButton);
        ImageView redPlayer = (ImageView)findViewById(R.id.redPortrait);

        pvcButton.setEnabled(false);
        pvpButton.setEnabled(true);

        easyButton.setEnabled(true);
        mediumButton.setEnabled(false);
        hardButton.setEnabled(true);

        setDifficultyVisability(true);
        setSelectedPvc(true);
        setSelectedPvp(false);
        setSelectedEasy(false);
        setSelectedMedium(true);
        setSelectedHard(false);
        redPlayer.setImageResource(R.drawable.portrait_red_alien);

    }

    public void quitModeSelect(View myView){
        Intent toStartScreen = new Intent(this, StartScreen.class);
        startActivity(toStartScreen);
        this.finish();
    }

    ///////////////
    //  VISUALS  //
    ///////////////

    /*
     * PVP AND PVC visual toggle functions
     * true to highlight
     */
    public void setSelectedPvp(boolean status){
        Button pvpButton = (Button) findViewById(R.id.pvpButton);

        if(status){
            pvpButton.setBackgroundResource(R.drawable.button_pvp_on);
        }
        else{
            pvpButton.setBackgroundResource(R.drawable.button_pvp_off);
        }
    }
    public void setSelectedPvc(boolean status) {
        Button pvcButton = (Button) findViewById(R.id.pvcButton);

        if(status){
            pvcButton.setBackgroundResource(R.drawable.button_pvc_on);
        }
        else{
            pvcButton.setBackgroundResource(R.drawable.button_pvc_off);
        }
    }

    /*
     * Difficulty visual toggle functions
     * true to highlight
     */
    public void setSelectedEasy(boolean status){
        Button easyButton = (Button) findViewById(R.id.easyButton);

        if(status){
            easyButton.setBackgroundResource(R.drawable.button_easy_on);
        }
        else{
            easyButton.setBackgroundResource(R.drawable.button_easy_off);
        }
    }
    public void setSelectedMedium(boolean status){
        Button mediumButton = (Button) findViewById(R.id.mediumButton);

        if(status){
            mediumButton.setBackgroundResource(R.drawable.button_med_on);
        }
        else{
            mediumButton.setBackgroundResource(R.drawable.button_med_off);
        }
    }
    public void setSelectedHard(boolean status){
        Button hardButton = (Button) findViewById(R.id.hardButton);

        if(status){
            hardButton.setBackgroundResource(R.drawable.button_hard_on);
        }
        else{
            hardButton.setBackgroundResource(R.drawable.button_hard_off);
        }
    }
    public void setDifficultyVisability(boolean status){
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button mediumButton = (Button)findViewById(R.id.mediumButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        if (status) {
            easyButton.setAlpha(1);
            mediumButton.setAlpha(1);
            hardButton.setAlpha(1);
        }
        else{
            easyButton.setAlpha(0);
            mediumButton.setAlpha(0);
            hardButton.setAlpha(0);
        }

    }
}