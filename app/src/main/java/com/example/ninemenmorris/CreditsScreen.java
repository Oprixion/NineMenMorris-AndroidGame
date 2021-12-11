package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreditsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);
    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }

}
