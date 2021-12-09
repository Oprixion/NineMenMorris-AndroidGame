package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class PvcGameScreen extends AppCompatActivity {
    public int playerPieceOnHand = 9;
    public int playerPieceOnBoard = 0;
    public int computerPieceOnBoard = 0;
    public int computerPieceOnHand = 9;
    public int indexOfPlayerPieceToRemove = 0;
    Button[][] buttonArray = new Button[8][8];
    Button[] playerPiecesArray = new Button[10];
    Button[] computerPiecesArray = new Button[10];
    String playerPiece;
    int numOfRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
        playerPiece = "notP";
        numOfRd = 0;
        buttonsBoard(buttonArray);

    }

    public void buttonsBoard(Button[][] gameBoard) {
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

    public void playerOrComputer(View myView) {
        numOfRd += 1;
        Button playerMove = (Button) myView;
        if (numOfPlayerPieces() <= 9 && numOfPlayerPieces() <= 9) {
            if(playerPiece.equals("notRemover")){
                playerPiece="P";
            }
            if(playerPiece.equals("Remover")){
                removeIfMill(playerMove);
                enableAllButtons(buttonArray);
                disableComputerMove();
                disablePlayerMove();
                playerPiece= "notRemover";
            }

            if(playerPiece.equals("notP")) {
                playerTurn(playerMove);
                playerPiece="P";
            }
            if (isMillCrossLines1("P", playerMove)
                    || isMillFirstOp("P", playerMove)
                    || isMillSecondOp("P", playerMove)) {
                disableAllButtons();
                enableComputerMove();
                playerPiece="Remover";
            }


            if (playerPiece.equals("P")) {
                if (numOfRd <= 9) {
                    computerTurn();
                    if(isMillComputerCrossLines1("C")
                            || isMillComputerFirstOp("C")
                            || isMillComputerSecondOp("C")){
                        removePlayerPiece();
                    }
                    playerPiece="notP";
                }
            }
            if (numOfRd >= 9) {
                disableAllButtons();
                enableAllPlayerPieces();
            }
            if (numOfRd >= 10) {
                if (playerMove.getText() == "P") {
                    enableAdjacentButtons(playerMove);
                    removePlayerPieceWhenMoving(playerMove);
                } else {
                    movePlayerPiece(playerMove);
                }

            }
        }
    }


    public void playerTurn(Button playerMove) {
        if (numOfRd <= 9) {
            playerMove.setText("P");
            playerMove.setEnabled(false);
            playerPiecesArray[9 - playerPieceOnHand] = playerMove;
            if (playerPieceOnHand > 0) {
                playerPieceOnHand--;
            }
            if (playerPieceOnBoard < 9) {
                playerPieceOnBoard++;
            }
            playerPiece = "P";
        }
    }//player1Turn

    public void computerTurn() {
        if (numOfRd == 1) {
            firstComputerTurn();
        } else if (isBlockOrMillFirstOp("P") || isBlockOrMillSecondOp("P") ||
                isBlockOrMillCrossLines1("P") || isBlockOrMillCrossLines2("P")
                || isBlockOrMillCrossLinesInBetween("P") || isBlockOrMillInBetween("P")) {
            if (isBlockOrMillFirstOp("P")) {
                blockOrMillFirstOp("P");
            } else if (isBlockOrMillSecondOp("P")) {
                blockOrMillSecondOp("P");
            } else if (isBlockOrMillCrossLines1("P")) {
                blockOrMillCrossLines1("P");
            } else if (isBlockOrMillCrossLines2("P")) {
                blockOrMillCrossLines2("P");
            } else if (isBlockOrMillInBetween("P")) {
                blockOrMillInBetween("P");
            } else if (isBlockOrMillCrossLinesInBetween("P")) {
                blockOrMillCrossLinesInBetween("P");
            }
        } else if (isBlockOrMillFirstOp("C") || isBlockOrMillSecondOp("C") ||
                isBlockOrMillCrossLines1("C") || isBlockOrMillCrossLines2("C")
                || isBlockOrMillCrossLinesInBetween("C") || isBlockOrMillInBetween("C")) {
            if (isBlockOrMillFirstOp("C")) {
                blockOrMillFirstOp("C");
            } else if (isBlockOrMillSecondOp("C")) {
                blockOrMillSecondOp("C");
            } else if (isBlockOrMillCrossLines1("C")) {
                blockOrMillCrossLines1("C");
            } else if (isBlockOrMillCrossLines2("C")) {
                blockOrMillCrossLines2("C");
            } else if (isBlockOrMillInBetween("C")) {
                blockOrMillInBetween("C");
            } else if (isBlockOrMillCrossLinesInBetween("C")) {
                blockOrMillCrossLinesInBetween("C");
            }
        } else if (isTryingToMakeMillCorners() || isTryingToMakeMillMiddleHorizonal()
                || isTryingToMakeMillMiddleVertical()) {
            if (isTryingToMakeMillMiddleHorizonal()) {
                tryingToMakeMillMiddleHorizonal();
            } else if (isTryingToMakeMillMiddleVertical()) {
                tryingToMakeMillMiddleVertical();
            } else if (isTryingToMakeMillCorners()) {
                tryingToMakeMillCorners();
            } else if (isTryingToMakeMillCrossLines()) {
                tryingToMakeMillCrossLines();
            }
        }
    }

    public void disableAllButtons() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                buttonArray[i][j].setEnabled(false);
            }
        }
    }//disableAllButtons


    public void enableAllPlayerPieces() {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i].getText() != null) {
                playerPiecesArray[i].setEnabled(true);
            }
        }
    }//disableAllButtons
   public void disableAllPlayerPieces(){
       for (int i = 0; i <= 8; i++) {
           if (playerPiecesArray[i].getText() != null) {
               playerPiecesArray[i].setEnabled(false);
           }
       }
   }//disableAllButtons
    public void enableAllButtons(Button[][] gameBoard) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                gameBoard[i][j].setEnabled(true);
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
        buttonArray[0][cpuFirstPosition].setEnabled(false);

    }

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
    }//isCompterFirstTurn

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
    }//isCompterFirstTurn

    public void blockOrMillFirstOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                        buttonArray[i][2].setText("C");
                        buttonArray[i][2].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        buttonArray[i][0].setText("C");
                        buttonArray[i][0].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                        buttonArray[i][5].setText("C");
                        buttonArray[i][5].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        buttonArray[i][7].setText("C");
                        buttonArray[i][7].setEnabled(false);
                        return;
                    }
                }
            }
        }//for loop
    }//blockMoveReturnCols

    public void blockOrMillSecondOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                        buttonArray[i][5].setText("C");
                        buttonArray[i][5].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        buttonArray[i][7].setText("C");
                        buttonArray[i][7].setEnabled(false);
                        return ;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                        buttonArray[i][2].setText("C");
                        buttonArray[i][2].setEnabled(false);
                        return ;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        buttonArray[i][0].setText("C");
                        buttonArray[i][0].setEnabled(false);
                        return ;
                    }
                }
            }
        }//for loop
    }//blockMoveReturnCols


    public boolean isBlockOrMillFirstOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove

    public boolean isBlockOrMillSecondOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove

    public boolean isBlockOrMillCrossLines1(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[2][numbersInList].getText() != "C" && buttonArray[2]
                            [numbersInList].getText() != "P") {
                        return true;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return false;
    }

    public void blockOrMillCrossLines1(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[2][numbersInList].getText() != "C" && buttonArray[2]
                            [numbersInList].getText() != "P") {
                        buttonArray[2][numbersInList].setText("C");
                        buttonArray[2][numbersInList].setEnabled(false);
                        return;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }

    public boolean isBlockOrMillCrossLines2(String playerOrComputerPiece) {
        int[] numberArray = {0, 1, 3, 4, 6, 0};
        int numInListCounter = 3;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter >= 1) {
            if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[0][numbersInList].getText() != "C" && buttonArray[0]
                            [numbersInList].getText() != "P") {
                        return true;
                    }
                }
            }
            numInListCounter -= 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return false;
    }

    public void blockOrMillCrossLines2(String playerOrComputerPiece) {
        int[] numberArray = {0, 1, 3, 4, 6, 0};
        int numInListCounter = 4;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter >= 1) {
            if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[0][numbersInList].getText() != "C" && buttonArray[0]
                            [numbersInList].getText() != "P") {
                        buttonArray[0][numbersInList].setText("C");
                        buttonArray[0][numbersInList].setEnabled(false);
                        return;
                    }
                }
            }
            numInListCounter -= 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }

    public boolean isBlockOrMillInBetween(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockMoveInBetween

    public void blockOrMillInBetween(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                        buttonArray[i][1].setText("C");
                        buttonArray[i][1].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                        buttonArray[i][3].setText("C");
                        buttonArray[i][3].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                        buttonArray[i][4].setText("C");
                        buttonArray[i][4].setEnabled(false);
                        return;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                        buttonArray[i][6].setText("C");
                        buttonArray[i][6].setEnabled(false);
                        return;
                    }
                }
            }
        }//for loop
    }//blockMoveInBetweenReturnCols

    public boolean isBlockOrMillCrossLinesInBetween(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() != "C" && buttonArray[1]
                            [numbersInList].getText() != "P") {
                        return true;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return false;
    }

    public void blockOrMillCrossLinesInBetween(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() != "C" && buttonArray[1]
                            [numbersInList].getText() != "P") {
                        buttonArray[1][numbersInList].setText("C");
                        buttonArray[1][numbersInList].setEnabled(false);
                        return;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }//blockMoveCrossLinesInBetweenReturnCol

    public boolean isTryingToMakeMillMiddleHorizonal() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    return true;
                } else if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[i][6].getText() == "C") {
                if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    return true;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    return true;
                }
            }
        }
        return false;
    }

    public void tryingToMakeMillMiddleHorizonal() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    buttonArray[i][0].setText("C");
                    buttonArray[i][0].setEnabled(false);
                    return;
                } else if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    buttonArray[i][2].setText("C");
                    buttonArray[i][2].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[i][6].getText() == "C") {
                if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    buttonArray[i][5].setText("C");
                    buttonArray[i][5].setEnabled(false);
                    return;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    buttonArray[i][7].setText("C");
                    buttonArray[i][7].setEnabled(false);
                    return;
                }
            }
        }
    }

    public boolean isTryingToMakeMillMiddleVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][3].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    return true;
                } else if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[i][4].getText() == "C") {
                if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    return true;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    return true;
                }
            }
        }
        return false;
    }

    public void tryingToMakeMillMiddleVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][3].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                    buttonArray[i][0].setText("C");
                    buttonArray[i][0].setEnabled(false);
                    return;
                } else if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                    buttonArray[i][5].setText("C");
                    buttonArray[i][5].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[i][4].getText() == "C") {
                if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                    buttonArray[i][2].setText("C");
                    buttonArray[i][2].setEnabled(false);
                    return;
                } else if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                    buttonArray[i][7].setText("C");
                    buttonArray[i][7].setEnabled(false);
                    return;
                }
            }
        }
    }

    public boolean isTryingToMakeMillCorners() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    return true;
                } else if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    return true;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    return true;
                } else if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    return true;
                }
            }
            if (buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    return true;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    return true;
                }
            }
        }// for loop
        return false;
    }

    public void tryingToMakeMillCorners() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    buttonArray[i][1].setText("C");
                    buttonArray[i][1].setEnabled(false);
                    return;
                } else if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    buttonArray[i][3].setText("C");
                    buttonArray[i][3].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                    buttonArray[i][1].setText("C");
                    buttonArray[i][1].setEnabled(false);
                    return;
                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    buttonArray[i][4].setText("C");
                    buttonArray[i][4].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                    buttonArray[i][3].setText("C");
                    buttonArray[i][3].setEnabled(false);
                    return;
                } else if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    buttonArray[i][6].setText("C");
                    buttonArray[i][6].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                    buttonArray[i][6].setText("C");
                    buttonArray[i][6].setEnabled(false);
                    return;

                } else if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                    buttonArray[i][4].setText("C");
                    buttonArray[i][4].setEnabled(false);
                    return;
                }
            }
        }// for loop
    }

    public boolean isTryingToMakeMillCrossLines() {
        int[] numberArray = {1, 3, 4, 6, 0};
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
                }
                if (buttonArray[2][numbersInList].getText() != "C" &&
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
                    buttonArray[1][numbersInList].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[1][numbersInList].getText() == "C") {
                if (buttonArray[0][numbersInList].getText() != "C" &&
                        buttonArray[0][numbersInList].getText() != "P") {
                    buttonArray[0][numbersInList].setText("C");
                    buttonArray[0][numbersInList].setEnabled(false);
                    return;
                } else if (buttonArray[2][numbersInList].getText() != "C" &&
                        buttonArray[2][numbersInList].getText() != "P") {
                    buttonArray[2][numbersInList].setText("C");
                    buttonArray[2][numbersInList].setEnabled(false);
                    return;
                }
            }
            if (buttonArray[2][numbersInList].getText() == "C") {
                if (buttonArray[1][numbersInList].getText() != "C" &&
                        buttonArray[1][numbersInList].getText() != "P") {
                    buttonArray[1][numbersInList].setText("C");
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
                }
            }
        }
    }
