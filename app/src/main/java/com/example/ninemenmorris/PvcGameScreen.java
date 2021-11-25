package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PvcGameScreen extends AppCompatActivity {
     Button[][] buttonArray = new Button [8][8];
     String playerPiece;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
        playerPiece= "P";
    }
    public void buttonsBoard(Button [][] gameBoard) {
        Button b00 = (Button) findViewById(R.id.button00);
        Button b01 = (Button) findViewById(R.id.button01);
        Button b02 = (Button) findViewById(R.id.button02);
        Button b03 = (Button) findViewById(R.id.button03);
        Button b04 = (Button) findViewById(R.id.button04);
        Button b05 = (Button) findViewById(R.id.button05);
        Button b06 = (Button) findViewById(R.id.button06);
        Button b07 = (Button) findViewById(R.id.button07);

        Button b10 = (Button) findViewById(R.id.button10);
        Button b11 = (Button) findViewById(R.id.button11);
        Button b12 = (Button) findViewById(R.id.button12);
        Button b13 = (Button) findViewById(R.id.button13);
        Button b14 = (Button) findViewById(R.id.button14);
        Button b15 = (Button) findViewById(R.id.button15);
        Button b16 = (Button) findViewById(R.id.button16);
        Button b17 = (Button) findViewById(R.id.button17);

        Button b20 = (Button) findViewById(R.id.button20);
        Button b21 = (Button) findViewById(R.id.button21);
        Button b22 = (Button) findViewById(R.id.button22);
        Button b23 = (Button) findViewById(R.id.button23);
        Button b24 = (Button) findViewById(R.id.button24);
        Button b25 = (Button) findViewById(R.id.button25);
        Button b26 = (Button) findViewById(R.id.button26);
        Button b27 = (Button) findViewById(R.id.button27);

        gameBoard[0][0] = b00;
        gameBoard[0][1] = b01;
        gameBoard[0][2] = b02;
        gameBoard[0][3] = b03;
        gameBoard[0][4] = b04;
        gameBoard[0][5] = b05;
        gameBoard[0][6] = b06;
        gameBoard[0][7] = b07;

        gameBoard[1][0] = b10;
        gameBoard[1][1] = b11;
        gameBoard[1][2] = b12;
        gameBoard[1][3] = b13;
        gameBoard[1][4] = b14;
        gameBoard[1][5] = b15;
        gameBoard[1][6] = b16;
        gameBoard[1][7] = b17;

        gameBoard[2][0] = b20;
        gameBoard[2][1] = b21;
        gameBoard[2][2] = b22;
        gameBoard[2][3] = b23;
        gameBoard[2][4] = b24;
        gameBoard[2][5] = b25;
        gameBoard[2][6] = b26;
        gameBoard[2][7] = b27;
    }
    public void playerOrComputer(View myView){
        Button myButton = (Button) myView;
        myButton.setText("P");
        myButton.setEnabled(false);
        if (playerPiece.equals("P")){
            playerPiece = "C";
        }
        else {
            playerPiece = "P";
        }
    }





}