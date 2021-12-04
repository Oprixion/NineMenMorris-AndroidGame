package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
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
    private Button[][] millOnBoardArray = new Button[9][9];
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
            if (player1PieceOnHand > 0 && player2PieceOnHand > 0) {
                if (lastMove=="P1"){
                    player2Turn(theMoves);
                    if(isMill()){
                        enableP1Moves();
                        lastMove="p2RemoveTurn";
                        //removeOpponentPieceIfMill(myView);
                    }
                 }
                else if (lastMove=="P2"){
                     player1Turn(theMoves);
                     if(isMill()){
                         enableP2Moves();
                         lastMove="p1RemoveTurn";
                         //removeOpponentPieceIfMill(myView);
                     }
                 }
                else if((lastMove=="p1RemoveTurn")||(lastMove=="p2RemoveTurn")){
                    removeOpponentPieceIfMill(myView);
                    disableP2Moves();
                    disableP1Moves();

                }
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


    public void removeOpponentPieceIfMill(View myView){
        Button toRemove = (Button) myView;
        //human's turn
        if (lastMove=="p2RemoveTurn"){
            for (int i = 0; i< player1PieceArray.length; i++){
                if (player1PieceArray[i]==toRemove){
                    player1PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            player2PieceOnBoard--;
            lastMove="P2";


        }

        if (lastMove=="p1RemoveTurn"){
            for (int i = 0; i< player2PieceArray.length; i++){
                if (player2PieceArray[i]==toRemove){
                    player2PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            player1PieceOnBoard--;
            lastMove="P1";

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

    public boolean isMill2(Button theMove){
        Button b00 = (Button) findViewById(R.id.pvpB00);
        millOnBoardArray[0][0] = b00;
        Button b01 = (Button) findViewById(R.id.pvpB01);
        millOnBoardArray[0][1] = b01;
        Button b02 = (Button) findViewById(R.id.pvpB02);
        millOnBoardArray[0][2] = b02;
        Button b03 = (Button) findViewById(R.id.pvpB03);
        millOnBoardArray[0][3] = b03;
        Button b04 = (Button) findViewById(R.id.pvpB04);
        millOnBoardArray[0][4] = b04;
        Button b05 = (Button) findViewById(R.id.pvpB05);
        millOnBoardArray[0][5] = b05;
        Button b06 = (Button) findViewById(R.id.pvpB06);
        millOnBoardArray[0][6] = b06;
        Button b07 = (Button) findViewById(R.id.pvpB07);
        millOnBoardArray[0][7] = b07;

        Button b10 = (Button) findViewById(R.id.pvpB10);
        millOnBoardArray[1][0] = b10;
        Button b11 = (Button) findViewById(R.id.pvpB11);
        millOnBoardArray[1][1] = b11;
        Button b12 = (Button) findViewById(R.id.pvpB12);
        millOnBoardArray[1][2] = b12;
        Button b13 = (Button) findViewById(R.id.pvpB13);
        millOnBoardArray[1][3] = b13;
        Button b14 = (Button) findViewById(R.id.pvpB14);
        millOnBoardArray[1][4] = b14;
        Button b15 = (Button) findViewById(R.id.pvpB15);
        millOnBoardArray[1][5] = b15;
        Button b16 = (Button) findViewById(R.id.pvpB16);
        millOnBoardArray[1][6] = b16;
        Button b17 = (Button) findViewById(R.id.pvpB17);
        millOnBoardArray[1][7] = b17;

        Button b20 = (Button) findViewById(R.id.pvpB20);
        millOnBoardArray[2][0] = b20;
        Button b21 = (Button) findViewById(R.id.pvpB21);
        millOnBoardArray[2][1] = b21;
        Button b22 = (Button) findViewById(R.id.pvpB22);
        millOnBoardArray[2][2] = b22;
        Button b23 = (Button) findViewById(R.id.pvpB23);
        millOnBoardArray[2][3] = b23;
        Button b24 = (Button) findViewById(R.id.pvpB24);
        millOnBoardArray[2][4] = b24;
        Button b25 = (Button) findViewById(R.id.pvpB25);
        millOnBoardArray[2][5] = b25;
        Button b26 = (Button) findViewById(R.id.pvpB26);
        millOnBoardArray[2][6] = b26;
        Button b27 = (Button) findViewById(R.id.pvpB27);
        millOnBoardArray[2][7] = b27;
    }

}