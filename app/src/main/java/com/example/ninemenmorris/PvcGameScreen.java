package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class PvcGameScreen extends AppCompatActivity {
    public int playerPieceOnHand = 9;
    public int playerPieceOnBoard = 0;
    public int computerPieceOnBoard = 0;
    public int computerPieceOnHand = 9;
    public int indexOfPlayerPieceToRemove = 0;
    Button[][] buttonArray = new Button[8][8];
    Button[] button00;
    Button[] button01;
    Button[] button02;
    Button[] button03;
    Button[] button04;
    Button[] button05;
    Button[] button06;
    Button[] button07;
    Button[] button10;
    Button[] button11;
    Button[] button12;
    Button[] button13;
    Button[] button14;
    Button[] button15;
    Button[] button16;
    Button[] button17;
    Button[] button20;
    Button[] button21;
    Button[] button22;
    Button[] button23;
    Button[] button24;
    Button[] button25;
    Button[] button26;
    Button[] button27;
    Button[][] allButtonsArray;
    Button[] allButtonOfBoard;
    Button[] playerPiecesArray = new Button[10];
    Button[] computerPiecesArray = new Button[10];
    String playerPiece;
    int numOfRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);

        MusicService.musicInitialize = 2;

        Button muted = (Button) findViewById(R.id.muted);
        Button unmuted = (Button) findViewById(R.id.unmuted);

        if (MusicService.getMuteStatus() == "muted"){
            muted.setVisibility(View.VISIBLE);
            unmuted.setVisibility(View.GONE);
            muted.bringToFront();
        }
        else if (MusicService.getMuteStatus() == "unmuted"){
            unmuted.setVisibility(View.VISIBLE);
            muted.setVisibility(View.GONE);
            unmuted.bringToFront();
        }
    }

    public void muteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        muted.setVisibility(View.VISIBLE);

        Button unmuted = (Button) findViewById(R.id.unmuted);
        unmuted.setVisibility(View.GONE);

        muted.bringToFront();

        MusicService.setMuteStatus("muted");

    }

    public void unMuteSound(View myView){
        Button muted = (Button) findViewById(R.id.muted);
        muted.setVisibility(View.GONE);

        Button unmuted = (Button) findViewById(R.id.unmuted);
        unmuted.setVisibility(View.VISIBLE);

        unmuted.bringToFront();

        MusicService.setMuteStatus("unmuted");


        playerPiece = "Player";
        numOfRd = 0;
        allButtonOnBoard(buttonArray);
        computerChoiceOnSecondPhase();
    }

    public void allButtonOnBoard(Button[][] gameBoard) {
        //outer board
        Button b00 = (Button) findViewById(R.id.button00);
        Button b01 = (Button) findViewById(R.id.button01);
        Button b02 = (Button) findViewById(R.id.button02);
        Button b03 = (Button) findViewById(R.id.button03);
        Button b04 = (Button) findViewById(R.id.button04);
        Button b05 = (Button) findViewById(R.id.button05);
        Button b06 = (Button) findViewById(R.id.button06);
        Button b07 = (Button) findViewById(R.id.button07);

        //middle board
        Button b10 = (Button) findViewById(R.id.button10);
        Button b11 = (Button) findViewById(R.id.button11);
        Button b12 = (Button) findViewById(R.id.button12);
        Button b13 = (Button) findViewById(R.id.button13);
        Button b14 = (Button) findViewById(R.id.button14);
        Button b15 = (Button) findViewById(R.id.button15);
        Button b16 = (Button) findViewById(R.id.button16);
        Button b17 = (Button) findViewById(R.id.button17);

        //inner board
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

    public void computerChoiceOnSecondPhase() {
        //outer square
        button00 = new Button[]{buttonArray[0][1], buttonArray[0][3]};
        button01 = new Button[]{buttonArray[0][0], buttonArray[1][1], buttonArray[0][2]};
        button02 = new Button[]{buttonArray[0][1], buttonArray[0][4]};
        button03 = new Button[]{buttonArray[0][0], buttonArray[0][5], buttonArray[1][3]};
        button04 = new Button[]{buttonArray[0][2], buttonArray[0][7], buttonArray[1][4]};
        button05 = new Button[]{buttonArray[0][3], buttonArray[0][6]};
        button06 = new Button[]{buttonArray[0][5], buttonArray[1][6], buttonArray[0][7]};
        button07 = new Button[]{buttonArray[0][4], buttonArray[0][6]};
        //middle square
        button10 = new Button[]{buttonArray[1][1], buttonArray[1][3]};
        button11 = new Button[]{buttonArray[1][0], buttonArray[1][2], buttonArray[0][1], buttonArray[2][1]};
        button12 = new Button[]{buttonArray[1][1], buttonArray[1][4]};
        button13 = new Button[]{buttonArray[1][0], buttonArray[1][5], buttonArray[0][3], buttonArray[2][3]};
        button14 = new Button[]{buttonArray[1][2], buttonArray[1][7], buttonArray[0][4], buttonArray[2][4]};
        button15 = new Button[]{buttonArray[1][3], buttonArray[1][6]};
        button16 = new Button[]{buttonArray[1][5], buttonArray[1][7], buttonArray[0][6], buttonArray[2][6]};
        button17 = new Button[]{buttonArray[1][4], buttonArray[1][6]};
        //inner sqaure
        button20 = new Button[]{buttonArray[2][1], buttonArray[2][3]};
        button21 = new Button[]{buttonArray[2][0], buttonArray[1][1], buttonArray[2][2]};
        button22 = new Button[]{buttonArray[2][1], buttonArray[2][4]};
        button23 = new Button[]{buttonArray[2][0], buttonArray[2][5], buttonArray[1][3]};
        button24 = new Button[]{buttonArray[2][2], buttonArray[2][7], buttonArray[1][4]};
        button25 = new Button[]{buttonArray[2][3], buttonArray[2][6]};
        button26 = new Button[]{buttonArray[2][5], buttonArray[2][7], buttonArray[1][6]};
        button27 = new Button[]{buttonArray[2][4], buttonArray[2][6]};
    }

    public void setAllButtonsArray() {
        allButtonsArray = new Button[][]{button00, button01, button02, button03,
                button04, button05, button06, button07, button10, button11, button12, button13,
                button14, button15, button16, button17, button20, button21, button22, button23,
                button24, button25, button26, button27};
    }
    public void setAllButtonInArray(){
        allButtonOfBoard = new Button[]{buttonArray[0][0], buttonArray[0][1],buttonArray[0][2],
                buttonArray[0][3],buttonArray[0][4],buttonArray[0][5],buttonArray[0][6],buttonArray[0][7]
                ,buttonArray[1][0],buttonArray[1][1],buttonArray[1][2],buttonArray[1][3],
                buttonArray[1][4],buttonArray[1][5],buttonArray[1][6] ,
                buttonArray[2][0],buttonArray[2][1],buttonArray[2][2],buttonArray[2][3],
                buttonArray[2][4],buttonArray[2][5],buttonArray[2][6],buttonArray[2][7]};
    }
    public void playerOrComputer(View myView) {
        numOfRd++;
        Button playerMove = (Button) myView;
        if (playerPieceOnHand > 0) {
            if (playerPiece.equals("Player")) {
                playerTurn(playerMove);
                playerPiece = "Computer";
                if (isMill("P", playerMove)) {
                    disableAllButtons();
                    enableComputerMove();
                    playerPiece = "Remover";
                }
            } else if (playerPiece.equals("Remover")) {
                removeIfMill(playerMove);
                enableAllButtons(buttonArray);
                disableComputerMove();
                disablePlayerMove();
                playerPiece = "Computer";
            }


            if (playerPiece.equals("Computer")) {
                Button compButtonCrossLines = getComputerButtonCrossLines();
                Button compButtonVert = getComputerButtonVert();
                Button compButtonHort = getComputerButtonHort();
                computerTurn();
                playerPiece = "Player";
                if (isMillComp("C", compButtonCrossLines, compButtonHort, compButtonVert)) {
                    removePlayerPiece();
                }// if
            }
        }


        if (playerPieceOnHand <= 0 && !playerPiece.equals("Third Phase")) {
            if (playerPiece.equals("Command")) {
                playerPiece = "null";
            }
            if (playerPiece.equals("null")) {
                playerPiece = "Command";
                return;
            }
            if (!playerPiece.equals("Remover")) {
                disableAllButtons();
                enableAllPlayerPieces();
            }
            if (playerMove.getText() == "P") {
                enableAdjacentButtons(playerMove);
                removePlayerPieceWhenMoving(playerMove);
                return;
            } else {
                if (!playerPiece.equals("Remover")) {
                    movePlayerPiece(playerMove);
                }
            }
            if (playerPiece.equals("Player")) {
                playerPiece = "Computer";
                if (isMill("P", playerMove)) {
                    disableAllButtons();
                    enableComputerMove();
                    playerPiece = "Remover";
                    return;
                }
            } else if (playerPiece.equals("Remover")) {
                removeIfMill(playerMove);
                disableAllButtons();
                enableAllPlayerPieces();
                playerPiece = "Computer";
                return;
            }


            if (playerPiece.equals("Computer")) {
                Button compButtonCrossLines = getComputerButtonCrossLines();
                Button compButtonVert = getComputerButtonVert();
                Button compButtonHort = getComputerButtonHort();
                cpuSecondPhaseMove();
                playerPiece = "Player";
                if (isMillComp("C", compButtonCrossLines, compButtonHort, compButtonVert)) {
                    removePlayerPiece();
                }
            }

        }
        if(numOfPlayerPieces()==3 || numOfComputerPieces()==3){
            playerPiece= "Third Phase";

        }


    }

    public Boolean isMill(String whichPiece, Button button) {
        if (isMillCrossLines(whichPiece, button)
                || isMillHorizontal(whichPiece, button)
                || isMillVertical(whichPiece, button)) {
            return true;
        }
        return false;
    }

    public Boolean isMillComp(String whichPiece, Button crossLineButton, Button hortButton,
                              Button vertButton) {
        if (isMillCrossLines(whichPiece, crossLineButton)
                || isMillHorizontal(whichPiece, hortButton)
                || isMillVertical(whichPiece, vertButton)) {
            return true;
        }
        return false;
    }

    public void playerTurn(Button playerMove) {
        if (playerPieceOnHand > 0) {
            playerMove.setText("P");
            turnButtonBlue(playerMove);
            flipTurnWidget(0);
            playerMove.setEnabled(false);
            playerPiecesArray[9 - playerPieceOnHand] = playerMove;
            if (playerPieceOnHand > 0) {
                playerPieceOnHand--;
            }
            if (playerPieceOnBoard < 9) {
                playerPieceOnBoard++;
            }
        }
    }//player1Turn

    public void computerTurn() {
        if (numOfRd == 1) {
            firstComputerTurn();
        }
        //Block opponent trying to make a mill. 1 Priority
        else if (isBlockOrMillVert("P") || isBlockOrMillHort("P") ||
                isBlockOrMillCrossLines("P")) {
            if (isBlockOrMillVert("P")) {
                blockOrMillVert("P");
            } else if (isBlockOrMillHort("P")) {
                blockOrMillHort("P");
            } else if (isBlockOrMillCrossLines("P")) {
                blockOrMillCrossLines("P");
            }
        }
        //Making a mill. 2 priority
        else if (isBlockOrMillVert("C") || isBlockOrMillHort("C") ||
                isBlockOrMillCrossLines("C")) {
            if (isBlockOrMillVert("C")) {
                blockOrMillVert("C");
            } else if (isBlockOrMillHort("C")) {
                blockOrMillHort("C");
            } else if (isBlockOrMillCrossLines("C")) {
                blockOrMillCrossLines("C");
            }
            //Trying to make a mill . 3 priority
        } else if (isTryingToMakeMillCorners() || isTryingToMakeMillMiddleHorizontal()
                || isTryingToMakeMillMiddleVertical() || isTryingToMakeMillCrossLines()) {
            if (isTryingToMakeMillMiddleHorizontal()) {
                tryingToMakeMillMiddleHorizontal();
            } else if (isTryingToMakeMillMiddleVertical()) {
                tryingToMakeMillMiddleVertical();
            } else if (isTryingToMakeMillCorners()) {
                tryingToMakeMillCorners();
            } else if (isTryingToMakeMillCrossLines()) {
                tryingToMakeMillCrossLines();
            }
        } else if (ajacentToPlayerPiece() != null) {
            ajacentToPlayerPiece().setEnabled(false);
            ajacentToPlayerPiece().setText("C");
        }
    }

    public void disableAllButtons() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                buttonArray[i][j].setEnabled(false);
                changeVisualUnselected(buttonArray[i][j]);
            }
        }
    }//disableAllButtons

    public int countNumberOfComputerPieces() {
        int numOfCompPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C") {
                    numOfCompPieces++;
                }
            }
        }
        return numOfCompPieces;
    }//countNumberOfComputerPieces

    public void enableAllPlayerPieces() {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i].getText() != null) {
                playerPiecesArray[i].setEnabled(true);
                changeVisualSelected(playerPiecesArray[i]);
            }
        }
    }//enableAllPlayerPieces

    public void disableAllPlayerPieces() {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i].getText() != null) {
                playerPiecesArray[i].setEnabled(false);
                changeVisualUnselected(playerPiecesArray[i]);
            }
        }
    }//disableAllPlayerPieces

    public void enableAllButtons(Button[][] gameBoard) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                gameBoard[i][j].setEnabled(true);
                changeVisualSelected(gameBoard[i][j]);
            }
        }
    }//enableAllButtons

    public void firstComputerTurn() {
        int[] numberArray = {0, 2, 5, 7};
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        int cpuFirstPosition = numberArray[randomNumber];
        while (buttonArray[0][cpuFirstPosition].getText() == "P") {
            randomNumber = random.nextInt(4);
            cpuFirstPosition = numberArray[randomNumber];
        }
        buttonArray[0][cpuFirstPosition].setText("C");
        turnButtonRed(buttonArray[0][cpuFirstPosition]);
        buttonArray[0][cpuFirstPosition].setEnabled(false);

    }//firstComputerTurn

    public int numOfPlayerPieces() {
        int numberOfPlayerPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == ("P")) {
                    numberOfPlayerPieces += 1;
                }//if
            }//inner for loop
        }// outer for loop
        return numberOfPlayerPieces;
    }//numOfPlayerPieces

    public int numOfComputerPieces() {
        int numberOfComputerPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == ("P")) {
                    numberOfComputerPieces += 1;
                }//if
            }//inner for loop
        }// outer for loop
        return numberOfComputerPieces;
    }//numOfComputerPieces

    public boolean isTryingToMakeMillMiddleHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    return true;
                } else if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    return true;
                }
            }// top of the squares
            if (buttonArray[i][6].getText() == "C") {
                if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    return true;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    return true;
                }
            }//bottom of the squares
        }//for loop
        return false;
    }//isTryingToMakeMillMiddleHorizontal

    public void tryingToMakeMillMiddleHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    buttonArray[i][0].setText("C");
                    turnButtonRed(buttonArray[i][0]);
                    buttonArray[i][0].setEnabled(false);
                    return;
                } else if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    buttonArray[i][2].setText("C");
                    turnButtonRed(buttonArray[i][2]);
                    buttonArray[i][2].setEnabled(false);
                    return;
                }
            }// top of the squares
            if (buttonArray[i][6].getText() == "C") {
                if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    buttonArray[i][5].setText("C");
                    turnButtonRed(buttonArray[i][5]);
                    buttonArray[i][5].setEnabled(false);
                    return;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    buttonArray[i][7].setText("C");
                    turnButtonRed(buttonArray[i][7]);
                    buttonArray[i][7].setEnabled(false);
                    return;
                }
            }// bottom of the squares
        }//for loop
    }//tryingToMakeMillMiddleHorizontal

    public boolean isTryingToMakeMillMiddleVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][3].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    return true;
                } else if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    return true;
                }
            }//left of the squares
            if (buttonArray[i][4].getText() == "C") {
                if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    return true;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    return true;
                }
            }// right of the squares
        }// for loop
        return false;
    }//isTryingToMakeMillMiddleVertical

    public void tryingToMakeMillMiddleVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][3].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    buttonArray[i][0].setText("C");
                    turnButtonRed(buttonArray[i][0]);
                    buttonArray[i][0].setEnabled(false);
                    return;
                } else if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    buttonArray[i][5].setText("C");
                    turnButtonRed(buttonArray[i][5]);
                    buttonArray[i][5].setEnabled(false);
                    return;
                }
            }// left of the squares
            if (buttonArray[i][4].getText() == "C") {
                if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    buttonArray[i][2].setText("C");
                    turnButtonRed(buttonArray[i][2]);
                    buttonArray[i][2].setEnabled(false);
                    return;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    buttonArray[i][7].setText("C");
                    turnButtonRed(buttonArray[i][7]);
                    buttonArray[i][7].setEnabled(false);
                    return;
                }
            }// right of the squares
        }// for loop
    }// tryingToMakeMillMiddleVertical

    public boolean isTryingToMakeMillCorners() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    return true;
                } else if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    return true;
                }
            }// top left corner
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    return true;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    return true;
                }
            }// top right corner
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    return true;
                } else if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    return true;
                }
            }//bottom left corner
            if (buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    return true;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    return true;
                }
            }// bottom right corner
        }// for loop
        return false;
    }//isTryingToMakeMillCorners

    public void tryingToMakeMillCorners() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    buttonArray[i][1].setText("C");
                    turnButtonRed(buttonArray[i][1]);
                    buttonArray[i][1].setEnabled(false);
                    return;
                } else if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    buttonArray[i][3].setText("C");
                    turnButtonRed(buttonArray[i][3]);
                    buttonArray[i][3].setEnabled(false);
                    return;
                }//top left corner
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    buttonArray[i][1].setText("C");
                    turnButtonRed(buttonArray[i][1]);
                    buttonArray[i][1].setEnabled(false);
                    return;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    buttonArray[i][4].setText("C");
                    turnButtonRed(buttonArray[i][4]);
                    buttonArray[i][4].setEnabled(false);
                    return;
                }
            }// top right corner
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    buttonArray[i][3].setText("C");
                    turnButtonRed(buttonArray[i][3]);
                    buttonArray[i][3].setEnabled(false);
                    return;
                } else if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    buttonArray[i][6].setText("C");
                    turnButtonRed(buttonArray[i][6]);
                    buttonArray[i][6].setEnabled(false);
                    return;
                }
            }//top left corner
            if (buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    buttonArray[i][6].setText("C");
                    turnButtonRed(buttonArray[i][6]);
                    buttonArray[i][6].setEnabled(false);
                    return;

                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    buttonArray[i][4].setText("C");
                    turnButtonRed(buttonArray[i][4]);
                    buttonArray[i][4].setEnabled(false);
                    return;
                }
            }
        }// for loop
    }//tryingToMakeMillCorners

    public boolean isTryingToMakeMillCrossLines() {
        int[] numberArray = {1, 3, 4, 6, -1};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == "C") {
                if (buttonArray[1][numbersInList].getText() != "C" &&
                        buttonArray[1][numbersInList].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[1][numbersInList].getText() == "C") {
                if (buttonArray[0][numbersInList].getText() != "C" &&
                        buttonArray[0][numbersInList].getText() != "P") {
                    return true;
                } else if (buttonArray[2][numbersInList].getText() != "C" &&
                        buttonArray[2][numbersInList].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[2][numbersInList].getText() == "C") {
                if (buttonArray[1][numbersInList].getText() != "C" &&
                        buttonArray[1][numbersInList].getText() != "P") {
                    return true;
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }// end While loop
        return false;
    }//isTryingToMakeMillCrossLines

    public void tryingToMakeMillCrossLines() {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == "C") {
                if (buttonArray[1][numbersInList].getText() != "C" &&
                        buttonArray[1][numbersInList].getText() != "P") {
                    buttonArray[1][numbersInList].setText("C");
                    turnButtonRed(buttonArray[1][numbersInList]);
                    buttonArray[1][numbersInList].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[1][numbersInList].getText() == "C") {
                if (buttonArray[0][numbersInList].getText() != "C" &&
                        buttonArray[0][numbersInList].getText() != "P") {
                    buttonArray[0][numbersInList].setText("C");
                    turnButtonRed(buttonArray[0][numbersInList]);
                    buttonArray[0][numbersInList].setEnabled(false);
                    return;
                } else if (buttonArray[2][numbersInList].getText() != "C" &&
                        buttonArray[2][numbersInList].getText() != "P") {
                    buttonArray[2][numbersInList].setText("C");
                    turnButtonRed(buttonArray[2][numbersInList]);
                    buttonArray[2][numbersInList].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[2][numbersInList].getText() == "C") {
                if (buttonArray[1][numbersInList].getText() != "C" &&
                        buttonArray[1][numbersInList].getText() != "P") {
                    buttonArray[1][numbersInList].setText("C");
                    turnButtonRed(buttonArray[1][numbersInList]);
                    buttonArray[1][numbersInList].setEnabled(false);
                    return;
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }// end While loop
    }//TryingToMakeMillCrossLines

    public void disableComputerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C") {
                    buttonArray[i][j].setEnabled(false);
                    changeVisualUnselected(buttonArray[i][j]);
                }
            }//inner for loop
        }//outer for loop
    }//disableComputerMove

    public void removePlayerPiece() {
        //check vertical lines
        if (isBlockOrMillVert("P")) {
            removePlayerPieceIfTryingToMakeMillVert("P");
        }
        //check crosslines
        else if (isBlockOrMillCrossLines("P")) {
            removePlayerPieceIfTryingToMakeMillCrossLines("P");
        }
        //check horizontal lines
        else if (isBlockOrMillHort("P")) {
            removePlayerPieceIfTryingToMakeMillHort("P");
        } else {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (buttonArray[i][j].getText() == "P") {
                        buttonArray[i][j].setText(null);
                        turnButtonWhite(buttonArray[i][j]);
                        return;
                    }
                }
            }
        }
    }//removePlayerPiece

    public void removePlayerPieceIfTryingToMakeMillVert(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                buttonArray[i][2].setText(null);
                turnButtonWhite(buttonArray[i][2]);
                return;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                buttonArray[i][1].setText(null);
                turnButtonWhite(buttonArray[i][1]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                buttonArray[i][0].setText(null);
                turnButtonWhite(buttonArray[i][0]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                buttonArray[i][1].setText(null);
                turnButtonWhite(buttonArray[i][1]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                buttonArray[i][7].setText(null);
                turnButtonWhite(buttonArray[i][7]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                buttonArray[i][6].setText(null);
                turnButtonWhite(buttonArray[i][6]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                buttonArray[i][5].setText(null);
                turnButtonWhite(buttonArray[i][5]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                buttonArray[i][6].setText(null);
                turnButtonWhite(buttonArray[i][6]);
                return;
            }
        }
    }//removePlayerPieceIfTryingToMakeMillVert

    public void removePlayerPieceIfTryingToMakeMillHort(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                buttonArray[i][5].setText(null);
                turnButtonWhite(buttonArray[i][5]);
                return;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                buttonArray[i][3].setText(null);
                turnButtonWhite(buttonArray[i][3]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                buttonArray[i][0].setText(null);
                turnButtonWhite(buttonArray[i][0]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                buttonArray[i][3].setText(null);
                turnButtonWhite(buttonArray[i][3]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                buttonArray[i][7].setText(null);
                turnButtonWhite(buttonArray[i][7]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                buttonArray[i][4].setText(null);
                turnButtonWhite(buttonArray[i][4]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                buttonArray[i][2].setText(null);
                turnButtonWhite(buttonArray[i][2]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                buttonArray[i][4].setText(null);
                turnButtonWhite(buttonArray[i][4]);
                return;
            }
        }
    }//removePlayerPieceIfTryingToMakeMillHort

    public void removePlayerPieceIfTryingToMakeMillCrossLines(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[2][numbersInList].getText() != "C" && buttonArray[2][numbersInList].getText() != "P") {
                buttonArray[2][numbersInList].setText(null);
                turnButtonWhite(buttonArray[2][numbersInList]);
                return;
            }
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[2][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                buttonArray[1][numbersInList].setText(null);
                turnButtonWhite(buttonArray[1][numbersInList]);
                return;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[0][numbersInList].getText() != "C" && buttonArray[0][numbersInList].getText() != "P") {
                buttonArray[0][numbersInList].setText(null);
                turnButtonWhite(buttonArray[0][numbersInList]);
                return;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[0][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                buttonArray[1][numbersInList].setText(null);
                turnButtonWhite(buttonArray[1][numbersInList]);
                return;
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }//removePlayerPieceIfTryingToMakeMillCrossLines

    public void enableComputerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C") {
                    buttonArray[i][j].setEnabled(true);
                    changeVisualSelected(buttonArray[i][j]);
                }
            }
        }
    }//enableComputerMove

    public void enablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "P") {
                    buttonArray[i][j].setEnabled(true);
                    changeVisualSelected(buttonArray[i][j]);
                }
            }
        }
    }//enablePlayerMove

    public void disablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "P") {
                    buttonArray[i][j].setEnabled(false);
                    changeVisualUnselected(buttonArray[i][j]);
                }
            }
        }
    }//disablePlayerMove

    public void removeIfMill(Button removedButton) {
        removedButton.setText(null);
        turnButtonWhite(removedButton);
        removedButton.setEnabled(false);
        changeVisualUnselected(removedButton);
    }//removeIfMill

    public void removePlayerPieceWhenMoving(Button playerMove) {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i] == playerMove) {
                indexOfPlayerPieceToRemove = i;
                return;
            }
        }
    }//removePlayerPieceWhenMoving

    public void movePlayerPiece(Button playerMove) {
        if (playerMove.getText() != "P" && playerMove.getText() != "C") {
            playerMove.setText("P");
            turnButtonBlue(playerMove);
            playerPiecesArray[indexOfPlayerPieceToRemove].setText(null);
            turnButtonWhite(playerPiecesArray[indexOfPlayerPieceToRemove]);
            playerPiecesArray[indexOfPlayerPieceToRemove] = playerMove;
            playerPiecesArray[indexOfPlayerPieceToRemove].setEnabled(true);
            changeVisualSelected(playerPiecesArray[indexOfPlayerPieceToRemove]);
        }
    }//movePlayerPiece

    public void enableAdjacentButtons(Button playerMove) {
        if (playerMove == buttonArray[0][0]) {
            for (int i = 0; i < button00.length; i++) {
                if ((button00[i].getText() != "C") && (button00[i].getText() != "P")) {
                    button00[i].setEnabled(true);
                    changeVisualSelected(button00[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][1]) {
            for (int i = 0; i < button01.length; i++) {
                if ((button01[i].getText() != "C") && (button01[i].getText() != "P")) {
                    button01[i].setEnabled(true);
                    changeVisualSelected(button01[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][2]) {
            for (int i = 0; i < button02.length; i++) {
                if ((button02[i].getText() != "C") && (button02[i].getText() != "P")) {
                    button02[i].setEnabled(true);
                    changeVisualSelected(button02[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][3]) {
            for (int i = 0; i < button03.length; i++) {
                if ((button03[i].getText() != "C") && (button03[i].getText() != "P")) {
                    button03[i].setEnabled(true);
                    changeVisualSelected(button03[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][4]) {
            for (int i = 0; i < button04.length; i++) {
                if ((button04[i].getText() != "C") && (button04[i].getText() != "P")) {
                    button04[i].setEnabled(true);
                    changeVisualSelected(button04[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][5]) {
            for (int i = 0; i < button05.length; i++) {
                if ((button05[i].getText() != "C") && (button05[i].getText() != "P")) {
                    button05[i].setEnabled(true);
                    changeVisualSelected(button05[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][6]) {
            for (int i = 0; i < button06.length; i++) {
                if ((button06[i].getText() != "C") && (button06[i].getText() != "P")) {
                    button06[i].setEnabled(true);
                    changeVisualSelected(button06[i]);
                }
            }
        }
        if (playerMove == buttonArray[0][7]) {
            for (int i = 0; i < button07.length; i++) {
                if ((button07[i].getText() != "C") && (button07[i].getText() != "P")) {
                    button07[i].setEnabled(true);
                    changeVisualSelected(button07[i]);
                }
            }
        }

        //If the chosen button is in the second square
        if (playerMove == buttonArray[1][0]) {
            for (int i = 0; i < button10.length; i++) {
                if ((button10[i].getText() != "C") && (button10[i].getText() != "P")) {
                    button10[i].setEnabled(true);
                    changeVisualSelected(button10[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][1]) {
            for (int i = 0; i < button11.length; i++) {
                if ((button11[i].getText() != "C") && (button11[i].getText() != "P")) {
                    button11[i].setEnabled(true);
                    changeVisualSelected(button11[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][2]) {
            for (int i = 0; i < button12.length; i++) {
                if ((button12[i].getText() != "C") && (button12[i].getText() != "P")) {
                    button12[i].setEnabled(true);
                    changeVisualSelected(button12[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][3]) {
            for (int i = 0; i < button13.length; i++) {
                if ((button13[i].getText() != "C") && (button13[i].getText() != "P")) {
                    button13[i].setEnabled(true);
                    changeVisualSelected(button13[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][4]) {
            for (int i = 0; i < button14.length; i++) {
                if ((button14[i].getText() != "C") && (button14[i].getText() != "P")) {
                    button14[i].setEnabled(true);
                    changeVisualSelected(button14[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][5]) {
            for (int i = 0; i < button15.length; i++) {
                if ((button15[i].getText() != "C") && (button15[i].getText() != "P")) {
                    button15[i].setEnabled(true);
                    changeVisualSelected(button15[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][6]) {
            for (int i = 0; i < button16.length; i++) {
                if ((button16[i].getText() != "C") && (button16[i].getText() != "P")) {
                    button16[i].setEnabled(true);
                    changeVisualSelected(button16[i]);
                }
            }
        }
        if (playerMove == buttonArray[1][7]) {
            for (int i = 0; i < button17.length; i++) {
                if ((button17[i].getText() != "C") && (button17[i].getText() != "P")) {
                    button17[i].setEnabled(true);
                    changeVisualSelected(button17[i]);
                }
            }
        }

        //If the chosen button is in the third square
        if (playerMove == buttonArray[2][0]) {
            for (int i = 0; i < button20.length; i++) {
                if ((button20[i].getText() != "C") && (button20[i].getText() != "P")) {
                    button20[i].setEnabled(true);
                    changeVisualSelected(button20[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][1]) {
            for (int i = 0; i < button21.length; i++) {
                if ((button21[i].getText() != "C") && (button21[i].getText() != "P")) {
                    button21[i].setEnabled(true);
                    changeVisualSelected(button21[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][2]) {
            for (int i = 0; i < button22.length; i++) {
                if ((button22[i].getText() != "C") && (button22[i].getText() != "P")) {
                    button22[i].setEnabled(true);
                    changeVisualSelected(button22[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][3]) {
            for (int i = 0; i < button23.length; i++) {
                if ((button23[i].getText() != "C") && (button23[i].getText() != "P")) {
                    button23[i].setEnabled(true);
                    changeVisualSelected(button23[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][4]) {
            for (int i = 0; i < button24.length; i++) {
                if ((button24[i].getText() != "C") && (button24[i].getText() != "P")) {
                    button24[i].setEnabled(true);
                    changeVisualSelected(button24[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][5]) {
            for (int i = 0; i < button25.length; i++) {
                if ((button25[i].getText() != "C") && (button25[i].getText() != "P")) {
                    button25[i].setEnabled(true);
                    changeVisualSelected(button25[i]);
                }
            }
        }
        if (playerMove == buttonArray[2][6]) {
            for (int i = 0; i < button26.length; i++) {
                if ((button26[i].getText() != "C") && (button26[i].getText() != "P")) {
                    button26[i].setEnabled(true);
                    changeVisualSelected(button26[i]);
                }
            }
        }

        if (playerMove == buttonArray[2][7]) {
            for (int i = 0; i < button27.length; i++) {
                if ((button27[i].getText() != "C") && (button27[i].getText() != "P")) {
                    button27[i].setEnabled(true);
                    changeVisualSelected(button27[i]);
                }
            }
        }
    }

    private Button returnEnableAdjacentButtons(Button playerMove) {
        if (playerMove == buttonArray[0][0]) {
            for (int i = 0; i < button00.length; i++) {
                if ((button00[i].getText() != "C") && (button00[i].getText() != "P")) {
                    return button00[i];
                }
            }
        }
        if (playerMove == buttonArray[0][1]) {
            for (int i = 0; i < button01.length; i++) {
                if ((button01[i].getText() != "C") && (button01[i].getText() != "P")) {
                    return button01[i];
                }
            }
        }
        if (playerMove == buttonArray[0][2]) {
            for (int i = 0; i < button02.length; i++) {
                if ((button02[i].getText() != "C") && (button02[i].getText() != "P")) {
                    return button02[i];
                }
            }
        }
        if (playerMove == buttonArray[0][3]) {
            for (int i = 0; i < button03.length; i++) {
                if ((button03[i].getText() != "C") && (button03[i].getText() != "P")) {
                    return button03[i];
                }
            }
        }
        if (playerMove == buttonArray[0][4]) {
            for (int i = 0; i < button04.length; i++) {
                if ((button04[i].getText() != "C") && (button04[i].getText() != "P")) {
                    return button04[i];
                }
            }
        }
        if (playerMove == buttonArray[0][5]) {
            for (int i = 0; i < button05.length; i++) {
                if ((button05[i].getText() != "C") && (button05[i].getText() != "P")) {
                    return button05[i];
                }
            }
        }
        if (playerMove == buttonArray[0][6]) {
            for (int i = 0; i < button06.length; i++) {
                if ((button06[i].getText() != "C") && (button06[i].getText() != "P")) {
                    return button06[i];
                }
            }
        }
        if (playerMove == buttonArray[0][7]) {
            for (int i = 0; i < button07.length; i++) {
                if ((button07[i].getText() != "C") && (button07[i].getText() != "P")) {
                    return button07[i];
                }
            }
        }

        //If the chosen button is in the second square
        if (playerMove == buttonArray[1][0]) {
            for (int i = 0; i < button10.length; i++) {
                if ((button10[i].getText() != "C") && (button10[i].getText() != "P")) {
                    return button10[i];
                }
            }
        }
        if (playerMove == buttonArray[1][1]) {
            for (int i = 0; i < button11.length; i++) {
                if ((button11[i].getText() != "C") && (button11[i].getText() != "P")) {
                    return button11[i];
                }
            }
        }
        if (playerMove == buttonArray[1][2]) {
            for (int i = 0; i < button12.length; i++) {
                if ((button12[i].getText() != "C") && (button12[i].getText() != "P")) {
                    return button12[i];
                }
            }
        }
        if (playerMove == buttonArray[1][3]) {
            for (int i = 0; i < button13.length; i++) {
                if ((button13[i].getText() != "C") && (button13[i].getText() != "P")) {
                    return button13[i];
                }
            }
        }
        if (playerMove == buttonArray[1][4]) {
            for (int i = 0; i < button14.length; i++) {
                if ((button14[i].getText() != "C") && (button14[i].getText() != "P")) {
                    return button14[i];
                }
            }
        }
        if (playerMove == buttonArray[1][5]) {
            for (int i = 0; i < button15.length; i++) {
                if ((button15[i].getText() != "C") && (button15[i].getText() != "P")) {
                    return button15[i];
                }
            }
        }
        if (playerMove == buttonArray[1][6]) {
            for (int i = 0; i < button16.length; i++) {
                if ((button16[i].getText() != "C") && (button16[i].getText() != "P")) {
                    return button16[i];
                }
            }
        }
        if (playerMove == buttonArray[1][7]) {
            for (int i = 0; i < button17.length; i++) {
                if ((button17[i].getText() != "C") && (button17[i].getText() != "P")) {
                    return button17[i];
                }
            }
        }

        //If the chosen button is in the third square
        if (playerMove == buttonArray[2][0]) {
            for (int i = 0; i < button20.length; i++) {
                if ((button20[i].getText() != "C") && (button20[i].getText() != "P")) {
                    return button20[i];
                }
            }
        }
        if (playerMove == buttonArray[2][1]) {
            for (int i = 0; i < button21.length; i++) {
                if ((button21[i].getText() != "C") && (button21[i].getText() != "P")) {
                    return button21[i];
                }
            }
        }
        if (playerMove == buttonArray[2][2]) {
            for (int i = 0; i < button22.length; i++) {
                if ((button22[i].getText() != "C") && (button22[i].getText() != "P")) {
                    return button22[i];
                }
            }
        }
        if (playerMove == buttonArray[2][3]) {
            for (int i = 0; i < button23.length; i++) {
                if ((button23[i].getText() != "C") && (button23[i].getText() != "P")) {
                    return button23[i];
                }
            }
        }
        if (playerMove == buttonArray[2][4]) {
            for (int i = 0; i < button24.length; i++) {
                if ((button24[i].getText() != "C") && (button24[i].getText() != "P")) {
                    return button24[i];
                }
            }
        }
        if (playerMove == buttonArray[2][5]) {
            for (int i = 0; i < button25.length; i++) {
                if ((button25[i].getText() != "C") && (button25[i].getText() != "P")) {
                    return button25[i];
                }
            }
        }
        if (playerMove == buttonArray[2][6]) {
            for (int i = 0; i < button26.length; i++) {
                if ((button26[i].getText() != "C") && (button26[i].getText() != "P")) {
                    return button26[i];
                }
            }
        }

        if (playerMove == buttonArray[2][7]) {
            for (int i = 0; i < button27.length; i++) {
                if ((button27[i].getText() != "C") && (button27[i].getText() != "P")) {
                    return button27[i];
                }
            }
        }
        return null;
    }

    public Button generateRandomButtonsForCompTurn() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][j]) != null) {
                    return buttonArray[i][j];
                }
            }// inner for loop
        }// outer for loop
        return null;
    }//generateRandomButtonsForCompTurn

    public void cpuSecondPhaseMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (returnMillSecondPhaseVertButton("P") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseVertButton("P"))) {
                    returnMillSecondPhaseVertButton("P").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                } else if (returnMillSecondPhaseHortButton("P") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseHortButton("C"))) {
                    returnMillSecondPhaseHortButton("C").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
                else if (returnMillSecondPhaseCrossLinesButton("P") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseCrossLinesButton("P"))) {
                    returnMillSecondPhaseCrossLinesButton("P").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
                else  if (returnMillSecondPhaseVertButton("C") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseVertButton("C"))) {
                    returnMillSecondPhaseVertButton("C").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                } else if (returnMillSecondPhaseHortButton("C") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseHortButton("C"))) {
                    returnMillSecondPhaseHortButton("C").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
                else if (returnMillSecondPhaseCrossLinesButton("C") != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == returnMillSecondPhaseCrossLinesButton("C"))) {
                    returnMillSecondPhaseCrossLinesButton("C").setText("C");
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
                //mill method
                else if (returnEnableAdjacentButtons(ifMillSecondPhaseReturnAdjacentButtons()) != null) {
                    returnEnableAdjacentButtons(ifMillSecondPhaseReturnAdjacentButtons()).setText("C");
                    ifMillSecondPhase().setText(null);
                    turnButtonWhite(ifMillSecondPhase());
                    return;
                }
                else if (returnEnableAdjacentButtons(ifMillSecondPhaseCrossLinesReturnAdjacentButtons()) != null) {
                    returnEnableAdjacentButtons(ifMillSecondPhaseCrossLinesReturnAdjacentButtons()).setText("C");
                    ifMillSecondPhaseCrossLines().setText(null);
                    turnButtonWhite(ifMillSecondPhaseCrossLines());
                    return;
                }
                else if (tryingToMakeAMillSecondPhrase() != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == tryingToMakeAMillSecondPhrase())) {
                    tryingToMakeAMillSecondPhrase().setText("C");
                    turnButtonWhite(tryingToMakeAMillSecondPhrase());
                    tryingToMakeAMillSecondPhrase().setEnabled(false);
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
                else {
                    cpuMakeRandomMove();
                    return;
                }
            }
        }
    }// cpuSecondPhaseMove

    ///////////////////////////////// NEWWWW PART //////////////////////////////

    public void cpuTryToMakeAMill(){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (tryingToMakeAMillSecondPhrase() != null && buttonArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonArray[i][j]) == tryingToMakeAMillSecondPhrase())) {
                    tryingToMakeAMillSecondPhrase().setText("C");
                    turnButtonRed(tryingToMakeAMillSecondPhrase());
                    tryingToMakeAMillSecondPhrase().setEnabled(false);
                    buttonArray[i][j].setText(null);
                    turnButtonWhite(buttonArray[i][j]);
                    return;
                }
            }
        }
    }
    public void cpuMakeRandomMove(){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][j]) != null) {
                    returnEnableAdjacentButtons(buttonArray[i][j]).setText("C");
                    if (buttonArray[i][j].getText() == "C") {
                        buttonArray[i][j].setText(null);
                        turnButtonWhite(buttonArray[i][j]);
                        return;
                    }
                }
            }
        }
    }

    public Button returnComputerEnabledSpot(Button compMove) {
        return returnEnableAdjacentButtons(compMove);
    }

    public boolean isMillVertical(String playerOrComputerPiece, Button playerMove) {
        for (int i = 0; i <= 2; i++) {
            if (playerMove == buttonArray[i][0] ||
                    playerMove == buttonArray[i][1] || playerMove == buttonArray[i][2]) {
                if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if (playerMove == buttonArray[i][7] ||
                    playerMove == buttonArray[i][6] || playerMove == buttonArray[i][5]) {
                if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
        }//for loop
        return false;
    }//isMillVertical

    public boolean isMillHorizontal(String playerOrComputerPiece, Button playerMove) {
        for (int i = 0; i <= 2; i++) {
            if (playerMove == buttonArray[i][0] || playerMove == buttonArray[i][3] ||
                    playerMove == buttonArray[i][5]) {
                if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if (playerMove == buttonArray[i][2] || playerMove == buttonArray[i][4]
                    || playerMove == buttonArray[i][7]) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
        }//for loop
        return false;
    }//isMillHorizontal

    public boolean isMillCrossLines(String playerOrComputerPiece, Button playerMove) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (playerMove == buttonArray[0][numbersInList] || playerMove == buttonArray[1]
                    [numbersInList] || playerMove == buttonArray[2][numbersInList]) {
                if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                        if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return false;
    }//isMillCrossLines
    /////////////////////////////  computer

    public Button getComputerButtonVert() {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][1].getText() == "C" &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                return buttonArray[i][2];
            }
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][2].getText() == "C" &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                return buttonArray[i][1];
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][1].getText() == "C" &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                return buttonArray[i][0];
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][0].getText() == "C" &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                return buttonArray[i][1];
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][6].getText() == "C" &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                return buttonArray[i][7];
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][7].getText() == "C" &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                return buttonArray[i][6];
            }
            if (buttonArray[i][7].getText() == "C" && buttonArray[i][6].getText() == "C" &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                return buttonArray[i][5];
            }
            if (buttonArray[i][7].getText() == "C" && buttonArray[i][5].getText() == "C" &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                return buttonArray[i][6];
            }
        }
        return null;
    }//getComputerButtonVert

    public void blockOrMillVert(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                buttonArray[i][2].setText("C");
                turnButtonRed(buttonArray[i][2]);
                buttonArray[i][2].setEnabled(false);
                changeVisualUnselected(buttonArray[i][2]);
                return;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                buttonArray[i][1].setText("C");
                turnButtonRed(buttonArray[i][1]);
                buttonArray[i][1].setEnabled(false);
                changeVisualUnselected(buttonArray[i][1]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                buttonArray[i][0].setText("C");
                turnButtonRed(buttonArray[i][0]);
                buttonArray[i][0].setEnabled(false);
                changeVisualUnselected(buttonArray[i][0]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                buttonArray[i][1].setText("C");
                turnButtonRed(buttonArray[i][1]);
                buttonArray[i][1].setEnabled(false);
                changeVisualUnselected(buttonArray[i][1]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                buttonArray[i][7].setText("C");
                turnButtonRed(buttonArray[i][7]);
                buttonArray[i][7].setEnabled(false);
                changeVisualUnselected(buttonArray[i][7]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                buttonArray[i][6].setText("C");
                turnButtonRed(buttonArray[i][6]);
                buttonArray[i][6].setEnabled(false);
                changeVisualUnselected(buttonArray[i][6]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                buttonArray[i][5].setText("C");
                turnButtonRed(buttonArray[i][5]);
                buttonArray[i][5].setEnabled(false);
                changeVisualUnselected(buttonArray[i][5]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                buttonArray[i][6].setText("C");
                turnButtonRed(buttonArray[i][6]);
                buttonArray[i][6].setEnabled(false);
                changeVisualUnselected(buttonArray[i][6]);
                return;
            }
        }
    }//blockOrMillVert

    public Boolean isBlockOrMillVert(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                return true;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                return true;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                return true;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                return true;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                return true;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                return true;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                return true;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                return true;
            }
        }
        return false;
    }//isBlockOrMillVert

    public Button getComputerButtonHort() {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][3].getText() == "C" &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                return buttonArray[i][5];
            }
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][5].getText() == "C" &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                return buttonArray[i][3];
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][3].getText() == "C" &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                return buttonArray[i][0];
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][0].getText() == "C" &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                return buttonArray[i][3];
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][4].getText() == "C" &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                return buttonArray[i][7];
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][7].getText() == "C" &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                return buttonArray[i][4];
            }
            if (buttonArray[i][7].getText() == "C" && buttonArray[i][4].getText() == "C" &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                return buttonArray[i][2];
            }
            if (buttonArray[i][7].getText() == "C" && buttonArray[i][2].getText() == "C" &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                return buttonArray[i][4];
            }
        }
        return null;
    }//getComputerButtonHort

    public void blockOrMillHort(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                buttonArray[i][5].setText("C");
                turnButtonRed(buttonArray[i][5]);
                buttonArray[i][5].setEnabled(false);
                changeVisualUnselected(buttonArray[i][5]);
                return;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                buttonArray[i][3].setText("C");
                turnButtonRed(buttonArray[i][3]);
                buttonArray[i][3].setEnabled(false);
                changeVisualUnselected(buttonArray[i][3]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                buttonArray[i][0].setText("C");
                turnButtonRed(buttonArray[i][0]);
                buttonArray[i][0].setEnabled(false);
                changeVisualUnselected(buttonArray[i][0]);
                return;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                buttonArray[i][3].setText("C");
                turnButtonRed(buttonArray[i][3]);
                buttonArray[i][3].setEnabled(false);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                buttonArray[i][7].setText("C");
                turnButtonRed(buttonArray[i][7]);
                buttonArray[i][7].setEnabled(false);
                changeVisualUnselected(buttonArray[i][7]);
                return;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                buttonArray[i][4].setText("C");
                turnButtonRed(buttonArray[i][4]);
                buttonArray[i][4].setEnabled(false);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                buttonArray[i][2].setText("C");
                turnButtonRed(buttonArray[i][2]);
                buttonArray[i][2].setEnabled(false);
                changeVisualUnselected(buttonArray[i][2]);
                return;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                buttonArray[i][4].setText("C");
                turnButtonRed(buttonArray[i][4]);
                buttonArray[i][4].setEnabled(false);
                changeVisualUnselected(buttonArray[i][4]);
                return;
            }
        }
    }//blockOrMillHort

    public Boolean isBlockOrMillHort(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                return true;
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                return true;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece &&
                    buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                return true;
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece &&
                    buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                return true;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                return true;
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                return true;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece &&
                    buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                return true;
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece &&
                    buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                return true;
            }
        }
        return false;
    }//isBLockOrMillHort

    public Button getComputerButtonCrossLines() {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == "C" && buttonArray[1][numbersInList].getText() == "C" &&
                    buttonArray[2][numbersInList].getText() != "C" && buttonArray[2][numbersInList].getText() != "P") {
                return buttonArray[2][numbersInList];
            }
            if (buttonArray[0][numbersInList].getText() == "C" && buttonArray[2][numbersInList].getText() == "C" &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                return buttonArray[1][numbersInList];
            }
            if (buttonArray[2][numbersInList].getText() == "C" && buttonArray[1][numbersInList].getText() == "C" &&
                    buttonArray[0][numbersInList].getText() != "C" && buttonArray[0][numbersInList].getText() != "P") {
                return buttonArray[0][numbersInList];
            }
            if (buttonArray[2][numbersInList].getText() == "C" && buttonArray[0][numbersInList].getText() == "C" &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                return buttonArray[1][numbersInList];
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//getCompterButtonCrossLines

    public void blockOrMillCrossLines(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[2][numbersInList].getText() != "C" && buttonArray[2][numbersInList].getText() != "P") {
                buttonArray[2][numbersInList].setText("C");
                turnButtonRed(buttonArray[2][numbersInList]);
                buttonArray[2][numbersInList].setEnabled(false);
                changeVisualUnselected(buttonArray[2][numbersInList]);
                return;
            }
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[2][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                buttonArray[1][numbersInList].setText("C");
                turnButtonRed(buttonArray[1][numbersInList]);
                buttonArray[1][numbersInList].setEnabled(false);
                changeVisualUnselected(buttonArray[1][numbersInList]);
                return;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[0][numbersInList].getText() != "C" && buttonArray[0][numbersInList].getText() != "P") {
                buttonArray[0][numbersInList].setText("C");
                turnButtonRed(buttonArray[0][numbersInList]);
                buttonArray[0][numbersInList].setEnabled(false);
                changeVisualUnselected(buttonArray[0][numbersInList]);
                return;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[0][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                buttonArray[1][numbersInList].setText("C");
                turnButtonRed(buttonArray[1][numbersInList]);
                buttonArray[1][numbersInList].setEnabled(false);
                changeVisualUnselected(buttonArray[1][numbersInList]);
                return;
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }//blockOrMillCrossLines

    public Boolean isBlockOrMillCrossLines(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, -1};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[2][numbersInList].getText() != "C" && buttonArray[2][numbersInList].getText() != "P") {
                return true;
            }
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[2][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                return true;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece &&
                    buttonArray[0][numbersInList].getText() != "C" && buttonArray[0][numbersInList].getText() != "P") {
                return true;
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[0][numbersInList].getText() == whichPiece &&
                    buttonArray[1][numbersInList].getText() != "C" && buttonArray[1][numbersInList].getText() != "P") {
                return true;
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return false;
    }//isBLockOrMillCrossLine

    public Button returnMillSecondPhaseVertButton(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][1]) == buttonArray[i][2]) {
                    return buttonArray[i][2];
                }
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][2]) == buttonArray[i][1]) {
                    return buttonArray[i][1];
                }
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][1].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][1]) == buttonArray[i][0]) {
                    return buttonArray[i][0];
                }
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) == buttonArray[i][1]) {
                    return buttonArray[i][1];
                }
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][6]) == buttonArray[i][7]) {
                    return buttonArray[i][7];
                }
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][7]) == buttonArray[i][6]) {
                    return buttonArray[i][6];
                }
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][6].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][6]) == buttonArray[i][5]) {
                    return buttonArray[i][7];
                }
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][5]) == buttonArray[i][6]) {
                    return buttonArray[i][6];
                }
            }
        }
        return null;
    }//returnMillSecondPhaseVertButton

    public Button returnMillSecondPhaseHortButton(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][3]) == buttonArray[i][5]) {
                    return buttonArray[i][5];
                }
            }
            if (buttonArray[i][0].getText() == whichPiece && buttonArray[i][5].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][5]) == buttonArray[i][3]) {
                    return buttonArray[i][3];
                }
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][3].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][3]) == buttonArray[i][0]) {
                    return buttonArray[i][0];
                }
            }
            if (buttonArray[i][5].getText() == whichPiece && buttonArray[i][0].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) == buttonArray[i][3]) {
                    return buttonArray[i][3];
                }
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][4]) == buttonArray[i][7]) {
                    return buttonArray[i][7];
                }
            }
            if (buttonArray[i][2].getText() == whichPiece && buttonArray[i][7].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][7]) == buttonArray[i][4]) {
                    return buttonArray[i][4];
                }
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][4].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][4]) == buttonArray[i][2]) {
                    return buttonArray[i][2];
                }
            }
            if (buttonArray[i][7].getText() == whichPiece && buttonArray[i][2].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[i][2]) == buttonArray[i][4]) {
                    return buttonArray[i][4];
                }
            }
        }
        return null;
    }//returnMillSecondPhaseVertButton

    public Button returnMillSecondPhaseCrossLinesButton(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, -1};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[1][numbersInList]) == buttonArray[2][numbersInList]) {
                    return buttonArray[2][numbersInList];
                }
            }
            if (buttonArray[0][numbersInList].getText() == whichPiece && buttonArray[2][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[2][numbersInList]) == buttonArray[1][numbersInList]) {
                    return buttonArray[1][numbersInList];
                }
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[1][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[1][numbersInList]) == buttonArray[0][numbersInList]) {
                    return buttonArray[0][numbersInList];
                }
            }
            if (buttonArray[2][numbersInList].getText() == whichPiece && buttonArray[0][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonArray[0][numbersInList]) == buttonArray[1][numbersInList]) {
                    return buttonArray[1][numbersInList];
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockOrMillCrossLine

    public Button tryingToMakeAMillSecondPhrase() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][1]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][1]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][1]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][1]);
                }
            }// top of the squares
            if (buttonArray[i][6].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][6]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][6]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][6]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][6]);
                }
            }// bottom of the squares
            if (buttonArray[i][3].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][3]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][3]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][3]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][3]);
                }
            }// left lines of the squares
            if (buttonArray[i][4].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][4]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][4]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][4]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][4]);
                }
            }// right lines of the squares

            if (buttonArray[i][0].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][0]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][0]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][0]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][0]);
                }
            }// top left corner of squares
            if (buttonArray[i][2].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][2]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][2]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][2]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][2]);
                }
            }// top right corner of squares
            if (buttonArray[i][5].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][5]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][5]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][5]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][5]);
                }
            }// bottom left corner of squares
            if (buttonArray[i][7].getText() == "C" && returnEnableAdjacentButtons(buttonArray[i][7]) != null) {
                if (returnEnableAdjacentButtons(buttonArray[i][7]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonArray[i][7]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonArray[i][7]);
                }
            }// bottom right corner of squares

        }//for loop
        return null;
    }//tryingToMakeMillMiddleHorizontal

    public Button ifMillSecondPhase() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][0].getText() == "C" && buttonArray[i][2].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) != null) {
                    return buttonArray[i][0];
                } else if (returnEnableAdjacentButtons(buttonArray[i][1]) != null) {
                    return buttonArray[i][1];
                } else if (returnEnableAdjacentButtons(buttonArray[i][2]) != null) {
                    return buttonArray[i][2];
                }
            }
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][3].getText() == "C" && buttonArray[i][5].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) != null) {
                    return buttonArray[i][0];
                } else if (returnEnableAdjacentButtons(buttonArray[i][3]) != null) {
                    return buttonArray[i][3];
                } else if (returnEnableAdjacentButtons(buttonArray[i][5]) != null) {
                    return buttonArray[i][5];
                }
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][4].getText() == "C" && buttonArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][2]) != null) {
                    return buttonArray[i][2];
                } else if (returnEnableAdjacentButtons(buttonArray[i][4]) != null) {
                    return buttonArray[i][4];
                } else if (returnEnableAdjacentButtons(buttonArray[i][7]) != null) {
                    return buttonArray[i][7];
                }
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][6].getText() == "C" && buttonArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][5]) != null) {
                    return buttonArray[i][5];
                } else if (returnEnableAdjacentButtons(buttonArray[i][6]) != null) {
                    return buttonArray[i][6];
                } else if (returnEnableAdjacentButtons(buttonArray[i][7]) != null) {
                    return buttonArray[i][7];
                }
            }

        }
        return null;
    }

    public Button ifMillSecondPhaseCrossLines() {
        int[] numberArray = {1, 3, 4, 6, -1};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == "C" && buttonArray[1][numbersInList].getText() == "C" &&
                    buttonArray[2][numbersInList].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[0][numbersInList]) != null) {
                    return buttonArray[0][numbersInList];
                }
                if (returnEnableAdjacentButtons(buttonArray[1][numbersInList]) != null) {
                    return buttonArray[1][numbersInList];
                }
                if (returnEnableAdjacentButtons(buttonArray[2][numbersInList]) != null) {
                    return buttonArray[2][numbersInList];
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockrMillCrossLine

    public Button ifMillSecondPhaseReturnAdjacentButtons() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][0].getText() == "C" && buttonArray[i][2].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][0]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][1]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][1]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][2]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][2]);
                }
            }
            if (buttonArray[i][0].getText() == "C" && buttonArray[i][3].getText() == "C" && buttonArray[i][5].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][0]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][0]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][3]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][3]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][5]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][5]);
                }
            }
            if (buttonArray[i][2].getText() == "C" && buttonArray[i][4].getText() == "C" && buttonArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][2]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][2]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][4]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][4]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][7]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][7]);
                }
            }
            if (buttonArray[i][5].getText() == "C" && buttonArray[i][6].getText() == "C" && buttonArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[i][5]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][5]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][6]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][6]);
                }
                else if (returnEnableAdjacentButtons(buttonArray[i][7]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[i][7]);
                }
            }

        }
        return null;
    }

    public Button ifMillSecondPhaseCrossLinesReturnAdjacentButtons() {
        int[] numberArray = {1, 3, 4, 6, -1};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == "C" && buttonArray[1][numbersInList].getText() == "C" &&
                    buttonArray[2][numbersInList].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonArray[0][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[0][numbersInList]);
                }
                if (returnEnableAdjacentButtons(buttonArray[1][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[1][numbersInList]);
                }
                if (returnEnableAdjacentButtons(buttonArray[2][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonArray[2][numbersInList]);
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockrMillCrossLine

    public Button ajacentToPlayerPiece () {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "P" &&
                        returnEnableAdjacentButtons(buttonArray[i][j]) != null) {
                    if (returnEnableAdjacentButtons(buttonArray[i][j]).getText() != "P"
                            && returnEnableAdjacentButtons(buttonArray[i][j]).getText() != "C") {
                        return returnEnableAdjacentButtons(buttonArray[i][j]);
                    }

                }
            }
        }
        return null;
    }

    public void changeVisualSelected(Button toBeEnabled){
        if(toBeEnabled.getText().equals("C")){
            turnButtonHighlightRed(toBeEnabled);
        }
        else if(toBeEnabled.getText().equals("P")){
            turnButtonHighlightBlue(toBeEnabled);
        }
        else if(toBeEnabled.getText().equals(null)){
            turnButtonHighlightWhite(toBeEnabled);
        }
    }

    public void changeVisualUnselected(Button toBeDisabled){
        if(toBeDisabled.getText().equals("C")){
            turnButtonRed(toBeDisabled);
        }
        else if(toBeDisabled.getText().equals("P")){
            turnButtonBlue(toBeDisabled);
        }
        else if(toBeDisabled.getText().equals(null)){
            turnButtonWhite(toBeDisabled);
        }
    }//changeVisualUnselected

    /**
     *     //////////////////////////////////
     *     //      VISUAL BELOW            //
     *     //////////////////////////////////
     *     Cole Cloutier
     */

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

    /////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * Functions that control the mood of the portraits
     *
     */
    public void makePortraitsNeutral(){
        boolean isPvp = true;
        ImageView bluePortrait = (ImageView) findViewById(R.id.playerBlue);
        ImageView redPortrait = (ImageView) findViewById(R.id.playerRed);

        bluePortrait.setImageResource(R.drawable.portrait_blue_human);
        if(isPvp){
            redPortrait.setImageResource(R.drawable.portrait_red_human);
        }
        else{
            redPortrait.setImageResource(R.drawable.portrait_red_alien);
        }
    }//makePortraitsNeutral
    public void makePortraitBlueHappy(){
        boolean isPvp = true;
        ImageView bluePortrait = (ImageView) findViewById(R.id.playerBlue);
        ImageView redPortrait = (ImageView) findViewById(R.id.playerRed);

        bluePortrait.setImageResource(R.drawable.portrait_blue_human_happy);
        if(isPvp){
            redPortrait.setImageResource(R.drawable.portrait_red_human_sad);
        }
        else{
            redPortrait.setImageResource(R.drawable.portrait_red_alien_sad);
        }

        makeActionIndicatorSayCapture();
    }//makePortraitBlueHappy
    public void makePortraitRedHappy(){
        boolean isPvp = true;
        ImageView bluePortrait = (ImageView) findViewById(R.id.playerBlue);
        ImageView redPortrait = (ImageView) findViewById(R.id.playerRed);

        bluePortrait.setImageResource(R.drawable.portrait_blue_human_sad);
        if(isPvp){
            redPortrait.setImageResource(R.drawable.portrait_red_human_happy);
        }
        else{
            redPortrait.setImageResource(R.drawable.portrait_red_alien_happy);
        }

        makeActionIndicatorSayCapture();
    }//makePortraitRedHappy

    /*
     * Functions that change the actionIndicator
     */
    public void makeActionIndicatorSayPlace(){
        ImageView actionIndicator = (ImageView) findViewById(R.id.actionIndicator);

        actionIndicator.setImageResource(R.drawable.indicator_place);
    }//makeActionIndicatorSayPlace
    public void makeActionIndicatorSayMove(){
        ImageView actionIndicator = (ImageView) findViewById(R.id.actionIndicator);

        actionIndicator.setImageResource(R.drawable.indicator_move);
    }//makeActionIndicatorSayMove
    public void makeActionIndicatorSayCapture(){
        ImageView actionIndicator = (ImageView) findViewById(R.id.actionIndicator);

        actionIndicator.setImageResource(R.drawable.indicator_capture);
    }//makeActionIndicatorSayCapture

    /////////////////////////////////////////////////////////////////////////////////////////////

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
    public void turnButtonHighlightWhite(Button InputButton){
        InputButton.setBackgroundResource(R.drawable.token_none_selected);
    }//turnButtonHighlightWhite
}// end file


