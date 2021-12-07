package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PvpGameScreen extends AppCompatActivity{
    String lastMove;
    private int player1PieceOnBoard=0;
    private int player1PieceOnHand=9;
    private int player2PieceOnBoard=0;
    private int player2PieceOnHand=9;
    private int positionOfTheRemovedButton;
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
            if (player1PieceOnHand > 0 || player2PieceOnHand > 0) {
                if (lastMove=="P1"){
                    player2Turn(theMoves);
                    if(isMill(theMoves)){
                        enableP1Moves();
                        lastMove="p2RemoveTurn";
                    }
                 }
                else if (lastMove=="P2"){
                     player1Turn(theMoves);
                     if(isMill(theMoves)){
                         enableP2Moves();
                         lastMove="p1RemoveTurn";
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
                if(lastMove=="P2"){
                    if(isInArray(theMoves)){
                        if(theMoves.isEnabled()){
                            enableEmptyAdjacentButtons(theMoves);
                            removePieceFromArrayWhenMoving(theMoves);
                        }else {
                            disableAllPieces();
                            enableP2Moves();
                        }
                    }else if (isInArray(theMoves)==false){
                        moveP2PieceAdjacent(theMoves);
                        if(isMill(theMoves)){
                            enableP1Moves();
                            lastMove="p2RemoveTurn";
                        }
                        disableP2Moves();
                        enableP1Moves();
                    }
                }else if(lastMove=="P1"){
                    if(isInArray(theMoves)){
                        if(theMoves.isEnabled()){
                            enableEmptyAdjacentButtons(theMoves);
                            removePieceFromArrayWhenMoving(theMoves);
                        }else {
                            disableAllPieces();
                            enableP1Moves();
                        }
                    }else if (isInArray(theMoves)==false){
                        moveP1PieceAdjacent(theMoves);
                        if(isMill(theMoves)){
                            enableP2Moves();
                            lastMove="p1RemoveTurn";
                        }
                        disableP1Moves();
                        enableP2Moves();
                    }
                }
                else if((lastMove=="p1RemoveTurn")||(lastMove=="p2RemoveTurn")){
                    removeOpponentPieceIfMill(myView);
                    disableP2Moves();
                    disableP1Moves();
                }
            }//if
        }//if
    }//placeMove
    public boolean isInArray(Button theMove){
        if(lastMove=="P1"){
            for (int i=0; i<player1PieceArray.length; i++){
                if(player1PieceArray[i]==theMove){
                    return true;
                }
            }
        }else if(lastMove=="P2"){
            for (int i=0; i<player2PieceArray.length; i++){
                if(player2PieceArray[i]==theMove){
                    return true;
                }
            }
        }
        return false;
    }

    public void updateP1PieceCounterTV(){
        changeCounterNumber(0, 9-player1PieceOnBoard);
    }//updateP1PieceCounterTV

    public void updateP2PieceCounterTV(){
        changeCounterNumber(1, 9-player2PieceOnBoard);
    }//updateP2PieceCounterTV

    public void player1Turn(Button theMove){
        turnButtonBlue(theMove);
        theMove.setEnabled(false);
        player1PieceArray[9-player1PieceOnHand]=theMove;
        player1PieceOnHand--;
        player1PieceOnBoard++;
        updateP1PieceCounterTV();
        lastMove="P1";
        flipTurnWidget(1);
    }//player1Turn

    public void player2Turn(Button theMove){
        turnButtonRed(theMove);
        theMove.setEnabled(false);
        player2PieceArray[9-player2PieceOnHand]=theMove;
        player2PieceOnHand--;
        player2PieceOnBoard++;
        updateP2PieceCounterTV();
        lastMove="P2";
        flipTurnWidget(0);
    }//player1Turn

    public void moveP1PieceAdjacent(Button placeToMoveTo){
        turnButtonBlue(placeToMoveTo);
        lastMove="P2";
        player1PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
        flipTurnWidget(0);
    }
    public void moveP2PieceAdjacent(Button placeToMoveTo){
        turnButtonRed(placeToMoveTo);
        lastMove="P1";
        player2PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
        flipTurnWidget(1);
    }
    public void movePieceAdjacent(Button placeToMoveTo){
        if(lastMove=="P1"){
            turnButtonBlue(placeToMoveTo);
            player1PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
            flipTurnWidget(1);
        }
        if(lastMove=="P2"){
            turnButtonRed(placeToMoveTo);
            player2PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
            flipTurnWidget(0);
        }
    }

    public void removePieceFromArrayWhenMoving(Button chosenToBeMove){
        if(lastMove=="P1"){
            turnButtonWhite(chosenToBeMove);
            for(int i=0;i<player1PieceArray.length;i++){
                if(player1PieceArray[i]==chosenToBeMove){
                    player1PieceArray[i]=null;
                    positionOfTheRemovedButton=i;
                }
            }
        }
        if(lastMove=="P2"){
            turnButtonWhite(chosenToBeMove);
            for(int i=0;i<player2PieceArray.length;i++){
                if(player2PieceArray[i]==chosenToBeMove){
                    player2PieceArray[i]=null;
                    positionOfTheRemovedButton=i;
                }
            }
        }
    }

    public void enableEmptyAdjacentButtons(Button chosenToBeMove){
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

        //If the chosen button is in the first square
        if(chosenToBeMove==b00){
            if((b01.getText()!="P1")&&(b01.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b03.getText()!="P1")&&(b03.getText()!="P2")){
                b03.setEnabled(true);
            }

        }
        if(chosenToBeMove==b01){
            if((b11.getText()!="P1")&&(b11.getText()!="P2")){
                b11.setEnabled(true);
            }
            if((b00.getText()!="P1")&&(b00.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b02.getText()!="P1")&&(b02.getText()!="P2")){
                b02.setEnabled(true);
            }
        }
        if(chosenToBeMove==b02){
            if((b01.getText()!="P1")&&(b01.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b04.getText()!="P1")&&(b04.getText()!="P2")){
                b04.setEnabled(true);
            }

        }
        if(chosenToBeMove==b03){
            if((b00.getText()!="P1")&&(b00.getText()!="P2")){
                b00.setEnabled(true);
            }
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }
            if((b05.getText()!="P1")&&(b05.getText()!="P2")){
                b05.setEnabled(true);
            }
        }
        if(chosenToBeMove==b04){
            if((b02.getText()!="P1")&&(b02.getText()!="P2")){
                b02.setEnabled(true);
            }
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }
            if((b07.getText()!="P1")&&(b07.getText()!="P2")){
                b07.setEnabled(true);
            }
        }
        if(chosenToBeMove==b05){
            if((b03.getText()!="P1")&&(b03.getText()!="P2")){
                b03.setEnabled(true);
            }
            if((b06.getText()!="P1")&&(b06.getText()!="P2")){
                b06.setEnabled(true);
            }
        }
        if(chosenToBeMove==b06){
            if((b05.getText()!="P1")&&(b05.getText()!="P2")){
                b05.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
            if((b07.getText()!="P1")&&(b07.getText()!="P2")){
                b07.setEnabled(true);
            }
        }
        if(chosenToBeMove==b07){
            if((b04.getText()!="P1")&&(b04.getText()!="P2")){
                b04.setEnabled(true);
            }
            if((b06.getText()!="P1")&&(b06.getText()!="P2")){
                b06.setEnabled(true);
            }
        }

        //If the chosen button is in the second square
        if(chosenToBeMove==b10){
            if((b11.getText()!="P1")&&(b11.getText()!="P2")){
                b11.setEnabled(true);
            }
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }

        }
        if(chosenToBeMove==b11){
            if((b21.getText()!="P1")&&(b21.getText()!="P2")){
                b21.setEnabled(true);
            }
            if((b10.getText()!="P1")&&(b10.getText()!="P2")){
                b10.setEnabled(true);
            }
            if((b12.getText()!="P1")&&(b12.getText()!="P2")){
                b12.setEnabled(true);
            }
        }
        if(chosenToBeMove==b12){
            if((b11.getText()!="P1")&&(b11.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }

        }
        if(chosenToBeMove==b13){
            if((b10.getText()!="P1")&&(b10.getText()!="P2")){
                b10.setEnabled(true);
            }
            if((b23.getText()!="P1")&&(b23.getText()!="P2")){
                b23.setEnabled(true);
            }
            if((b15.getText()!="P1")&&(b15.getText()!="P2")){
                b15.setEnabled(true);
            }
        }
        if(chosenToBeMove==b14){
            if((b12.getText()!="P1")&&(b12.getText()!="P2")){
                b12.setEnabled(true);
            }
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }
            if((b17.getText()!="P1")&&(b17.getText()!="P2")){
                b17.setEnabled(true);
            }
        }
        if(chosenToBeMove==b15){
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
        }
        if(chosenToBeMove==b16){
            if((b15.getText()!="P1")&&(b15.getText()!="P2")){
                b15.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
            if((b17.getText()!="P1")&&(b17.getText()!="P2")){
                b17.setEnabled(true);
            }
        }
        if(chosenToBeMove==b17){
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
        }

        //If the chosen button is in the third square
        if(chosenToBeMove==b20){
            if((b21.getText()!="P1")&&(b21.getText()!="P2")){
                b21.setEnabled(true);
            }
            if((b23.getText()!="P1")&&(b23.getText()!="P2")){
                b23.setEnabled(true);
            }

        }
        if(chosenToBeMove==b21){
            if((b20.getText()!="P1")&&(b20.getText()!="P2")){
                b20.setEnabled(true);
            }
            if((b22.getText()!="P1")&&(b22.getText()!="P2")){
                b22.setEnabled(true);
            }
            if((b11.getText()!="P1")&&(b11.getText()!="P2")){
                b11.setEnabled(true);
            }
        }
        if(chosenToBeMove==b22){
            if((b21.getText()!="P1")&&(b21.getText()!="P2")){
                b21.setEnabled(true);
            }
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }

        }
        if(chosenToBeMove==b23){
            if((b20.getText()!="P1")&&(b20.getText()!="P2")){
                b25.setEnabled(true);
            }
            if((b25.getText()!="P1")&&(b25.getText()!="P2")){
                b25.setEnabled(true);
            }
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }
        }
        if(chosenToBeMove==b24){
            if((b22.getText()!="P1")&&(b22.getText()!="P2")){
                b22.setEnabled(true);
            }
            if((b27.getText()!="P1")&&(b27.getText()!="P2")){
                b27.setEnabled(true);
            }
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }
        }
        if(chosenToBeMove==b25){
            if((b23.getText()!="P1")&&(b23.getText()!="P2")){
                b23.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
        }
        if(chosenToBeMove==b26){
            if((b25.getText()!="P1")&&(b25.getText()!="P2")){
                b15.setEnabled(true);
            }
            if((b27.getText()!="P1")&&(b27.getText()!="P2")){
                b27.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
        }
        if(chosenToBeMove==b27){
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
        }




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
            turnButtonWhite(toRemove);
            player2PieceOnBoard--;
            lastMove="P2";


        }

        if (lastMove=="p1RemoveTurn"){
            for (int i = 0; i< player2PieceArray.length; i++){
                if (player2PieceArray[i]==toRemove){
                    player2PieceArray[i]=null;
                }
            }
            turnButtonWhite(toRemove);
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

    public boolean isMill(Button theMove) {
        int idOfTheMove = theMove.getId();
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
        if((idOfTheMove==b00.getId())||(idOfTheMove==b01.getId())||(idOfTheMove==b02.getId())){
            if (b00.getText().equals(lastMove) && b01.getText().equals(lastMove) && b02.getText().equals(lastMove))
                return true;
        }

        //check first layer left
        if((idOfTheMove==b00.getId())||(idOfTheMove==b03.getId())||(idOfTheMove==b05.getId())){
            if (b00.getText().equals(lastMove) && b03.getText().equals(lastMove) && b05.getText().equals(lastMove))
                return true;
        }

        //check first layer right
        if((idOfTheMove==b02.getId())||(idOfTheMove==b04.getId())||(idOfTheMove==b07.getId())){
            if (b02.getText().equals(lastMove) && b04.getText().equals(lastMove) && b07.getText().equals(lastMove))
                return true;
        }
        //check first layer below
        if((idOfTheMove==b05.getId())||(idOfTheMove==b06.getId())||(idOfTheMove==b07.getId())){
            if (b05.getText().equals(lastMove) && b06.getText().equals(lastMove) && b07.getText().equals(lastMove))
                return true;
        }


        //second inner layer
        //check second layer above
        if((idOfTheMove==b10.getId())||(idOfTheMove==b11.getId())||(idOfTheMove==b12.getId())){
            if (b10.getText().equals(lastMove) && b11.getText().equals(lastMove) && b12.getText().equals(lastMove))
                return true;
        }

        //check second layer left
        if((idOfTheMove==b10.getId())||(idOfTheMove==b13.getId())||(idOfTheMove==b15.getId())){
            if (b10.getText().equals(lastMove) && b13.getText().equals(lastMove) && b15.getText().equals(lastMove))
                return true;
        }

        //check second layer right
        if((idOfTheMove==b12.getId())||(idOfTheMove==b14.getId())||(idOfTheMove==b17.getId())){
            if (b12.getText().equals(lastMove) && b14.getText().equals(lastMove) && b17.getText().equals(lastMove))
                return true;
        }

        //check second layer below
        if((idOfTheMove==b15.getId())||(idOfTheMove==b16.getId())||(idOfTheMove==b17.getId())){
            if (b15.getText().equals(lastMove) && b16.getText().equals(lastMove) && b17.getText().equals(lastMove))
                return true;
        }


        //third inner layer
        //check third layer above
        if((idOfTheMove==b20.getId())||(idOfTheMove==b21.getId())||(idOfTheMove==b22.getId())){
            if (b20.getText().equals(lastMove) && b21.getText().equals(lastMove) && b22.getText().equals(lastMove))
                return true;
        }

        //check third layer left
        if((idOfTheMove==b20.getId())||(idOfTheMove==b23.getId())||(idOfTheMove==b25.getId())){
            if (b20.getText().equals(lastMove) && b23.getText().equals(lastMove) && b25.getText().equals(lastMove))
                return true;
        }

        //check third layer right
        if((idOfTheMove==b22.getId())||(idOfTheMove==b24.getId())||(idOfTheMove==b27.getId())){
            if (b22.getText().equals(lastMove) && b24.getText().equals(lastMove) && b27.getText().equals(lastMove))
                return true;
        }

        //check third layer below
        if((idOfTheMove==b25.getId())||(idOfTheMove==b26.getId())||(idOfTheMove==b27.getId())){
            if (b25.getText().equals(lastMove) && b26.getText().equals(lastMove) && b27.getText().equals(lastMove))
                return true;
        }


        //middles
        //check middle above
        if((idOfTheMove==b01.getId())||(idOfTheMove==b11.getId())||(idOfTheMove==b21.getId())){
            if (b01.getText().equals(lastMove) && b11.getText().equals(lastMove) && b21.getText().equals(lastMove))
                return true;
        }

        //check middle left
        if((idOfTheMove==b03.getId())||(idOfTheMove==b13.getId())||(idOfTheMove==b23.getId())){
            if (b03.getText().equals(lastMove) && b13.getText().equals(lastMove) && b23.getText().equals(lastMove))
                return true;
        }

        //check middle right
        if((idOfTheMove==b04.getId())||(idOfTheMove==b14.getId())||(idOfTheMove==b24.getId())){
            if (b04.getText().equals(lastMove) && b14.getText().equals(lastMove) && b24.getText().equals(lastMove))
                return true;
        }

        //check middle below
        if((idOfTheMove==b06.getId())||(idOfTheMove==b16.getId())||(idOfTheMove==b26.getId())){
            if (b06.getText().equals(lastMove) && b16.getText().equals(lastMove) && b26.getText().equals(lastMove))
                return true;
        }
        return false;
    }

    public void disableAllPieces(){
        Button b00 = (Button) findViewById(R.id.pvpB00);
        b00.setEnabled(false);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        b01.setEnabled(false);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        b02.setEnabled(false);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        b03.setEnabled(false);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        b04.setEnabled(false);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        b05.setEnabled(false);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        b06.setEnabled(false);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        b07.setEnabled(false);

        Button b10 = (Button) findViewById(R.id.pvpB10);
        b10.setEnabled(false);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        b11.setEnabled(false);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        b12.setEnabled(false);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        b13.setEnabled(false);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        b14.setEnabled(false);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        b15.setEnabled(false);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        b16.setEnabled(false);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        b17.setEnabled(false);

        Button b20 = (Button) findViewById(R.id.pvpB20);
        b20.setEnabled(false);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        b21.setEnabled(false);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        b22.setEnabled(false);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        b23.setEnabled(false);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        b24.setEnabled(false);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        b25.setEnabled(false);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        b26.setEnabled(false);
        Button b27 = (Button) findViewById(R.id.pvpB27);
        b27.setEnabled(false);
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
            arrow.setImageResource(R.drawable.turn_blue);
        }
        else{
            arrow.setImageResource(R.drawable.turn_red);
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
        counter.setImageResource(fonts[number]);
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