package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PvcGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
    }


    public void buttonDebug(View MyView){
        turnButtonBlue(MyView);
    }

    /*
    Below are all the basic functions that turn an input button into a specified visual
     */
    public void turnButtonWhite(View MyView){
        Button InputButton = (Button) MyView;
        InputButton.setBackgroundResource(R.drawable.token_none);
    }
    public void turnButtonBlue(View MyView){
        Button InputButton = (Button) MyView;
        InputButton.setBackgroundResource(R.drawable.token_blue);
    }
    public void turnButtonRed(View MyView){
        Button InputButton = (Button) MyView;
        InputButton.setBackgroundResource(R.drawable.token_red);
    }

    //Below are used for when a piece needs to be highlighted for a move
    public void turnButtonHighlightBlue(View MyView){
        Button InputButton = (Button) MyView;
        InputButton.setBackgroundResource(R.drawable.token_blue_selected);
    }
    public void turnButtonHighlightRed(View MyView){
        Button InputButton = (Button) MyView;
        InputButton.setBackgroundResource(R.drawable.token_red_selected);
    }

}