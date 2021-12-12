package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PvpGameScreen extends AppCompatActivity{
    String lastMove;
    private int player1PieceOnBoard=0;
    private int player1PieceOnHand=9;
    private int player2PieceOnBoard=0;
    private int player2PieceOnHand=9;
    private int positionOfTheRemovedButton;

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
    }//toModeSelection

    public void placeMove(View myView){
        Button theMove = (Button) myView;
        //When there are still pieces to play
        if ((player1PieceOnBoard+player1PieceOnHand > 2) && (player2PieceOnBoard+player2PieceOnHand > 2)){
            //When there are sill pieces on hand (Phase 1)
            //Game loop for this stage:
            // 1.Check the last move to determine whose turn it is.
            //      1.1. If it's players' turn go to (2).
            //      1.2. If it's remove turn got to (4.2).
            // 2.Make a move accordingly by placing a piece and add that move to the corresponding array.
            // 3.Check if the move just been made make a mill.
            //      3.1 If yes then it should enable the opponent's pieces and change the last move to
            //          whose turn it is to remove.
            //      3.2 If no then go back to (1).
            // 4. Check whether it is players' turn or remove turn.
            //      4.1 If it's players' turn then got back to (2).
            //      4.2 If it is remove turn then it should remove the selected button from the
            //          board as well as in the corresponding array.
            if (player1PieceOnHand > 0 || player2PieceOnHand > 0) {
                if (lastMove=="P1"){
                    player2Turn(theMove);
                    flipTurnWidget(0);
                    if(isMill(theMove)){
                        flipTurnWidget(1);
                        enableP1Moves();
                        lastMove="p2RemoveTurn";
                    }
                 }
                else if (lastMove=="P2"){
                    flipTurnWidget(1);
                     player1Turn(theMove);
                     if(isMill(theMove)){
                         flipTurnWidget(0);
                         enableP2Moves();
                         lastMove="p1RemoveTurn";
                     }
                }
                else if((lastMove=="p1RemoveTurn")||(lastMove=="p2RemoveTurn")){
                    removeOpponentPieceIfMill(theMove);
                    disableP2Moves();
                    disableP1Moves();
                }
            }//if

            //When there are no pieces left on hand (Phase 2+3)
            //Game loop for this stage:
            // 1.Check the last move to determine whose turn it is
            //      1.1. If it's players' turn then go to(2).
            //      1.2. If it's remove turn then go to (5).
            // 2.Check to see if the move is in the corresponding array
            //      2.1. If it's go to (3).
            //      2.2. If it's not that means it has already been selected so go to (4)
            // 3.Check to see if the move is already enable (selecting the button to be moved)
            //      3.1. If the move is enable and select it by removing it and saving its index
            //           while also enabling it neighbours
            //      3.2 If not it hasn't been selected
            // 4.Move the selected piece to an adjacent button and check if it make a mill
            //      4.1 If mill then change last move to remove turn, go to (1.2)
            //      4.2 If not mill then switch back to the other player turn.
            // 5.Remove a chosen piece of board and the corresponding array.
            if ((player1PieceOnHand == 0 && player2PieceOnHand == 0)){
                //disableBlockedButtons();
                if(lastMove=="P2"){
                    flipTurnWidget(1);
                    if(isMoveSelected(theMove)==false){
                        if(theMove.isEnabled()){
                            if(player2PieceOnBoard>3) {
                                disableAllPieces();
                                enableEmptyAdjacentButtons(theMove);
                                selectPieceToMoveByRemovingFromArray(theMove);
                            }
                            else if(player2PieceOnBoard<=3){//phase 3
                                enableAllPieces();
                                disableP2Moves();
                                disableP1Moves();
                                selectPieceToMoveByRemovingFromArray(theMove);
                            }
                        }
                        else {
                            disableAllPieces();
                            enableP2Moves();
                            if (player1PieceOnBoard>3){
                                disableBlockedButtons();
                            }
                        }
                    }
                    else if (isMoveSelected(theMove)){
                        moveP2Piece(theMove);
                        if(isMill(theMove)){
                            lastMove="p2RemoveTurn";
                            flipTurnWidget(1);
                            enableP1Moves();
                        }
                        disableAllPieces();
                        enableP1Moves();
                        if(isMill(theMove)==false){
                            if (player2PieceOnBoard>3){
                                disableBlockedButtons();
                            }
                        }
                    }
                }else if(lastMove=="P1"){
                    flipTurnWidget(0);
                    if(isMoveSelected(theMove)==false){
                        if(theMove.isEnabled()){
                            if(player2PieceOnBoard>3) {
                                disableAllPieces();
                                enableEmptyAdjacentButtons(theMove);
                                selectPieceToMoveByRemovingFromArray(theMove);
                            }
                            else if(player2PieceOnBoard<=3){//phase 3
                                enableAllPieces();
                                disableP2Moves();
                                disableP1Moves();
                                selectPieceToMoveByRemovingFromArray(theMove);
                            }
                        }
                        else {
                            disableAllPieces();
                            enableP1Moves();
                            if (player2PieceOnBoard>3){
                                disableBlockedButtons();
                            }
                        }
                    }
                    else if (isMoveSelected(theMove)){
                        moveP1Piece(theMove);
                        if(isMill(theMove)){
                            lastMove="p1RemoveTurn";
                            flipTurnWidget(0);
                            enableP2Moves();

                        }
                        disableAllPieces();
                        enableP2Moves();
                        if(isMill(theMove)==false){
                            if (player1PieceOnBoard>3){
                                disableBlockedButtons();
                            }
                        }
                    }
                }
                else if((lastMove=="p1RemoveTurn")||(lastMove=="p2RemoveTurn")){
                    if(lastMove=="p2RemoveTurn"){
                        removeOpponentPieceIfMill(theMove);
                        theMove.setEnabled(false);
                        disableP2Moves();
                        enableP1Moves();
                        if (player2PieceOnBoard>3){
                            disableBlockedButtons();
                        }
                        lastMove="P1";
                    }
                    else if(lastMove=="p1RemoveTurn"){
                        removeOpponentPieceIfMill(theMove);
                        theMove.setEnabled(false);
                        disableP1Moves();
                        enableP2Moves();
                        if (player1PieceOnBoard>3){
                            disableBlockedButtons();
                        }
                        lastMove="P2";
                    }
                }
            }//if

        }//if

        if ((player1PieceOnBoard+player1PieceOnHand <= 2) || (player2PieceOnBoard+player2PieceOnHand <= 2)) {
            Intent toRestartGame = new Intent(this, RestartScreen.class);
            startActivity(toRestartGame);
            this.finish();
        }
    }//placeMove

    public boolean isMoveSelected(Button theMove){
        if(lastMove=="P1"){
            for (int i=0; i<player1PieceArray.length; i++){
                if(player1PieceArray[i]==theMove){
                    return false;
                }
            }
        }else if(lastMove=="P2"){
            for (int i=0; i<player2PieceArray.length; i++){
                if(player2PieceArray[i]==theMove){
                    return false;
                }
            }
        }
        return true;
    }//isMoveSelected

    public void updateP1PieceCounterTV(){
        changeCounterNumber(0, player1PieceOnHand);
    }//updateP1PieceCounterTV

    public void updateP2PieceCounterTV(){
        changeCounterNumber(1, player2PieceOnHand);
    }//updateP2PieceCounterTV

    public void player1Turn(Button theMove){
        theMove.setText("P1");
        turnButtonBlue(theMove);
        theMove.setEnabled(false);
        player1PieceArray[9-player1PieceOnHand]=theMove;
        player1PieceOnHand--;
        player1PieceOnBoard++;
        updateP1PieceCounterTV();
        lastMove="P1";

    }//player1Turn

    public void player2Turn(Button theMove){
        theMove.setText("P2");
        turnButtonRed(theMove);
        theMove.setEnabled(false);
        player2PieceArray[9-player2PieceOnHand]=theMove;
        player2PieceOnHand--;
        player2PieceOnBoard++;
        updateP2PieceCounterTV();
        lastMove="P2";

    }//player1Turn

    public void moveP1Piece(Button placeToMoveTo){
        placeToMoveTo.setText("P1");
        turnButtonBlue(placeToMoveTo);
        player1PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
        lastMove="P2";
        flipTurnWidget(1);
    }//moveP1Piece

    public void moveP2Piece(Button placeToMoveTo){
        placeToMoveTo.setText("P2");
        turnButtonRed(placeToMoveTo);
        player2PieceArray[positionOfTheRemovedButton]=placeToMoveTo;
        lastMove="P1";
        flipTurnWidget(0);
    }//moveP2Piece

    public void selectPieceToMoveByRemovingFromArray(Button chosenToBeMove){
        if(lastMove=="P1"){
            chosenToBeMove.setText("");
            turnButtonWhite(chosenToBeMove);
            for(int i=0;i<player1PieceArray.length;i++){
                if(player1PieceArray[i]==chosenToBeMove){
                    player1PieceArray[i]=null;
                    positionOfTheRemovedButton=i;
                }
            }
        }
        if(lastMove=="P2"){
            chosenToBeMove.setText("");
            turnButtonWhite(chosenToBeMove);
            for(int i=0;i<player2PieceArray.length;i++){
                if(player2PieceArray[i]==chosenToBeMove){
                    player2PieceArray[i]=null;
                    positionOfTheRemovedButton=i;
                }
            }
        }
        chosenToBeMove.setEnabled(false);
    }//selectPieceToMoveByRemovingFromArray

    public void enableEmptyAdjacentButtons(Button chosenToBeMove){
        //first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        //second square
        Button b10 = (Button) findViewById(R.id.pvpB10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        //third square
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
            else b00.setEnabled(false);

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
            else b01.setEnabled(false);
        }
        if(chosenToBeMove==b02){
            if((b01.getText()!="P1")&&(b01.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b04.getText()!="P1")&&(b04.getText()!="P2")){
                b04.setEnabled(true);
            }
            else {
                b02.setEnabled(false);
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
            else {
                b03.setEnabled(false);
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
            else {
                b04.setEnabled(false);
            }
        }
        if(chosenToBeMove==b05){
            if((b03.getText()!="P1")&&(b03.getText()!="P2")){
                b03.setEnabled(true);
            }
            if((b06.getText()!="P1")&&(b06.getText()!="P2")){
                b06.setEnabled(true);
            }
            else {
                b05.setEnabled(false);
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
            else {
                b06.setEnabled(false);
            }
        }
        if(chosenToBeMove==b07){
            if((b04.getText()!="P1")&&(b04.getText()!="P2")){
                b04.setEnabled(true);
            }
            if((b06.getText()!="P1")&&(b06.getText()!="P2")){
                b06.setEnabled(true);
            }
            else {
                b07.setEnabled(false);
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
            else {
                b10.setEnabled(false);
            }

        }
        if(chosenToBeMove==b11){
            if((b01.getText()!="P1")&&(b01.getText()!="P2")){
                b01.setEnabled(true);
            }
            if((b21.getText()!="P1")&&(b21.getText()!="P2")){
                b21.setEnabled(true);
            }
            if((b10.getText()!="P1")&&(b10.getText()!="P2")){
                b10.setEnabled(true);
            }
            if((b12.getText()!="P1")&&(b12.getText()!="P2")){
                b12.setEnabled(true);
            }
            else {
                b11.setEnabled(false);
            }
        }
        if(chosenToBeMove==b12){
            if((b11.getText()!="P1")&&(b11.getText()!="P2")){
                b11.setEnabled(true);
            }
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }
            else {
                b12.setEnabled(false);
            }

        }
        if(chosenToBeMove==b13){
            if((b03.getText()!="P1")&&(b03.getText()!="P2")){
                b03.setEnabled(true);
            }
            if((b10.getText()!="P1")&&(b10.getText()!="P2")){
                b10.setEnabled(true);
            }
            if((b23.getText()!="P1")&&(b23.getText()!="P2")){
                b23.setEnabled(true);
            }
            if((b15.getText()!="P1")&&(b15.getText()!="P2")){
                b15.setEnabled(true);
            }
            else {
                b13.setEnabled(false);
            }
        }
        if(chosenToBeMove==b14){
            if((b04.getText()!="P1")&&(b04.getText()!="P2")){
                b04.setEnabled(true);
            }
            if((b12.getText()!="P1")&&(b12.getText()!="P2")){
                b12.setEnabled(true);
            }
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }
            if((b17.getText()!="P1")&&(b17.getText()!="P2")){
                b17.setEnabled(true);
            }
            else {
                b14.setEnabled(false);
            }
        }
        if(chosenToBeMove==b15){
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
            else {
                b15.setEnabled(false);
            }
        }
        if(chosenToBeMove==b16){
            if((b06.getText()!="P1")&&(b06.getText()!="P2")){
                b06.setEnabled(true);
            }
            if((b15.getText()!="P1")&&(b15.getText()!="P2")){
                b15.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
            if((b17.getText()!="P1")&&(b17.getText()!="P2")){
                b17.setEnabled(true);
            }
            else {
                b16.setEnabled(false);
            }
        }
        if(chosenToBeMove==b17){
            if((b14.getText()!="P1")&&(b14.getText()!="P2")){
                b14.setEnabled(true);
            }
            if((b16.getText()!="P1")&&(b16.getText()!="P2")){
                b16.setEnabled(true);
            }
            else {
                b17.setEnabled(false);
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
            else {
                b20.setEnabled(false);
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
            else {
                b21.setEnabled(false);
            }
        }
        if(chosenToBeMove==b22){
            if((b21.getText()!="P1")&&(b21.getText()!="P2")){
                b21.setEnabled(true);
            }
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }
            else {
                b22.setEnabled(false);
            }

        }
        if(chosenToBeMove==b23){
            if((b20.getText()!="P1")&&(b20.getText()!="P2")){
                b20.setEnabled(true);
            }
            if((b25.getText()!="P1")&&(b25.getText()!="P2")){
                b25.setEnabled(true);
            }
            if((b13.getText()!="P1")&&(b13.getText()!="P2")){
                b13.setEnabled(true);
            }
            else {
                b23.setEnabled(false);
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
            else {
                b24.setEnabled(false);
            }
        }
        if(chosenToBeMove==b25){
            if((b23.getText()!="P1")&&(b23.getText()!="P2")){
                b23.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
            else {
                b25.setEnabled(false);
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
            else {
                b26.setEnabled(false);
            }
        }
        if(chosenToBeMove==b27){
            if((b24.getText()!="P1")&&(b24.getText()!="P2")){
                b24.setEnabled(true);
            }
            if((b26.getText()!="P1")&&(b26.getText()!="P2")){
                b26.setEnabled(true);
            }
            else {
                b27.setEnabled(false);
            }
        }
    }//enableEmptyAdjacentButtons

    public void removeOpponentPieceIfMill(Button toRemove){
        //Button toRemove = (Button) myView;
        //human's turn
        if (lastMove=="p2RemoveTurn"){
            for (int i = 0; i< player1PieceArray.length; i++){
                if (player1PieceArray[i]==toRemove){
                    player1PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            turnButtonWhite(toRemove);
            flipTurnWidget(0);
            player2PieceOnBoard--;
            lastMove="P2";


        }
        else if (lastMove=="p1RemoveTurn"){
            for (int i = 0; i< player2PieceArray.length; i++){
                if (player2PieceArray[i]==toRemove){
                    player2PieceArray[i]=null;
                }
            }
            toRemove.setText("");
            turnButtonWhite(toRemove);
            flipTurnWidget(1);
            player1PieceOnBoard--;
            lastMove="P1";
        }

    }//removeOpponentPieceIfMill

    public void enableP2Moves(){
        for (int i = 0; i< player2PieceArray.length; i++){
            if (player2PieceArray[i] != null){
                player2PieceArray[i].setEnabled(true);
                turnButtonHighlightRed(player2PieceArray[i]);
            }
        }
    }//enableP2Moves

    public void enableP1Moves(){
        for (int i = 0; i< player1PieceArray.length; i++){
            if(player1PieceArray[i]!=null){
                player1PieceArray[i].setEnabled(true);
                turnButtonHighlightBlue(player1PieceArray[i]);
            }
        }
    }//enableP1Moves

    public void disableP2Moves(){
        for (int i = 0; i< player2PieceArray.length; i++){
            if(player2PieceArray[i]!=null){
                player2PieceArray[i].setEnabled(false);
                turnButtonRed(player2PieceArray[i]);
            }
        }
    }//disableP2Moves

    public void disableP1Moves(){
        for (int i = 0; i< player1PieceArray.length; i++){
            if(player1PieceArray[i]!=null) {
                player1PieceArray[i].setEnabled(false);
                turnButtonBlue(player1PieceArray[i]);
            }
        }
    }//disableP1Moves

    public boolean isMill(Button theMove) {
        //first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        //second square
        Button b10 = (Button) findViewById(R.id.pvpB10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        //third square
        Button b20 = (Button) findViewById(R.id.pvpB20);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        Button b27 = (Button) findViewById(R.id.pvpB27);

        int idOfTheMove = theMove.getId();
        //first outer layer
        //check first layer above
        if((idOfTheMove==b00.getId())||(idOfTheMove==b01.getId())||(idOfTheMove==b02.getId())){
            if (b00.getText().equals(b01.getText()) && b01.getText().equals(b02.getText()))
                return true;
        }

        //check first layer left
        if((idOfTheMove==b00.getId())||(idOfTheMove==b03.getId())||(idOfTheMove==b05.getId())){
            if (b00.getText().equals(b03.getText()) && b03.getText().equals(b05.getText()))
                return true;
        }

        //check first layer right
        if((idOfTheMove==b02.getId())||(idOfTheMove==b04.getId())||(idOfTheMove==b07.getId())){
            if (b02.getText().equals(b04.getText()) && b04.getText().equals(b07.getText()))
                return true;
        }
        //check first layer below
        if((idOfTheMove==b05.getId())||(idOfTheMove==b06.getId())||(idOfTheMove==b07.getId())){
            if (b05.getText().equals(b06.getText()) && b06.getText().equals(b07.getText()))
                return true;
        }


        //second inner layer
        //check second layer above
        if((idOfTheMove==b10.getId())||(idOfTheMove==b11.getId())||(idOfTheMove==b12.getId())){
            if (b10.getText().equals(b11.getText()) && b11.getText().equals(b12.getText()))
                return true;
        }

        //check second layer left
        if((idOfTheMove==b10.getId())||(idOfTheMove==b13.getId())||(idOfTheMove==b15.getId())){
            if (b10.getText().equals(b13.getText()) && b13.getText().equals(b15.getText()))
                return true;
        }

        //check second layer right
        if((idOfTheMove==b12.getId())||(idOfTheMove==b14.getId())||(idOfTheMove==b17.getId())){
            if (b12.getText().equals(b14.getText()) && b14.getText().equals(b17.getText()))
                return true;
        }

        //check second layer below
        if((idOfTheMove==b15.getId())||(idOfTheMove==b16.getId())||(idOfTheMove==b17.getId())){
            if (b15.getText().equals(b16.getText()) && b16.getText().equals(b17.getText()))
                return true;
        }


        //third inner layer
        //check third layer above
        if((idOfTheMove==b20.getId())||(idOfTheMove==b21.getId())||(idOfTheMove==b22.getId())){
            if (b20.getText().equals(b21.getText()) && b21.getText().equals(b22.getText()))
                return true;
        }

        //check third layer left
        if((idOfTheMove==b20.getId())||(idOfTheMove==b23.getId())||(idOfTheMove==b25.getId())){
            if (b20.getText().equals(b23.getText()) && b23.getText().equals(b25.getText()))
                return true;
        }

        //check third layer right
        if((idOfTheMove==b22.getId())||(idOfTheMove==b24.getId())||(idOfTheMove==b27.getId())){
            if (b22.getText().equals(b24.getText()) && b24.getText().equals(b27.getText()))
                return true;
        }

        //check third layer below
        if((idOfTheMove==b25.getId())||(idOfTheMove==b26.getId())||(idOfTheMove==b27.getId())){
            if (b25.getText().equals(b26.getText()) && b26.getText().equals(b27.getText()))
                return true;
        }


        //middles
        //check middle above
        if((idOfTheMove==b01.getId())||(idOfTheMove==b11.getId())||(idOfTheMove==b21.getId())){
            if (b01.getText().equals(b11.getText()) && b11.getText().equals(b21.getText()))
                return true;
        }

        //check middle left
        if((idOfTheMove==b03.getId())||(idOfTheMove==b13.getId())||(idOfTheMove==b23.getId())){
            if (b03.getText().equals(b13.getText()) && b13.getText().equals(b23.getText()))
                return true;
        }

        //check middle right
        if((idOfTheMove==b04.getId())||(idOfTheMove==b14.getId())||(idOfTheMove==b24.getId())){
            if (b04.getText().equals(b14.getText()) && b14.getText().equals(b24.getText()))
                return true;
        }

        //check middle below
        if((idOfTheMove==b06.getId())||(idOfTheMove==b16.getId())||(idOfTheMove==b26.getId())){
            if (b06.getText().equals(b16.getText()) && b16.getText().equals(b26.getText()))
                return true;
        }
        return false;
    }//isMill

    public void disableAllPieces(){
        //first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        //second square
        Button b10 = (Button) findViewById(R.id.pvpB10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        //third square
        Button b20 = (Button) findViewById(R.id.pvpB20);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        Button b27 = (Button) findViewById(R.id.pvpB27);

        //first square
        b00.setEnabled(false);
        changeVisualUnselected(b00);
        b01.setEnabled(false);
        changeVisualUnselected(b01);
        b02.setEnabled(false);
        changeVisualUnselected(b02);
        b03.setEnabled(false);
        changeVisualUnselected(b03);
        b04.setEnabled(false);
        changeVisualUnselected(b04);
        b05.setEnabled(false);
        changeVisualUnselected(b05);
        b06.setEnabled(false);
        changeVisualUnselected(b06);
        b07.setEnabled(false);
        changeVisualUnselected(b07);

        b10.setEnabled(false);
        changeVisualUnselected(b10);
        b11.setEnabled(false);
        changeVisualUnselected(b11);
        b12.setEnabled(false);
        changeVisualUnselected(b12);
        b13.setEnabled(false);
        changeVisualUnselected(b13);
        b14.setEnabled(false);
        changeVisualUnselected(b14);
        b15.setEnabled(false);
        changeVisualUnselected(b15);
        b16.setEnabled(false);
        changeVisualUnselected(b16);
        b17.setEnabled(false);
        changeVisualUnselected(b17);

        b20.setEnabled(false);
        changeVisualUnselected(b20);
        b21.setEnabled(false);
        changeVisualUnselected(b21);
        b22.setEnabled(false);
        changeVisualUnselected(b22);
        b23.setEnabled(false);
        changeVisualUnselected(b23);
        b24.setEnabled(false);
        changeVisualUnselected(b24);
        b25.setEnabled(false);
        changeVisualUnselected(b25);
        b26.setEnabled(false);
        changeVisualUnselected(b26);
        b27.setEnabled(false);
        changeVisualUnselected(b27);
    }//disableAllPieces

    public void enableAllPieces(){
        //first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        b00.setEnabled(true);
        changeVisualUnselected(b00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        b01.setEnabled(true);
        changeVisualUnselected(b01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        b02.setEnabled(true);
        changeVisualUnselected(b02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        b03.setEnabled(true);
        changeVisualUnselected(b03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        b04.setEnabled(true);
        changeVisualUnselected(b04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        b05.setEnabled(true);
        changeVisualUnselected(b05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        b06.setEnabled(true);
        changeVisualUnselected(b06);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        b07.setEnabled(true);
        changeVisualUnselected(b07);


        Button b10 = (Button) findViewById(R.id.pvpB10);
        b10.setEnabled(true);
        changeVisualUnselected(b10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        b11.setEnabled(true);
        changeVisualUnselected(b11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        b12.setEnabled(true);
        changeVisualUnselected(b12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        b13.setEnabled(true);
        changeVisualUnselected(b13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        b14.setEnabled(true);
        changeVisualUnselected(b14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        b15.setEnabled(true);
        changeVisualUnselected(b15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        b16.setEnabled(true);
        changeVisualUnselected(b16);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        b17.setEnabled(true);
        changeVisualUnselected(b17);

        Button b20 = (Button) findViewById(R.id.pvpB20);
        b20.setEnabled(true);
        changeVisualUnselected(b20);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        b21.setEnabled(true);
        changeVisualUnselected(b21);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        b22.setEnabled(true);
        changeVisualUnselected(b22);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        b23.setEnabled(true);
        changeVisualUnselected(b23);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        b24.setEnabled(true);
        changeVisualUnselected(b24);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        b25.setEnabled(true);
        changeVisualUnselected(b25);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        b26.setEnabled(true);
        changeVisualUnselected(b26);
        Button b27 = (Button) findViewById(R.id.pvpB27);
        b27.setEnabled(true);
        changeVisualUnselected(b27);
    }//enableAllPieces

    public void disableBlockedButtons(){
        //first square
        Button b00 = (Button) findViewById(R.id.pvpB00);
        Button b01 = (Button) findViewById(R.id.pvpB01);
        Button b02 = (Button) findViewById(R.id.pvpB02);
        Button b03 = (Button) findViewById(R.id.pvpB03);
        Button b04 = (Button) findViewById(R.id.pvpB04);
        Button b05 = (Button) findViewById(R.id.pvpB05);
        Button b06 = (Button) findViewById(R.id.pvpB06);
        Button b07 = (Button) findViewById(R.id.pvpB07);
        //second square
        Button b10 = (Button) findViewById(R.id.pvpB10);
        Button b11 = (Button) findViewById(R.id.pvpB11);
        Button b12 = (Button) findViewById(R.id.pvpB12);
        Button b13 = (Button) findViewById(R.id.pvpB13);
        Button b14 = (Button) findViewById(R.id.pvpB14);
        Button b15 = (Button) findViewById(R.id.pvpB15);
        Button b16 = (Button) findViewById(R.id.pvpB16);
        Button b17 = (Button) findViewById(R.id.pvpB17);
        //third square
        Button b20 = (Button) findViewById(R.id.pvpB20);
        Button b21 = (Button) findViewById(R.id.pvpB21);
        Button b22 = (Button) findViewById(R.id.pvpB22);
        Button b23 = (Button) findViewById(R.id.pvpB23);
        Button b24 = (Button) findViewById(R.id.pvpB24);
        Button b25 = (Button) findViewById(R.id.pvpB25);
        Button b26 = (Button) findViewById(R.id.pvpB26);
        Button b27 = (Button) findViewById(R.id.pvpB27);

        //first square
        if((b01.getText()!="")&&(b03.getText()!="")) {
            b00.setEnabled(false);
            changeVisualUnselected(b00);
        }
        if((b11.getText()!="")&&(b00.getText()!="")&&(b02.getText()!="")) {
            b01.setEnabled(false);
            changeVisualUnselected(b01);
        }
        if ((b01.getText()!="")&&(b04.getText()!="")) {
            b02.setEnabled(false);
            changeVisualUnselected(b02);
        }
        if ((b00.getText()!="")&&(b13.getText()!="")&&(b05.getText()!="")) {
            b03.setEnabled(false);
            changeVisualUnselected(b03);
        }
        if ((b02.getText()!="")&&(b14.getText()!="")&&(b07.getText()!="")) {
            b04.setEnabled(false);
            changeVisualUnselected(b04);
        }
        if ((b03.getText()!="")&&(b06.getText()!="")) {
            b05.setEnabled(false);
            changeVisualUnselected(b05);
        }
        if ((b05.getText()!="")&&(b16.getText()!="")&&(b07.getText()!="")) {
            b06.setEnabled(false);
            changeVisualUnselected(b06);
        }
        if ((b04.getText()!="")&&(b06.getText()!="")) {
            b07.setEnabled(false);
            changeVisualUnselected(b07);
        }

        //second square
        if((b11.getText()!="")&&(b13.getText()!="")) {
            b10.setEnabled(false);
            changeVisualUnselected(b10);
        }
        if((b21.getText()!="")&&(b01.getText()!="")&&(b12.getText()!="")&&(b10.getText()!="")) {
            b11.setEnabled(false);
            changeVisualUnselected(b11);
        }
        if ((b11.getText()!="")&&(b14.getText()!="")) {
            b12.setEnabled(false);
            changeVisualUnselected(b12);
        }
        if ((b03.getText()!="")&&(b23.getText()!="")&&(b15.getText()!="")&&(b10.getText()!="")) {
            b13.setEnabled(false);
            changeVisualUnselected(b13);
        }
        if ((b12.getText()!="")&&(b24.getText()!="")&&(b17.getText()!="")&&(b04.getText()!="")) {
            b14.setEnabled(false);
            changeVisualUnselected(b14);
        }
        if ((b13.getText()!="P1")&&(b16.getText()!="")) {
            b15.setEnabled(false);
            changeVisualUnselected(b15);
        }
        if ((b15.getText()!="")&&(b26.getText()!="")&&(b17.getText()!="")&&(b06.getText()!="")) {
            b16.setEnabled(false);
            changeVisualUnselected(b16);
        }
        if ((b14.getText()!="")&&(b16.getText()!="")) {
            b17.setEnabled(false);
            changeVisualUnselected(b17);
        }

        //third square
        if((b21.getText()!="")&&(b23.getText()!="")) {
            b20.setEnabled(false);
            changeVisualUnselected(b20);
        }
        if((b11.getText()!="")&&(b20.getText()!="")&&(b22.getText()!="")) {
            b21.setEnabled(false);
            changeVisualUnselected(b21);
        }
        if ((b21.getText()!="")&&(b24.getText()!="")) {
            b22.setEnabled(false);
            changeVisualUnselected(b22);
        }
        if ((b20.getText()!="")&&(b13.getText()!="")&&(b25.getText()!="")) {
            b23.setEnabled(false);
            changeVisualUnselected(b23);
        }
        if ((b22.getText()!="")&&(b14.getText()!="")&&(b27.getText()!="")) {
            changeVisualUnselected(b24);
            b24.setEnabled(false);
        }
        if ((b23.getText()!="")&&(b26.getText()!="")) {
            b25.setEnabled(false);
            changeVisualUnselected(b25);
        }
        if ((b25.getText()!="")&&(b16.getText()!="")&&(b27.getText()!="")) {
            b26.setEnabled(false);
            changeVisualUnselected(b26);
        }
        if ((b24.getText()!="")&&(b26.getText()!="")) {
            b27.setEnabled(false);
            changeVisualUnselected(b27);
        }



    }//disableBlockedButtons

    public void changeVisualUnselected(Button toBeDisabled){
        if(toBeDisabled.getText()=="P2"){
            turnButtonRed(toBeDisabled);
        }
        else if(toBeDisabled.getText()=="P1"){
            turnButtonBlue(toBeDisabled);
        }
    }//changeVisualUnselected

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
    }//flipTurnWidget
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
    }//changeCounterNumber

    /*
    Below are all the basic functions that turn an input button into a specified visual
     */
    public void turnButtonWhite(Button InputButton){
        InputButton.setBackgroundResource(R.drawable.token_none);
    }//turnButtonWhite
    public void turnButtonBlue(Button InputButton){
        InputButton.setBackgroundResource(R.drawable.token_blue);
    }//turnButtonBlue
    public void turnButtonRed(Button InputButton){
        InputButton.setBackgroundResource(R.drawable.token_red);
    }//turnButtonRed

    //Below are used for when a piece needs to be highlighted for a move
    public void turnButtonHighlightBlue(Button availableButton){
        availableButton.setBackgroundResource(R.drawable.token_blue_selected);
    }//turnButtonHighlightBLue
    public void turnButtonHighlightRed(Button availableButton){
        availableButton.setBackgroundResource(R.drawable.token_red_selected);
    }//turnButtonHighlightRed
}