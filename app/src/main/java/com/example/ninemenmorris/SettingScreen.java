package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingScreen extends AppCompatActivity {
    MediaPlayer among;
    private String onOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        Bundle onOffValue = getIntent().getExtras();
        onOff = onOffValue.getString("myInfo");


        Button muteButton = (Button) findViewById(R.id.muteButton);
        among = MediaPlayer.create(SettingScreen.this,R.raw.among);
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



    public void toHelpScreen(View myView){
        Intent goToHelpScreen = new Intent(this, HelpScreen.class);
        startActivity(goToHelpScreen);
    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }

}