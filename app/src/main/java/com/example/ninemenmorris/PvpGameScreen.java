package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PvpGameScreen extends AppCompatActivity {
    String lastMove;
    private int player1PieceOnBoard=0;
    private int player1PieceOnHand=9;
    private int player2PieceOnBoard=0;
    private int player2PieceOnHand=9;
    private Button[] playerPieceArray = new Button[9];
    private Button[] computerPieceArray = new Button[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_game_screen);
        lastMove = "P";
    }
    public void toModeSelection(View myView){
        Intent modeSelection = new Intent(this, ModeSelectionScreen.class);
        startActivity(modeSelection);
        this.finish();
    }

    public void p1Orp2(View myView){
        Button theMoves = (Button) myView;
        //Initial state of the game
        if ((player1PieceOnHand==9)&&(player2PieceOnHand==9)){
            theMoves.setText(lastMove);
            theMoves.setEnabled(false);
        }
    }

    public boolean isThreePiece(){
        //all moves on first square
        Button b00=(Button) findViewById(R.id.pvpB00);
        Button b01=(Button) findViewById(R.id.pvpB01);
        Button b02=(Button) findViewById(R.id.pvpB02);
        Button b03=(Button) findViewById(R.id.pvpB03);
        Button b04=(Button) findViewById(R.id.pvpB04);
        Button b05=(Button) findViewById(R.id.pvpB05);
        Button b06=(Button) findViewById(R.id.pvpB06);
        Button b07=(Button) findViewById(R.id.pvpB07);
    }


}