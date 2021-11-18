package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PvcGameScreen extends AppCompatActivity {
    String lastMove;
    private int player1PieceOnBoard=0;
    private int player1PieceOnHand=9;
    private int computerPieceOnBoard=0;
    private int computerPieceOnHand=9;
    private Button[] playerPieceArray = new Button[9];
    private Button[] computerPieceArray = new Button[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
        lastMove = "P";
    }

    public void toModeSelection(View myView){
        Intent modeSelection = new Intent(this, ModeSelectionScreen.class);
        startActivity(modeSelection);
        this.finish();
    }

    public void playerOrComputer(View myView){
        Button theMoves = (Button) myView;
        //Initial state of the game
        if ((player1PieceOnHand==9)&&(computerPieceOnHand==9)){
            theMoves.setText(lastMove);
            theMoves.setEnabled(false);
        }
    }


}