package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class PvcGameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
    }



    //////////////////////////////////
    //      VISUAL BELOW            //
    //////////////////////////////////

    /*
    Changes the turn arrow depending on input turn
    0 - Blue
    1 - Red
     */
    public void flipTurnWidget(int turn){
        ImageView arrow = (ImageView) findViewById(R.id.turnWidget);
        if (turn == 0){
            arrow.setBackgroundResource(R.drawable.turn_blue);
        }
        else{
            arrow.setBackgroundResource(R.drawable.turn_red);
        }
    }
    /*
    Changes the counter depending on the number and player
    int player 0 - Blue, 1 - Red
    int number 0-9
     */
    public void changeCounterNumber(int player, int number) {
        //By default blue
        ImageView counter= (ImageView) findViewById(R.id.playerBlueCounter);

        if(player == 1) {
            counter = (ImageView) findViewById(R.id.playerRedCounter);
        }

        //Int array that contains the font ids in order
        int[] fonts = {(R.drawable.font_0), (R.drawable.font_1), (R.drawable.font_2), (R.drawable.font_3),
                (R.drawable.font_4), (R.drawable.font_5), (R.drawable.font_6), (R.drawable.font_7),
                (R.drawable.font_8), (R.drawable.font_9)};

        //Change counter to specific number font
        counter.setBackgroundResource(fonts[number]);
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