public void removePlayerPiece(){
        if(isBlockOrMillCrossLines1("P")){
            removePlayerPieceIfMillCrossLines1("P");
        }
        else if( isBlockOrMillCrossLines2("P")){
                  removePlayerPieceIfMillCrossLines2("P");
        }
        else if( isBlockOrMillFirstOp("P")){
            removePlayerPieceIfMillFirstOp("P");
        }
        else if(isBlockOrMillSecondOp("P")){
            removePlayerPieceIfMillSecondOp("P");
        }
        else if(isBlockOrMillInBetween("P")){
            removePlayerPieceIfMillInBetween("P");
        }
        else if(isBlockOrMillCrossLinesInBetween("P")){
            removePlayerPieceIfMillCrossLinesInBetween("P");
        }
        else{
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (buttonArray[i][j].getText() == "P") {
                        buttonArray[i][j].setText(null);
                        return;
                    }
                }
            }
        }
}
    public void removePlayerPieceIfMillFirstOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if(buttonArray[i][2].getText()!= "C" && buttonArray[i][2].getText()!="P") {
                         buttonArray[i][0].setText(null);
                        return;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                    if(buttonArray[i][0].getText()!= "C" && buttonArray[i][0].getText()!="P") {
                        buttonArray[i][2].setText(null);
                        return;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if(buttonArray[i][5].getText()!= "C" && buttonArray[i][5].getText()!="P") {
                         buttonArray[i][7].setText(null);
                        return;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                    if(buttonArray[i][7].getText()!= "C" && buttonArray[i][7].getText()!="P") {
                         buttonArray[i][5].setText(null);
                         return;
                    }
                }
            }
        }//for loop
    }//blockMoveReturnCols
    public void removePlayerPieceIfMillSecondOp(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                         buttonArray[i][0].setText(null);
                         return;
                    }
                }
            }
            if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        buttonArray[i][2].setText(null);
                        return;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                         buttonArray[i][7].setText(null);
                         return;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        buttonArray[i][5].setText(null);
                        return;
                    }
                }
            }
        }//for loop
    }//isblockmove
    public void removePlayerPieceIfMillCrossLines1(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[2][numbersInList].getText() != "C" && buttonArray[2]
                            [numbersInList].getText() != "P") {
                        buttonArray[0][numbersInList].setText(null);
                        return;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }
    public void removePlayerPieceIfMillCrossLines2(String playerOrComputerPiece) {
        int[] numberArray = {0, 1, 3, 4, 6, 0};
        int numInListCounter = 3;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter >= 1) {
            if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[0][numbersInList].getText() != "C" && buttonArray[0]
                            [numbersInList].getText() != "P") {
                        buttonArray[2][numbersInList].setText(null);
                        return;
                    }
                }
            }
            numInListCounter -= 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }
    public void removePlayerPieceIfMillInBetween(String playerOrComputerPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() != "C" && buttonArray[i][1].getText() != "P") {
                         buttonArray[i][0].setText(null);
                         return;
                    }
                }
            }
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() != "C" && buttonArray[i][3].getText() != "P") {
                         buttonArray[i][0].setText(null);
                         return;
                    }
                }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][4].getText() != "C" && buttonArray[i][4].getText() != "P") {
                        buttonArray[i][7].setText(null);
                        return;
                    }
                }
            }
            if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][6].getText() != "C" && buttonArray[i][6].getText() != "P") {
                        buttonArray[i][5].setText(null);
                        return;
                    }
                }
            }
        }//for loop
    }//isblockMoveInBetween
    public void removePlayerPieceIfMillCrossLinesInBetween(String playerOrComputerPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() != "C" && buttonArray[1]
                            [numbersInList].getText() != "P") {
                        buttonArray[0][numbersInList].setText(null);
                        return;
                    }
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop

    }

    public void enableComputerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "C") {
                    buttonArray[i][j].setEnabled(true);
                }
            }
        }
    }
    public void enablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "P") {
                    buttonArray[i][j].setEnabled(true);
                }
            }
        }
    }
    public void disablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonArray[i][j].getText() == "P") {
                    buttonArray[i][j].setEnabled(false);
                }
            }
        }
    }
    public void removeIfMill(Button removedButton){
       removedButton.setText(null);
       removedButton.setEnabled(false);
    }
    public void removePlayerPieceWhenMoving(Button playerMove){
        for(int i= 0 ; i<=8 ; i++){
            if(playerPiecesArray[i]==playerMove){
                indexOfPlayerPieceToRemove=i;
                return;
            }
        }
    }
    public void movePlayerPiece(Button playerMove){
        if(playerMove.getText()!="P" && playerMove.getText()!="C"){
            playerMove.setText("P");
            playerPiecesArray[indexOfPlayerPieceToRemove].setText(null);
            playerPiecesArray[indexOfPlayerPieceToRemove]=playerMove;
        }
    }
    public void enableAdjacentButtons(Button playerMove){
        if(playerMove==buttonArray[0][0]){
            if((buttonArray[0][1].getText()!="C")&&(buttonArray[0][1].getText()!="P")){
                buttonArray[0][1].setEnabled(true);
            }
            if((buttonArray[0][3].getText()!="C")&&(buttonArray[0][3].getText()!="P")){
                buttonArray[0][3].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[0][1]){
            if((buttonArray[1][1].getText()!="C")&&(buttonArray[1][1].getText()!="P")){
                buttonArray[1][1].setEnabled(true);
            }
            if((buttonArray[0][0].getText()!="C")&&(buttonArray[0][0].getText()!="P")){
                buttonArray[0][0].setEnabled(true);
            }
            if((buttonArray[0][2].getText()!="C")&&(buttonArray[0][2].getText()!="P")){
                buttonArray[0][2].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[0][2]){
            if((buttonArray[0][1].getText()!="C")&&(buttonArray[0][1].getText()!="P")){
                buttonArray[0][1].setEnabled(true);
            }
            if((buttonArray[0][4].getText()!="C")&&(buttonArray[0][4].getText()!="P")){
                buttonArray[0][4].setEnabled(true);
            }

        }
        if(playerMove== buttonArray[0][3]){
            if((buttonArray[0][0].getText()!="C")&&(buttonArray[0][0].getText()!="P")){
                buttonArray[0][0].setEnabled(true);
            }
            if((buttonArray[1][3].getText()!="C")&&(buttonArray[1][3].getText()!="P")){
                buttonArray[1][3].setEnabled(true);
            }
            if((buttonArray[0][5].getText()!="C")&&(buttonArray[0][5].getText()!="P")){
                buttonArray[0][5].setEnabled(true);
            }
        }
        if(playerMove== buttonArray[0][4]){
            if((buttonArray[0][2].getText()!="C")&&(buttonArray[0][2].getText()!="P")){
                buttonArray[0][2].setEnabled(true);
            }
            if((buttonArray[1][4].getText()!="C")&&(buttonArray[1][4].getText()!="P")){
                buttonArray[1][4].setEnabled(true);
            }
            if((buttonArray[0][7].getText()!="C")&&( buttonArray[0][7].getText()!="P")){
                buttonArray[0][7].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[0][5]){
            if((buttonArray[0][3].getText()!="C")&&(buttonArray[0][3].getText()!="P")){
                buttonArray[0][3].setEnabled(true);
            }
            if((buttonArray[0][6].getText()!="C")&&(buttonArray[0][6].getText()!="P")){
                buttonArray[0][6].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[0][6]){
            if((buttonArray[0][5].getText()!="C")&&(buttonArray[0][5].getText()!="P")){
                buttonArray[0][5].setEnabled(true);
            }
            if((buttonArray[1][6].getText()!="C")&&(buttonArray[1][6].getText()!="P")){
                buttonArray[1][6].setEnabled(true);
            }
            if((buttonArray[0][7].getText()!="C")&&(buttonArray[0][7].getText()!="P")){
                buttonArray[0][7].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[0][7]){
            if((buttonArray[0][4].getText()!="C")&&(buttonArray[0][4].getText()!="P")){
                buttonArray[0][4].setEnabled(true);
            }
            if((buttonArray[0][6].getText()!="C")&&(buttonArray[0][6].getText()!="P")){
                buttonArray[0][6].setEnabled(true);
            }
        }

        //If the chosen button is in the second square
        if(playerMove==buttonArray[1][0]){
            if((buttonArray[1][1].getText()!="C")&&(buttonArray[1][1].getText()!="P")){
                buttonArray[1][1].setEnabled(true);
            }
            if((buttonArray[1][3].getText()!="C")&&(buttonArray[1][3].getText()!="P")){
                buttonArray[1][3].setEnabled(true);
            }

        }
        if(playerMove==buttonArray[1][1]){
            if((buttonArray[2][1].getText()!="C")&&(buttonArray[2][1].getText()!="P")){
                buttonArray[2][1].setEnabled(true);
            }
            if((buttonArray[0][1].getText()!="C")&&(buttonArray[0][1].getText()!="P")){
                buttonArray[0][1].setEnabled(true);
            }
            if((buttonArray[1][2].getText()!="C")&&(buttonArray[1][2].getText()!="P")){
                buttonArray[1][2].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[1][2]){
            if((buttonArray[1][1].getText()!="C")&&(buttonArray[1][1].getText()!="P")){
                buttonArray[1][1].setEnabled(true);
            }
            if((buttonArray[1][4].getText()!="C")&&(buttonArray[1][4].getText()!="P")){
                buttonArray[1][4].setEnabled(true);
            }

        }
        if(playerMove==buttonArray[1][3]){
            if((buttonArray[1][0].getText()!="C")&&(buttonArray[1][0].getText()!="P")){
                buttonArray[1][0].setEnabled(true);
            }
            if((buttonArray[2][3].getText()!="C")&&(buttonArray[2][3].getText()!="P")){
                buttonArray[2][3].setEnabled(true);
            }
            if((buttonArray[1][5].getText()!="C")&&(buttonArray[1][5].getText()!="P")){
                buttonArray[1][5].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[1][4]){
            if((buttonArray[1][2].getText()!="C")&&(buttonArray[1][2].getText()!="P")){
                buttonArray[1][2].setEnabled(true);
            }
            if((buttonArray[2][4].getText()!="C")&&(buttonArray[2][4].getText()!="P")){
                buttonArray[2][4].setEnabled(true);
            }
            if((buttonArray[1][7].getText()!="C")&&(buttonArray[1][7].getText()!="P")){
                buttonArray[1][7].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[1][5]){
            if((buttonArray[1][3].getText()!="C")&&(buttonArray[1][3].getText()!="P")){
                buttonArray[1][3].setEnabled(true);
            }
            if((buttonArray[1][6].getText()!="C")&&(buttonArray[1][6].getText()!="P")){
                buttonArray[1][6].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[1][6]){
            if((buttonArray[1][5].getText()!="C")&&(buttonArray[1][5].getText()!="P")){
                buttonArray[1][5].setEnabled(true);
            }
            if((buttonArray[2][6].getText()!="C")&&(buttonArray[2][6].getText()!="P")){
                buttonArray[2][6].setEnabled(true);
            }
            if((buttonArray[1][7].getText()!="C")&&(buttonArray[1][7].getText()!="P")){
                buttonArray[1][7].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[1][7]){
            if((buttonArray[1][4].getText()!="C")&&(buttonArray[1][4].getText()!="P")){
                buttonArray[1][4].setEnabled(true);
            }
            if((buttonArray[1][6].getText()!="C")&&(buttonArray[1][6].getText()!="P")){
                buttonArray[1][6].setEnabled(true);
            }
        }

        //If the chosen button is in the third square
        if(playerMove==buttonArray[2][0]){
            if((buttonArray[2][1].getText()!="C")&&(buttonArray[2][1].getText()!="P")){
                buttonArray[2][1].setEnabled(true);
            }
            if((buttonArray[2][3].getText()!="C")&&(buttonArray[2][3].getText()!="P")){
                buttonArray[2][3].setEnabled(true);
            }

        }
        if(playerMove==buttonArray[2][1]){
            if((buttonArray[2][0].getText()!="C")&&(buttonArray[2][0].getText()!="P")){
                buttonArray[2][0].setEnabled(true);
            }
            if((buttonArray[2][2].getText()!="C")&&(buttonArray[2][2].getText()!="P")){
                buttonArray[2][2].setEnabled(true);
            }
            if((buttonArray[1][1].getText()!="C")&&(buttonArray[1][1].getText()!="P")){
                buttonArray[1][1].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[2][2]){
            if((buttonArray[2][1].getText()!="C")&&(buttonArray[2][1].getText()!="P")){
                buttonArray[2][1].setEnabled(true);
            }
            if((buttonArray[2][4].getText()!="C")&&(buttonArray[2][4].getText()!="P")){
                buttonArray[2][4].setEnabled(true);
            }

        }
        if(playerMove==buttonArray[2][3]){
            if((buttonArray[2][0].getText()!="C")&&(buttonArray[2][0].getText()!="P")){
                buttonArray[2][0].setEnabled(true);
            }
            if((buttonArray[2][5].getText()!="C")&&(buttonArray[2][5].getText()!="P")){
                buttonArray[2][5].setEnabled(true);
            }
            if((buttonArray[1][3].getText()!="C")&&(buttonArray[1][3].getText()!="P")){
                buttonArray[1][3].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[2][4]){
            if((buttonArray[2][2].getText()!="C")&&(buttonArray[2][2].getText()!="P")){
                buttonArray[2][2].setEnabled(true);
            }
            if((buttonArray[2][7].getText()!="C")&&(buttonArray[2][7].getText()!="P")){
                buttonArray[2][7].setEnabled(true);
            }
            if((buttonArray[1][4].getText()!="C")&&(buttonArray[1][4].getText()!="P")){
                buttonArray[1][4].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[2][5]){
            if((buttonArray[2][3].getText()!="C")&&(buttonArray[2][3].getText()!="P")){
                buttonArray[2][3].setEnabled(true);
            }
            if((buttonArray[2][6].getText()!="C")&&(buttonArray[2][6].getText()!="P")){
                buttonArray[2][6].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[2][6]){
            if((buttonArray[2][5].getText()!="C")&&(buttonArray[2][5].getText()!="P")){
                buttonArray[2][5].setEnabled(true);
            }
            if((buttonArray[2][7].getText()!="C")&&(buttonArray[2][7].getText()!="P")){
                buttonArray[2][7].setEnabled(true);
            }
            if((buttonArray[1][6].getText()!="C")&&(buttonArray[1][6].getText()!="P")){
                buttonArray[1][6].setEnabled(true);
            }
        }
        if(playerMove==buttonArray[2][7]){
            if((buttonArray[2][4].getText()!="C")&&(buttonArray[2][4].getText()!="P")){
                buttonArray[2][4].setEnabled(true);
            }
            if((buttonArray[2][6].getText()!="C")&&(buttonArray[2][6].getText()!="P")){
                buttonArray[2][6].setEnabled(true);
            }
        }
    }

    ///////////////////////////////// NEWWWW PART //////////////////////////////
    public boolean isMillFirstOp(String playerOrComputerPiece, Button playerMove){
        for(int i = 0 ; i<=2 ; i++) {
            if(playerMove==buttonArray[i][0]||
                    playerMove==buttonArray[i][1]||playerMove==buttonArray[i][2]) {
                if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if(playerMove==buttonArray[i][7]||
                    playerMove==buttonArray[i][6]||playerMove==buttonArray[i][5]) {
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
    }//blockMoveReturnCols
    public boolean isMillSecondOp(String playerOrComputerPiece, Button playerMove){
        for(int i = 0 ; i<=2 ; i++) {
            if(playerMove==buttonArray[i][0]||playerMove==buttonArray[i][3]||
                    playerMove==buttonArray[i][5]) {
                if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if(playerMove==buttonArray[i][2]||playerMove==buttonArray[i][4]
                    ||playerMove==buttonArray[i][7]) {
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
    }//isblockmove
    public boolean isMillCrossLines1(String playerOrComputerPiece, Button playerMove){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4) {
            if (playerMove==buttonArray[0][numbersInList] || playerMove==buttonArray[1]
                    [numbersInList]||playerMove==buttonArray[2][numbersInList]){
                if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                        if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
             }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    /////////////////////////////  computer
    public boolean isMillComputerFirstOp(String playerOrComputerPiece){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][1].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
            }
            if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][6].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
            }
        }//for loop
        return false;
    }//blockMoveReturnCols
    public boolean isMillComputerSecondOp(String playerOrComputerPiece){
        for(int i = 0 ; i<=2 ; i++) {
                if (buttonArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][3].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }

                if (buttonArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonArray[i][4].getText() == playerOrComputerPiece) {
                        if (buttonArray[i][7].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
        }//for loop
        return false;
    }//isblockmove
    public boolean isMillComputerCrossLines1(String playerOrComputerPiece){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4) {
                if (buttonArray[0][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonArray[1][numbersInList].getText() == playerOrComputerPiece) {
                        if (buttonArray[2][numbersInList].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }

    public Button getComputerButtonVert(){
        for(int i = 0 ; i<=2 ; i++){
            if(buttonArray[i][0].getText()=="C" && buttonArray[i][1].getText()=="C" &&
                    buttonArray[i][2].getText()!="C" && buttonArray[i][2].getText()!="P"){

            }
            if(buttonArray[i][0].getText()=="C" && buttonArray[i][2].getText()=="C" &&
                    buttonArray[i][1].getText()!="C" && buttonArray[i][1].getText()!="P"){

            }
            if(buttonArray[i][2].getText()=="C" && buttonArray[i][1].getText()=="C" &&
                    buttonArray[i][0].getText()!="C" && buttonArray[i][0].getText()!="P"){

            }
            if(buttonArray[i][2].getText()=="C" && buttonArray[i][0].getText()=="C" &&
                    buttonArray[i][1].getText()!="C" && buttonArray[i][1].getText()!="P"){

            }
            if(buttonArray[i][5].getText()=="C" && buttonArray[i][6].getText()=="C" &&
                    buttonArray[i][7].getText()!="C" && buttonArray[i][7].getText()!="P"){

            }
            if(buttonArray[i][5].getText()=="C" && buttonArray[i][7].getText()=="C" &&
                    buttonArray[i][6].getText()!="C" && buttonArray[i][6].getText()!="P"){

            }
            if(buttonArray[i][7].getText()=="C" && buttonArray[i][6].getText()=="C" &&
                    buttonArray[i][5].getText()!="C" && buttonArray[i][5].getText()!="P"){

            }
            if(buttonArray[i][7].getText()=="C" && buttonArray[i][5].getText()=="C" &&
                    buttonArray[i][6].getText()!="C" && buttonArray[i][6].getText()!="P"){

            }
        }
        return null;
    }
    public Button getComputerButtonHort(){
        for(int i = 0 ; i<=2 ; i++){
            if(buttonArray[i][0].getText()=="C" && buttonArray[i][3].getText()=="C" &&
                    buttonArray[i][5].getText()!="C" && buttonArray[i][5].getText()!="P"){

            }
            if(buttonArray[i][0].getText()=="C" && buttonArray[i][5].getText()=="C" &&
                    buttonArray[i][3].getText()!="C" && buttonArray[i][3].getText()!="P"){

            }
            if(buttonArray[i][5].getText()=="C" && buttonArray[i][3].getText()=="C" &&
                    buttonArray[i][0].getText()!="C" && buttonArray[i][0].getText()!="P"){

            }
            if(buttonArray[i][5].getText()=="C" && buttonArray[i][0].getText()=="C" &&
                    buttonArray[i][3].getText()!="C" && buttonArray[i][3].getText()!="P"){

            }
            if(buttonArray[i][2].getText()=="C" && buttonArray[i][4].getText()=="C" &&
                    buttonArray[i][7].getText()!="C" && buttonArray[i][7].getText()!="P"){

            }
            if(buttonArray[i][2].getText()=="C" && buttonArray[i][7].getText()=="C" &&
                    buttonArray[i][4].getText()!="C" && buttonArray[i][4].getText()!="P"){

            }
            if(buttonArray[i][7].getText()=="C" && buttonArray[i][4].getText()=="C" &&
                    buttonArray[i][2].getText()!="C" && buttonArray[i][2].getText()!="P"){

            }
            if(buttonArray[i][7].getText()=="C" && buttonArray[i][2].getText()=="C" &&
                    buttonArray[i][4].getText()!="C" && buttonArray[i][4].getText()!="P"){

            }
        }
        return null;
    }
    public Button getComputerButtonCrossLines(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4) {
            if(buttonArray[0][numbersInList].getText()=="C" && buttonArray[1][numbersInList].getText()=="C" &&
                    buttonArray[2][numbersInList].getText()!="C" && buttonArray[2][numbersInList].getText()!="P"){

            }
            if(buttonArray[0][numbersInList].getText()=="C" && buttonArray[2][numbersInList].getText()=="C" &&
                    buttonArray[1][numbersInList].getText()!="C" && buttonArray[1][numbersInList].getText()!="P"){

            }
            if(buttonArray[2][numbersInList].getText()=="C" && buttonArray[1][numbersInList].getText()=="C" &&
                    buttonArray[0][numbersInList].getText()!="C" && buttonArray[0][numbersInList].getText()!="P"){

            }
            if(buttonArray[2][numbersInList].getText()=="C" && buttonArray[0][numbersInList].getText()=="C" &&
                    buttonArray[1][numbersInList].getText()!="C" && buttonArray[1][numbersInList].getText()!="P"){

            }

            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return null;
    }

}//end of file
    


