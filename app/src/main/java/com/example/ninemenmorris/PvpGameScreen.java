package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PvpGameScreen extends AppCompatActivity {
    String lastMove;
    private int player1PieceOnBoard=0;
    private int player1PieceOnHand=9;
    private int player2PieceOnBoard=0;
    private int player2PieceOnHand=9;
    private Button[] player1PieceArray = new Button[9];
    private Button[] player2PieceArray = new Button[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_game_screen);
        lastMove = "P2";
    }
    public void toModeSelection(View myView){
        Intent modeSelection = new Intent(this, ModeSelectionScreen.class);
        startActivity(modeSelection);
        this.finish();
    }

    public void placeMove(View myView){
        Button theMoves = (Button) myView;
        //game loop: Place move=>if mills=>enable opponent's moves=>remove it=>disable opponent's move
        //When there are still pieces to play
        if ((player1PieceOnBoard+player1PieceOnHand > 2) || (player2PieceOnBoard+player2PieceOnHand > 2)){
            //When there are sill pieces on hand
            if (player1PieceOnHand > 0 && player2PieceOnHand > 0){
                if (isMill() == true){
                    enableP2Moves();
                    //removeOpponentPieceIfMill(theMoves);
                    disableP2Moves();
                    lastMove = "P2";
                }//if
                else if (isMill() == true){
                    enableP1Moves();
                    //removeOpponentPieceIfMill(theMoves);
                    disableP1Moves();
                    lastMove = "P1";
                }//else if
                else if (isMill() == false && lastMove == "P1"){
                    player2Turn(theMoves);
                }//else if
                else if (isMill() == false && lastMove == "P2"){
                    player1Turn(theMoves);
                }//else if
            }//if
            //When there are no pieces left on hand
            if (player1PieceOnHand == 0 && player2PieceOnHand == 0){

            }//if

        }//if
    }//placeMove

    public void updateP1PieceCounterTV(){
        TextView p1CounterTV=(TextView) findViewById(R.id.p1CounterTV);
        p1CounterTV.setText(String.valueOf(player1PieceOnHand));
    }//updateP1PieceCounterTV

    public void updateP2PieceCounterTV(){
        TextView p2CounterTV=(TextView) findViewById(R.id.p2CounterTV);
        p2CounterTV.setText(String.valueOf(player2PieceOnHand));
    }//updateP2PieceCounterTV

    public void player1Turn(Button theMove){
        TextView textView = (TextView) findViewById(R.id.textView2);
        theMove.setText("P1");
        player1PieceArray[9-player1PieceOnHand]=theMove;
        player1PieceOnHand--;
        player1PieceOnBoard++;
        theMove.setEnabled(false);
        updateP1PieceCounterTV();
        lastMove="P1";
        textView.setText(lastMove);

    }

    public void player2Turn(Button theMove){
        TextView textView = (TextView) findViewById(R.id.textView2);
        theMove.setText("P2");
        player2PieceArray[9-player2PieceOnHand]=theMove;
        player2PieceOnHand--;
        player2PieceOnBoard++;
        theMove.setEnabled(false);
        updateP2PieceCounterTV();
        lastMove="P2";
        textView.setText(lastMove);
    }


    public void movePieceAdjacent(){

    }

    public Button returnAdjacentButtonId(Button mainButton){

        return mainButton;
    }


    public void removeOpponentPieceIfMill(Button toRemove){
        //human's turn
        if (lastMove=="P1"){
            for (int i = 0; i< player1PieceArray.length; i++){
                if (player1PieceArray[i]==toRemove){
                    player1PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            player2PieceOnBoard--;
        }
        //computer's turn
        if (lastMove=="P2"){
            for (int i = 0; i< player2PieceArray.length; i++){
                if (player2PieceArray[i]==toRemove){
                    player2PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            player1PieceOnBoard--;
        }

    }


    public void enableP2Moves(){
        for (int i = 0; i< player2PieceArray.length; i++){
            if (player2PieceArray[i] != null){
                player2PieceArray[i].setEnabled(true);
            }
        }
    }

    public void enableP1Moves(){
        for (int i = 0; i< player1PieceArray.length; i++){
            if(player1PieceArray[i]!=null){
                player1PieceArray[i].setEnabled(true);
            }
        }
    }

    public void disableP2Moves(){
        for (int i = 0; i< player2PieceArray.length; i++){
            if(player2PieceArray[i]!=null){
                player2PieceArray[i].setEnabled(false);
            }
        }
    }

    public void disableP1Moves(){
        for (int i = 0; i< player1PieceArray.length; i++){
            if(player1PieceArray[i]!=null) {
                player1PieceArray[i].setEnabled(false);
            }
        }
    }

    public boolean isMill() {
        //all moves on first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        Button b07 = (Button) findViewById(R.id.pvpB07);

        Button b10 = (Button) findViewById(R.id.pvpB10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        Button b17 = (Button) findViewById(R.id.pvpB17);

        Button b20 = (Button) findViewById(R.id.pvpB20);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        Button b27 = (Button) findViewById(R.id.pvpB27);

        //first outer layer
        //check first layer above
        if (b00.getText().equals(lastMove) && b01.getText().equals(lastMove) && b02.getText().equals(lastMove))
            return true;
        //check first layer left
        if (b00.getText().equals(lastMove) && b03.getText().equals(lastMove) && b05.getText().equals(lastMove))
            return true;
        //check first layer right
        if (b02.getText().equals(lastMove) && b04.getText().equals(lastMove) && b07.getText().equals(lastMove))
            return true;
        //check first layer below
        if (b05.getText().equals(lastMove) && b06.getText().equals(lastMove) && b07.getText().equals(lastMove))
            return true;

        //second inner layer
        //check second layer above
        if (b10.getText().equals(lastMove) && b11.getText().equals(lastMove) && b12.getText().equals(lastMove))
            return true;
        //check second layer left
        if (b10.getText().equals(lastMove) && b13.getText().equals(lastMove) && b15.getText().equals(lastMove))
            return true;
        //check second layer right
        if (b12.getText().equals(lastMove) && b14.getText().equals(lastMove) && b17.getText().equals(lastMove))
            return true;
        //check second layer below
        if (b15.getText().equals(lastMove) && b17.getText().equals(lastMove) && b17.getText().equals(lastMove))
            return true;

        //third inner layer
        //check third layer above
        if (b20.getText().equals(lastMove) && b21.getText().equals(lastMove) && b22.getText().equals(lastMove))
            return true;
        //check third layer left
        if (b20.getText().equals(lastMove) && b23.getText().equals(lastMove) && b25.getText().equals(lastMove))
            return true;
        //check third layer right
        if (b22.getText().equals(lastMove) && b24.getText().equals(lastMove) && b27.getText().equals(lastMove))
            return true;
        //check third layer below
        if (b25.getText().equals(lastMove) && b26.getText().equals(lastMove) && b27.getText().equals(lastMove))
            return true;

        //middles
        //check middle above
        if (b01.getText().equals(lastMove) && b11.getText().equals(lastMove) && b21.getText().equals(lastMove))
            return true;
        //check middle left
        if (b03.getText().equals(lastMove) && b13.getText().equals(lastMove) && b23.getText().equals(lastMove))
            return true;
        //check middle right
        if (b04.getText().equals(lastMove) && b14.getText().equals(lastMove) && b24.getText().equals(lastMove))
            return true;
        //check middle below
        if (b06.getText().equals(lastMove) && b16.getText().equals(lastMove) && b26.getText().equals(lastMove))
            return true;
        return false;
    }

}