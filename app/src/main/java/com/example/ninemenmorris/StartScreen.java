package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        /**
         * onCreate method to initiate audio at the start of the app
         * James Mendoza
         */

        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        int audioCheck = 1;
        //Starts the audio when variable musicInitialize from the MusicService class is equal to 1
        if(audioCheck == MusicService.musicInitialize){
            MusicService.audioMusic = MediaPlayer.create(this,R.raw.haunt);
            MusicService.startAudio();
        }//if
        else{
            //do nothing
        }//else

        //Keeps track if the music is muted or unmuted throughout most activities
        //and adjusts the drawable mute/unmute button accordingly.
        //Is in the SettingScreen, ModeSelectionScreen, PvpGameScreen, and PvcGameScreen.
        if (MusicService.getMuteStatus() == "muted"){
            muted.setVisibility(View.VISIBLE);
            unmuted.setVisibility(View.GONE);
            muted.bringToFront();
        }//if
        else if (MusicService.getMuteStatus() == "unmuted"){
            unmuted.setVisibility(View.VISIBLE);
            muted.setVisibility(View.GONE);
            unmuted.bringToFront();
        }//if
    }//onCreate

    public void muteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        muted.setVisibility(View.VISIBLE);
        unmuted.setVisibility(View.GONE);
        muted.bringToFront();
        MusicService.setMuteStatus("muted");
    }//muteSound

    public void unMuteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        muted.setVisibility(View.GONE);
        unmuted.setVisibility(View.VISIBLE);
        unmuted.bringToFront();
        MusicService.setMuteStatus("unmuted");
    }//unMuteSound

    /**
     * onClick methods to navigate through the starting screen
     * @param myView
     */
    public void openModeSelection(View myView){
        Intent toModeSelect = new Intent(this, ModeSelectionScreen.class);
        startActivity(toModeSelect);
    }//openModeSelection
    public void openCreditsScreen(View myView){
        Intent toCreditsScreen = new Intent(this, CreditsScreen.class);
        startActivity(toCreditsScreen);
    }//openCreditsScreen
    public void openSettingsScreen(View myView){
        Intent toSettingScreen = new Intent(this, SettingScreen.class);
        startActivity(toSettingScreen);
    }//openSettingsScreen
    public void openHelpScreen(View myView){
        Intent toHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(toHelpScreen);
    }//openHelpScreen


}//StartScreen