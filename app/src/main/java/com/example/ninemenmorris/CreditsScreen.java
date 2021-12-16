package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CreditsScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);

        DisplayMetrics creditsPopup = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(creditsPopup);

        int width = creditsPopup.widthPixels;
        int height = creditsPopup.heightPixels;

        getWindow().setLayout((int)(width*.93),(int)(height*.93));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);

        MusicService.musicInitialize = 2;
    }

    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }

}
