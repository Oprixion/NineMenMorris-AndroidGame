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
    Button[][] buttonOfSquaresArray = new Button[8][8];
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
    String masterControl;
    int numOfRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
        masterControl = "Player";
        numOfRd = 0;
        allButtonOnBoard(buttonOfSquaresArray);
        setAllButtonInArray();
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
        button00 = new Button[]{buttonOfSquaresArray[0][1], buttonOfSquaresArray[0][3]};
        button01 = new Button[]{buttonOfSquaresArray[0][0], buttonOfSquaresArray[1][1], buttonOfSquaresArray[0][2]};
        button02 = new Button[]{buttonOfSquaresArray[0][1], buttonOfSquaresArray[0][4]};
        button03 = new Button[]{buttonOfSquaresArray[0][0], buttonOfSquaresArray[0][5], buttonOfSquaresArray[1][3]};
        button04 = new Button[]{buttonOfSquaresArray[0][2], buttonOfSquaresArray[0][7], buttonOfSquaresArray[1][4]};
        button05 = new Button[]{buttonOfSquaresArray[0][3], buttonOfSquaresArray[0][6]};
        button06 = new Button[]{buttonOfSquaresArray[0][5], buttonOfSquaresArray[1][6], buttonOfSquaresArray[0][7]};
        button07 = new Button[]{buttonOfSquaresArray[0][4], buttonOfSquaresArray[0][6]};
        //middle square
        button10 = new Button[]{buttonOfSquaresArray[1][1], buttonOfSquaresArray[1][3]};
        button11 = new Button[]{buttonOfSquaresArray[1][0], buttonOfSquaresArray[1][2], buttonOfSquaresArray[0][1], buttonOfSquaresArray[2][1]};
        button12 = new Button[]{buttonOfSquaresArray[1][1], buttonOfSquaresArray[1][4]};
        button13 = new Button[]{buttonOfSquaresArray[1][0], buttonOfSquaresArray[1][5], buttonOfSquaresArray[0][3], buttonOfSquaresArray[2][3]};
        button14 = new Button[]{buttonOfSquaresArray[1][2], buttonOfSquaresArray[1][7], buttonOfSquaresArray[0][4], buttonOfSquaresArray[2][4]};
        button15 = new Button[]{buttonOfSquaresArray[1][3], buttonOfSquaresArray[1][6]};
        button16 = new Button[]{buttonOfSquaresArray[1][5], buttonOfSquaresArray[1][7], buttonOfSquaresArray[0][6], buttonOfSquaresArray[2][6]};
        button17 = new Button[]{buttonOfSquaresArray[1][4], buttonOfSquaresArray[1][6]};
        //inner sqaure
        button20 = new Button[]{buttonOfSquaresArray[2][1], buttonOfSquaresArray[2][3]};
        button21 = new Button[]{buttonOfSquaresArray[2][0], buttonOfSquaresArray[1][1], buttonOfSquaresArray[2][2]};
        button22 = new Button[]{buttonOfSquaresArray[2][1], buttonOfSquaresArray[2][4]};
        button23 = new Button[]{buttonOfSquaresArray[2][0], buttonOfSquaresArray[2][5], buttonOfSquaresArray[1][3]};
        button24 = new Button[]{buttonOfSquaresArray[2][2], buttonOfSquaresArray[2][7], buttonOfSquaresArray[1][4]};
        button25 = new Button[]{buttonOfSquaresArray[2][3], buttonOfSquaresArray[2][6]};
        button26 = new Button[]{buttonOfSquaresArray[2][5], buttonOfSquaresArray[2][7], buttonOfSquaresArray[1][6]};
        button27 = new Button[]{buttonOfSquaresArray[2][4], buttonOfSquaresArray[2][6]};
    }

    public void setAllButtonsArray() {
        allButtonsArray = new Button[][]{button00, button01, button02, button03,
                button04, button05, button06, button07, button10, button11, button12, button13,
                button14, button15, button16, button17, button20, button21, button22, button23,
                button24, button25, button26, button27};
    }
    public void setAllButtonInArray(){
        allButtonOfBoard = new Button[]{buttonOfSquaresArray[0][0], buttonOfSquaresArray[0][1], buttonOfSquaresArray[0][2],
                buttonOfSquaresArray[0][3], buttonOfSquaresArray[0][4], buttonOfSquaresArray[0][5], buttonOfSquaresArray[0][6], buttonOfSquaresArray[0][7]
                , buttonOfSquaresArray[1][0], buttonOfSquaresArray[1][1], buttonOfSquaresArray[1][2], buttonOfSquaresArray[1][3],
                buttonOfSquaresArray[1][4], buttonOfSquaresArray[1][5], buttonOfSquaresArray[1][6] ,
                buttonOfSquaresArray[2][0], buttonOfSquaresArray[2][1], buttonOfSquaresArray[2][2], buttonOfSquaresArray[2][3],
                buttonOfSquaresArray[2][4], buttonOfSquaresArray[2][5], buttonOfSquaresArray[2][6], buttonOfSquaresArray[2][7]};
    }
    public void playerOrComputer(View myView) {
        numOfRd++;
        Button playerMove = (Button) myView;
        if (playerPieceOnHand > 0) {
            if (masterControl.equals("Player")) {
                playerTurn(playerMove);
                masterControl = "Computer";
                if (isMill("P", playerMove)) {
                    disableAllButtons();
                    enableComputerMove();
                    masterControl = "Remover";
                }
            } else if (masterControl.equals("Remover")) {
                removeComputerPieceIfMill(playerMove);
                enableAllButtons(buttonOfSquaresArray);
                disableComputerMove();
                disablePlayerMove();
                masterControl = "Computer";
            }


            if (masterControl.equals("Computer")) {
                Button compButtonCrossLines = getComputerButtonCrossLines();
                Button compButtonVert = getComputerButtonVert();
                Button compButtonHort = getComputerButtonHort();
                computerFirstPhaseMoves();
                masterControl = "Player";
                if (isMillComp("C", compButtonCrossLines, compButtonHort, compButtonVert)) {
                    removePlayerPiece();
                }// if
            }
        }


        if (playerPieceOnHand <= 0 && !masterControl.equals("End Game")) {
            if (masterControl.equals("Command")) {
                masterControl = "null";
            }
            if (masterControl.equals("null")) {
                masterControl = "Command";
                return;
            }
            if (!masterControl.equals("Remover")) {
                disableAllButtons();
                enablePlayerMove();
            }
            if (playerMove.getText() == "P") {
                enableAdjacentButtons(playerMove);
                removePlayerPieceWhenMoving(playerMove);
                return;
            } else {
                if (!masterControl.equals("Remover")) {
                    movePlayerPiece(playerMove);
                }
            }
            if (masterControl.equals("Player")) {
                masterControl = "Computer";
                if (isMill("P", playerMove)) {
                    disableAllButtons();
                    enableComputerMove();
                    masterControl = "Remover";
                }
                if(countNumberOfComputerPieces()==3){
                    masterControl ="Third Phase";
                }
            } else if (masterControl.equals("Remover")) {
                removeComputerPieceIfMill(playerMove);
                disableAllButtons();
                enablePlayerMove();
                masterControl = "Computer";
            }


            if (masterControl.equals("Computer")) {
                Button compButtonCrossLines = getComputerButtonCrossLines();
                Button compButtonVert = getComputerButtonVert();
                Button compButtonHort = getComputerButtonHort();
                cpuSecondPhaseMove();
                masterControl = "Player";
                if (isMillComp("C", compButtonCrossLines, compButtonHort, compButtonVert)) {
                    removePlayerPiece();
                }
            }
            if(masterControl.equals("Third Phase")){
                cpuTurnThirdPhase();
                masterControl ="Player";
            }
            if(countNumberOfComputerPieces()<=2 || numOfPlayerPieces()<=2){
                masterControl = "End Game";
                disableAllButtons();
            }
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

    public void computerFirstPhaseMoves() {
        if (numOfRd == 1) {
            firstComputerTurn();
        }
        //Block opponenet trying to make a mill. 1 Priority
        else if (blockOrMillVert("P")!=null || blockOrMillHort("P")!=null ||
                blockOrMillCrossLines("P")!=null) {
            if (blockOrMillVert("P")!=null) {
                blockOrMillVert("P").setEnabled(false);
                blockOrMillVert("P").setText("C");
            } else if (blockOrMillHort("P")!=null) {
                blockOrMillHort("P").setEnabled(false);
                blockOrMillHort("P").setText("C");
            } else if (blockOrMillCrossLines("P")!=null) {
                blockOrMillCrossLines("P").setEnabled(false);
                blockOrMillCrossLines("P").setText("C");
            }
        }
        //Making a mill. 2 priority
        else if (blockOrMillVert("C")!=null || blockOrMillHort("C")!=null ||
                blockOrMillCrossLines("C")!=null) {
            if (blockOrMillVert("C")!=null) {
                blockOrMillVert("C").setEnabled(false);
                blockOrMillVert("C").setText("C");
            } else if (blockOrMillHort("C")!=null) {
                blockOrMillHort("C").setEnabled(false);
                blockOrMillHort("C").setText("C");
            } else if (blockOrMillCrossLines("C")!=null) {
                blockOrMillCrossLines("C").setEnabled(false);
                blockOrMillCrossLines("C").setText("C");
            }
        }
            //Trying to make a mill . 3 priority
         else if (tryingToMakeMillCorners()!=null || tryingToMakeMillMiddleHorizontal()!=null
                || tryingToMakeMillMiddleVertical()!=null || tryingToMakeMillCrossLines()!=null) {
            if (tryingToMakeMillMiddleHorizontal()!=null) {
                tryingToMakeMillMiddleHorizontal().setEnabled(false);
                tryingToMakeMillMiddleHorizontal().setText("C");
            } else if (tryingToMakeMillMiddleVertical()!=null) {
                tryingToMakeMillMiddleVertical().setEnabled(false);
                tryingToMakeMillMiddleVertical().setText("C");
            } else if (tryingToMakeMillCorners()!=null) {
                tryingToMakeMillCorners().setEnabled(false);
                tryingToMakeMillCorners().setText("C");
            } else if (tryingToMakeMillCrossLines()!=null) {
                tryingToMakeMillCrossLines().setEnabled(false);
                tryingToMakeMillCrossLines().setText("C");
            }
        } else if (adjacentToPlayerPiece() != null) {
            adjacentToPlayerPiece().setEnabled(false);
            adjacentToPlayerPiece().setText("C");
        }
        else{
            Button randomSpot= pickRandomButtons();
            randomSpot.setEnabled(false);
            randomSpot.setText("C");
        }
    }

    public Button cpuThirdPhaseMoves(){
        if (blockOrMillVert("P")!=null || blockOrMillHort("P")!=null ||
                blockOrMillCrossLines("P")!=null) {
            if (blockOrMillVert("P")!=null) {
                return blockOrMillVert("P");

            } else if (blockOrMillHort("P")!=null) {
               return blockOrMillHort("P");
            } else if (blockOrMillCrossLines("P")!=null) {
                return blockOrMillCrossLines("P");
            }
        }
        //Making a mill. 2 priority
        else if (blockOrMillVert("C")!=null || blockOrMillHort("C")!=null ||
                blockOrMillCrossLines("C")!=null) {
            if (blockOrMillVert("C")!=null) {
                return blockOrMillVert("C");
            } else if (blockOrMillHort("C")!=null) {
                return blockOrMillHort("C");
            } else if (blockOrMillCrossLines("C")!=null) {
                return blockOrMillCrossLines("C");
            }
        }
        //Trying to make a mill . 3 priority
        else if (tryingToMakeMillCorners()!=null || tryingToMakeMillMiddleHorizontal()!=null
                || tryingToMakeMillMiddleVertical()!=null || tryingToMakeMillCrossLines()!=null) {
            if (tryingToMakeMillMiddleHorizontal()!=null) {
                return tryingToMakeMillMiddleHorizontal();
            } else if (tryingToMakeMillMiddleVertical()!=null) {
               return tryingToMakeMillMiddleVertical();
            } else if (tryingToMakeMillCorners()!=null) {
                return tryingToMakeMillCorners();
            } else if (tryingToMakeMillCrossLines()!=null) {
                return tryingToMakeMillCrossLines();
            }
        } else if (adjacentToPlayerPiece() != null) {
            return adjacentToPlayerPiece();
        }
        return null;
    }
    public void cpuTurnThirdPhase(){
        for(int i = 0; i<allButtonOfBoard.length; i++){
            if(allButtonOfBoard[i].getText()=="C"){
                if(cpuThirdPhaseMoves()!=null) {
                    cpuThirdPhaseMoves().setText("C");
                    cpuThirdPhaseMoves().setEnabled(false);
                    allButtonOfBoard[i].setText(null);
                    return;
                }
            }
        }
    }
    public void disableAllButtons() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                buttonOfSquaresArray[i][j].setEnabled(false);
            }
        }
    }//disableAllButtons

    public int countNumberOfComputerPieces() {
        int numOfCompPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "C") {
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
            }
        }
    }//enableAllPlayerPieces

    public void disableAllPlayerPieces() {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i].getText() != null) {
                playerPiecesArray[i].setEnabled(false);
            }
        }
    }//disableAllPlayerPieces

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
        while (buttonOfSquaresArray[0][cpuFirstPosition].getText() == "P") {
            randomNumber = random.nextInt(4);
            cpuFirstPosition = numberArray[randomNumber];
        }
        buttonOfSquaresArray[0][cpuFirstPosition].setText("C");
        buttonOfSquaresArray[0][cpuFirstPosition].setEnabled(false);

    }//firstComputerTurn
public Button pickRandomButtons(){
        Random random = new Random();
        int randomNumber = random.nextInt(allButtonOfBoard.length);
        Button cpuPiecesRandomSpot= allButtonOfBoard[randomNumber];
        while(cpuPiecesRandomSpot.getText()=="C" || cpuPiecesRandomSpot.getText()=="P"){
            randomNumber=random.nextInt(allButtonOfBoard.length);
            cpuPiecesRandomSpot = allButtonOfBoard[randomNumber];
        }
        return cpuPiecesRandomSpot;
}
    public int numOfPlayerPieces() {
        int numberOfPlayerPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == ("P")) {
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
                if (buttonOfSquaresArray[i][j].getText() == ("P")) {
                    numberOfComputerPieces += 1;
                }//if
            }//inner for loop
        }// outer for loop
        return numberOfComputerPieces;
    }//numOfComputerPieces


    public Button tryingToMakeMillMiddleHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][1].getText() == "C") {
                if (buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                    return buttonOfSquaresArray[i][0];
                } else if (buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                    return buttonOfSquaresArray[i][2];
                }
            }// top of the squares
            if (buttonOfSquaresArray[i][6].getText() == "C") {
                if (buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                    return buttonOfSquaresArray[i][5];
                } else if (buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                    return buttonOfSquaresArray[i][7];
                }
            }// bottom of the squares
        }//for loop
        return null;
    }//tryingToMakeMillMiddleHorizontal



    public Button tryingToMakeMillMiddleVertical() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][3].getText() == "C") {
                if (buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                    return buttonOfSquaresArray[i][0];
                } else if (buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                    return buttonOfSquaresArray[i][5];
                }
            }// left of the squares
            if (buttonOfSquaresArray[i][4].getText() == "C") {
                if (buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                    return buttonOfSquaresArray[i][2];
                } else if (buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                    return buttonOfSquaresArray[i][7];
                }
            }// right of the squares
        }// for loop
        return null;
    }// tryingToMakeMillMiddleVertical

    public Button tryingToMakeMillCorners() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][0].getText() == "C") {
                if (buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                    return buttonOfSquaresArray[i][1];
                } else if (buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                    return buttonOfSquaresArray[i][3];
                }//top left corner
            }
            if (buttonOfSquaresArray[i][2].getText() == "C") {
                if (buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                    return buttonOfSquaresArray[i][1];
                } else if (buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                    return buttonOfSquaresArray[i][4];
                }
            }// top right corner
            if (buttonOfSquaresArray[i][5].getText() == "C") {
                if (buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                    return buttonOfSquaresArray[i][3];
                } else if (buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                    return buttonOfSquaresArray[i][6];
                }
            }//top left corner
            if (buttonOfSquaresArray[i][7].getText() == "C") {
                if (buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                    return buttonOfSquaresArray[i][6];

                } else if (buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                    return buttonOfSquaresArray[i][4];
                }
            }
        }// for loop
        return null;
    }//tryingToMakeMillCorners



    public Button tryingToMakeMillCrossLines() {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonOfSquaresArray[0][numbersInList].getText() == "C") {
                if (buttonOfSquaresArray[1][numbersInList].getText() != "C" &&
                        buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                    return buttonOfSquaresArray[1][numbersInList];
                }
            }
            if (buttonOfSquaresArray[1][numbersInList].getText() == "C") {
                if (buttonOfSquaresArray[0][numbersInList].getText() != "C" &&
                        buttonOfSquaresArray[0][numbersInList].getText() != "P") {
                    return buttonOfSquaresArray[0][numbersInList];

                } else if (buttonOfSquaresArray[2][numbersInList].getText() != "C" &&
                        buttonOfSquaresArray[2][numbersInList].getText() != "P") {
                    return buttonOfSquaresArray[2][numbersInList];
                }
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == "C") {
                if (buttonOfSquaresArray[1][numbersInList].getText() != "C" &&
                        buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                    return buttonOfSquaresArray[1][numbersInList];
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }// end While loop
        return null;
    }//TryingToMakeMillCrossLines

    public void disableComputerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "C") {
                    buttonOfSquaresArray[i][j].setEnabled(false);
                }
            }//inner for loop
        }//outer for loop
    }//disableComputerMove

    public void removePlayerPiece() {
        //check vertical lines
        if (blockOrMillVert("P")!=null) {
            removePlayerPieceIfTryingToMakeMillVert("P");
        }
        //check crosslines
        else if (blockOrMillCrossLines("P")!=null) {
            removePlayerPieceIfTryingToMakeMillCrossLines("P");
        }
        //check horizontal lines
        else if (blockOrMillHort("P")!=null) {
            removePlayerPieceIfTryingToMakeMillHort("P");
        } else {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (buttonOfSquaresArray[i][j].getText() == "P") {
                        removingPieceFromArray(buttonOfSquaresArray[i][j]);
                        buttonOfSquaresArray[i][j].setText(null);
                        return;
                    }
                }
            }
        }
    }//removePlayerPiece
public void removingPieceFromArray(Button pieceToBeRemoved){
    for(int e = 0 ; e<playerPiecesArray.length ; e++){
        if(pieceToBeRemoved==playerPiecesArray[e]){
            playerPiecesArray[e]=null;
        }
    }
}
    public void removePlayerPieceIfTryingToMakeMillVert(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                buttonOfSquaresArray[i][2].setText(null);
                return;
            }//top line of squares scanning forward
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                buttonOfSquaresArray[i][1].setText(null);
                return;
            }//top line of squares scanning forward inBetween
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                buttonOfSquaresArray[i][0].setText(null);
                return;
            }//top line of squares scanning backward
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                buttonOfSquaresArray[i][1].setText(null);
                return;
            }//top line of squares Scanning backward inBetween
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                buttonOfSquaresArray[i][7].setText(null);
                return;
            }//bottom line of squares Scanning forward
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                buttonOfSquaresArray[i][6].setText(null);
                return;
            }// bottom line of squares forward inBetween
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                buttonOfSquaresArray[i][5].setText(null);
                return;
            }//bottom line of squares scanning backward
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                buttonOfSquaresArray[i][6].setText(null);
                return;
            }// bottom line of squares scanning backward inBetween
        }
    }//removePlayerPieceIfTryingToMakeMillVert

    public void removePlayerPieceIfTryingToMakeMillHort(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                buttonOfSquaresArray[i][5].setText(null);
                return;
            }// right side of squares scanning downward
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                buttonOfSquaresArray[i][3].setText(null);
                return;
            }//right side of squares scanning downward inbetween
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                buttonOfSquaresArray[i][0].setText(null);
                return;
            }//right side of squares scanning upward
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                buttonOfSquaresArray[i][3].setText(null);
                return;
            }//right side of squares scanning upward in between
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                buttonOfSquaresArray[i][7].setText(null);
                return;
            }// left side of squares scanning downward
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                buttonOfSquaresArray[i][4].setText(null);
                return;
            }//left side of squares scanning downward in between
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                buttonOfSquaresArray[i][2].setText(null);
                return;
            }// left side of squares scanning upward
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                buttonOfSquaresArray[i][4].setText(null);
                return;
            }// left side of squares scanning upward
        }
    }//removePlayerPieceIfTryingToMakeMillHort

    public void removePlayerPieceIfTryingToMakeMillCrossLines(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            //scanning all four cross lines
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[2][numbersInList].getText() != "C" && buttonOfSquaresArray[2][numbersInList].getText() != "P") {
                buttonOfSquaresArray[2][numbersInList].setText(null);
                return;
            }
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[2][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                buttonOfSquaresArray[1][numbersInList].setText(null);
                return;
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[0][numbersInList].getText() != "C" && buttonOfSquaresArray[0][numbersInList].getText() != "P") {
                buttonOfSquaresArray[0][numbersInList].setText(null);
                return;
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[0][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                buttonOfSquaresArray[1][numbersInList].setText(null);
                return;
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
    }//removePlayerPieceIfTryingToMakeMillCrossLines

    public void enableComputerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "C") {
                    buttonOfSquaresArray[i][j].setEnabled(true);
                }
            }
        }
    }//enableComputerMove

    public void enablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "P") {
                    buttonOfSquaresArray[i][j].setEnabled(true);
                }
            }
        }
    }//enablePlayerMove

    public void disablePlayerMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "P") {
                    buttonOfSquaresArray[i][j].setEnabled(false);
                }
            }//Inner
        }// Outer
    }//disablePlayerMove

    public void removeComputerPieceIfMill(Button removedButton) {
        removedButton.setText(null);
        removedButton.setEnabled(false);
    }//removeIfMill

    public void removePlayerPieceWhenMoving(Button playerMove) {
        for (int i = 0; i <= 8; i++) {
            if (playerPiecesArray[i] == playerMove) {
                indexOfPlayerPieceToRemove = i;
                return;
            }
        }//for loop
    }//removePlayerPieceWhenMoving

    public void movePlayerPiece(Button playerMove) {
        if (playerMove.getText() != "P" && playerMove.getText() != "C") {
            playerMove.setText("P");
            playerPiecesArray[indexOfPlayerPieceToRemove].setText(null);
            playerPiecesArray[indexOfPlayerPieceToRemove] = playerMove;
            playerPiecesArray[indexOfPlayerPieceToRemove].setEnabled(true);
        }
    }//movePlayerPiece

    public void enableAdjacentButtons(Button playerMove) {
        if (playerMove == buttonOfSquaresArray[0][0]) {
            for (int i = 0; i < button00.length; i++) {
                if ((button00[i].getText() != "C") && (button00[i].getText() != "P")) {
                    button00[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][1]) {
            for (int i = 0; i < button01.length; i++) {
                if ((button01[i].getText() != "C") && (button01[i].getText() != "P")) {
                    button01[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][2]) {
            for (int i = 0; i < button02.length; i++) {
                if ((button02[i].getText() != "C") && (button02[i].getText() != "P")) {
                    button02[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][3]) {
            for (int i = 0; i < button03.length; i++) {
                if ((button03[i].getText() != "C") && (button03[i].getText() != "P")) {
                    button03[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][4]) {
            for (int i = 0; i < button04.length; i++) {
                if ((button04[i].getText() != "C") && (button04[i].getText() != "P")) {
                    button04[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][5]) {
            for (int i = 0; i < button05.length; i++) {
                if ((button05[i].getText() != "C") && (button05[i].getText() != "P")) {
                    button05[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][6]) {
            for (int i = 0; i < button06.length; i++) {
                if ((button06[i].getText() != "C") && (button06[i].getText() != "P")) {
                    button06[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][7]) {
            for (int i = 0; i < button07.length; i++) {
                if ((button07[i].getText() != "C") && (button07[i].getText() != "P")) {
                    button07[i].setEnabled(true);
                }
            }
        }

        //If the chosen button is in the second square
        if (playerMove == buttonOfSquaresArray[1][0]) {
            for (int i = 0; i < button10.length; i++) {
                if ((button10[i].getText() != "C") && (button10[i].getText() != "P")) {
                    button10[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][1]) {
            for (int i = 0; i < button11.length; i++) {
                if ((button11[i].getText() != "C") && (button11[i].getText() != "P")) {
                    button11[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][2]) {
            for (int i = 0; i < button12.length; i++) {
                if ((button12[i].getText() != "C") && (button12[i].getText() != "P")) {
                    button12[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][3]) {
            for (int i = 0; i < button13.length; i++) {
                if ((button13[i].getText() != "C") && (button13[i].getText() != "P")) {
                    button13[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][4]) {
            for (int i = 0; i < button14.length; i++) {
                if ((button14[i].getText() != "C") && (button14[i].getText() != "P")) {
                    button14[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][5]) {
            for (int i = 0; i < button15.length; i++) {
                if ((button15[i].getText() != "C") && (button15[i].getText() != "P")) {
                    button15[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][6]) {
            for (int i = 0; i < button16.length; i++) {
                if ((button16[i].getText() != "C") && (button16[i].getText() != "P")) {
                    button16[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][7]) {
            for (int i = 0; i < button17.length; i++) {
                if ((button17[i].getText() != "C") && (button17[i].getText() != "P")) {
                    button17[i].setEnabled(true);
                }
            }
        }

        //If the chosen button is in the third square
        if (playerMove == buttonOfSquaresArray[2][0]) {
            for (int i = 0; i < button20.length; i++) {
                if ((button20[i].getText() != "C") && (button20[i].getText() != "P")) {
                    button20[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][1]) {
            for (int i = 0; i < button21.length; i++) {
                if ((button21[i].getText() != "C") && (button21[i].getText() != "P")) {
                    button21[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][2]) {
            for (int i = 0; i < button22.length; i++) {
                if ((button22[i].getText() != "C") && (button22[i].getText() != "P")) {
                    button22[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][3]) {
            for (int i = 0; i < button23.length; i++) {
                if ((button23[i].getText() != "C") && (button23[i].getText() != "P")) {
                    button23[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][4]) {
            for (int i = 0; i < button24.length; i++) {
                if ((button24[i].getText() != "C") && (button24[i].getText() != "P")) {
                    button24[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][5]) {
            for (int i = 0; i < button25.length; i++) {
                if ((button25[i].getText() != "C") && (button25[i].getText() != "P")) {
                    button25[i].setEnabled(true);
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][6]) {
            for (int i = 0; i < button26.length; i++) {
                if ((button26[i].getText() != "C") && (button26[i].getText() != "P")) {
                    button26[i].setEnabled(true);
                }
            }
        }

        if (playerMove == buttonOfSquaresArray[2][7]) {
            for (int i = 0; i < button27.length; i++) {
                if ((button27[i].getText() != "C") && (button27[i].getText() != "P")) {
                    button27[i].setEnabled(true);
                }
            }
        }
    }

    private Button returnEnableAdjacentButtons(Button playerMove) {
        if (playerMove == buttonOfSquaresArray[0][0]) {
            for (int i = 0; i < button00.length; i++) {
                if ((button00[i].getText() != "C") && (button00[i].getText() != "P")) {
                    return button00[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][1]) {
            for (int i = 0; i < button01.length; i++) {
                if ((button01[i].getText() != "C") && (button01[i].getText() != "P")) {
                    return button01[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][2]) {
            for (int i = 0; i < button02.length; i++) {
                if ((button02[i].getText() != "C") && (button02[i].getText() != "P")) {
                    return button02[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][3]) {
            for (int i = 0; i < button03.length; i++) {
                if ((button03[i].getText() != "C") && (button03[i].getText() != "P")) {
                    return button03[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][4]) {
            for (int i = 0; i < button04.length; i++) {
                if ((button04[i].getText() != "C") && (button04[i].getText() != "P")) {
                    return button04[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][5]) {
            for (int i = 0; i < button05.length; i++) {
                if ((button05[i].getText() != "C") && (button05[i].getText() != "P")) {
                    return button05[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][6]) {
            for (int i = 0; i < button06.length; i++) {
                if ((button06[i].getText() != "C") && (button06[i].getText() != "P")) {
                    return button06[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[0][7]) {
            for (int i = 0; i < button07.length; i++) {
                if ((button07[i].getText() != "C") && (button07[i].getText() != "P")) {
                    return button07[i];
                }
            }
        }

        //If the chosen button is in the second square
        if (playerMove == buttonOfSquaresArray[1][0]) {
            for (int i = 0; i < button10.length; i++) {
                if ((button10[i].getText() != "C") && (button10[i].getText() != "P")) {
                    return button10[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][1]) {
            for (int i = 0; i < button11.length; i++) {
                if ((button11[i].getText() != "C") && (button11[i].getText() != "P")) {
                    return button11[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][2]) {
            for (int i = 0; i < button12.length; i++) {
                if ((button12[i].getText() != "C") && (button12[i].getText() != "P")) {
                    return button12[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][3]) {
            for (int i = 0; i < button13.length; i++) {
                if ((button13[i].getText() != "C") && (button13[i].getText() != "P")) {
                    return button13[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][4]) {
            for (int i = 0; i < button14.length; i++) {
                if ((button14[i].getText() != "C") && (button14[i].getText() != "P")) {
                    return button14[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][5]) {
            for (int i = 0; i < button15.length; i++) {
                if ((button15[i].getText() != "C") && (button15[i].getText() != "P")) {
                    return button15[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][6]) {
            for (int i = 0; i < button16.length; i++) {
                if ((button16[i].getText() != "C") && (button16[i].getText() != "P")) {
                    return button16[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[1][7]) {
            for (int i = 0; i < button17.length; i++) {
                if ((button17[i].getText() != "C") && (button17[i].getText() != "P")) {
                    return button17[i];
                }
            }
        }

        //If the chosen button is in the third square
        if (playerMove == buttonOfSquaresArray[2][0]) {
            for (int i = 0; i < button20.length; i++) {
                if ((button20[i].getText() != "C") && (button20[i].getText() != "P")) {
                    return button20[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][1]) {
            for (int i = 0; i < button21.length; i++) {
                if ((button21[i].getText() != "C") && (button21[i].getText() != "P")) {
                    return button21[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][2]) {
            for (int i = 0; i < button22.length; i++) {
                if ((button22[i].getText() != "C") && (button22[i].getText() != "P")) {
                    return button22[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][3]) {
            for (int i = 0; i < button23.length; i++) {
                if ((button23[i].getText() != "C") && (button23[i].getText() != "P")) {
                    return button23[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][4]) {
            for (int i = 0; i < button24.length; i++) {
                if ((button24[i].getText() != "C") && (button24[i].getText() != "P")) {
                    return button24[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][5]) {
            for (int i = 0; i < button25.length; i++) {
                if ((button25[i].getText() != "C") && (button25[i].getText() != "P")) {
                    return button25[i];
                }
            }
        }
        if (playerMove == buttonOfSquaresArray[2][6]) {
            for (int i = 0; i < button26.length; i++) {
                if ((button26[i].getText() != "C") && (button26[i].getText() != "P")) {
                    return button26[i];
                }
            }
        }

        if (playerMove == buttonOfSquaresArray[2][7]) {
            for (int i = 0; i < button27.length; i++) {
                if ((button27[i].getText() != "C") && (button27[i].getText() != "P")) {
                    return button27[i];
                }
            }
        }
        return null;
    }// enableAdjacentButtons

    public Button generateRandomButtonsForCompTurn() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]) != null) {
                    return buttonOfSquaresArray[i][j];
                }
            }// inner for loop
        }// outer for loop
        return null;
    }//generateRandomButtonsForCompTurn

    public void cpuSecondPhaseMove() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (returnMillSecondPhaseVertButton("P") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseVertButton("P"))) {
                    returnMillSecondPhaseVertButton("P").setEnabled(false);
                    returnMillSecondPhaseVertButton("P").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                } else if (returnMillSecondPhaseHortButton("P") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseHortButton("C"))) {
                    returnMillSecondPhaseHortButton("C").setEnabled(false);
                    returnMillSecondPhaseHortButton("C").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                    return;
                }
                else if (returnMillSecondPhaseCrossLinesButton("P") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseCrossLinesButton("P"))) {
                    returnMillSecondPhaseCrossLinesButton("P").setEnabled(false);
                    returnMillSecondPhaseCrossLinesButton("P").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                    return;
                }
                else  if (returnMillSecondPhaseVertButton("C") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseVertButton("C"))) {
                    returnMillSecondPhaseVertButton("C").setEnabled(false);
                    returnMillSecondPhaseVertButton("C").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                } else if (returnMillSecondPhaseHortButton("C") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseHortButton("C"))) {
                    returnMillSecondPhaseHortButton("C").setEnabled(false);
                    returnMillSecondPhaseHortButton("C").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                    return;
                }
                else if (returnMillSecondPhaseCrossLinesButton("C") != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == returnMillSecondPhaseCrossLinesButton("C"))) {
                    returnMillSecondPhaseCrossLinesButton("C").setEnabled(false);
                    returnMillSecondPhaseCrossLinesButton("C").setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
                    return;
                }
                //mill method
                else if (returnEnableAdjacentButtons(ifMillSecondPhaseReturnAdjacentButtons()) != null) {
                    returnEnableAdjacentButtons(ifMillSecondPhaseReturnAdjacentButtons()).setEnabled(false);
                    returnEnableAdjacentButtons(ifMillSecondPhaseReturnAdjacentButtons()).setText("C");
                    ifMillSecondPhaseSquares().setText(null);
                    return;
                }
                else if (returnEnableAdjacentButtons(ifMillSecondPhaseCrossLinesReturnAdjacentButtons()) != null) {
                    returnEnableAdjacentButtons(ifMillSecondPhaseCrossLinesReturnAdjacentButtons()).setEnabled(false);
                    returnEnableAdjacentButtons(ifMillSecondPhaseCrossLinesReturnAdjacentButtons()).setText("C");
                    ifMillSecondPhaseCrossLines().setText(null);
                    return;
                }
                else if (tryingToMakeAMillSecondPhrase() != null && buttonOfSquaresArray[i][j].getText() == "C" && (returnEnableAdjacentButtons
                        (buttonOfSquaresArray[i][j]) == tryingToMakeAMillSecondPhrase())) {
                    tryingToMakeAMillSecondPhrase().setEnabled(false);
                    tryingToMakeAMillSecondPhrase().setText("C");
                    buttonOfSquaresArray[i][j].setText(null);
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

    public void cpuMakeRandomMove(){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]) != null) {
                    returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]).setEnabled(false);
                    returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]).setText("C");
                    if (buttonOfSquaresArray[i][j].getText() == "C") {
                        buttonOfSquaresArray[i][j].setText(null);
                        return;
                    }
                }
            }// inner for loop
        }//outer for loop
    }//cpuMakeRandomMove

    public Button returnComputerEnabledSpot(Button compMove) {
        return returnEnableAdjacentButtons(compMove);
    }//returnComputerEnabledSpot

    public boolean isMillVertical(String playerOrComputerPiece, Button playerMove) {
        for (int i = 0; i <= 2; i++) {
            if (playerMove == buttonOfSquaresArray[i][0] ||
                    playerMove == buttonOfSquaresArray[i][1] || playerMove == buttonOfSquaresArray[i][2]) {
                if (buttonOfSquaresArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonOfSquaresArray[i][1].getText() == playerOrComputerPiece) {
                        if (buttonOfSquaresArray[i][2].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if (playerMove == buttonOfSquaresArray[i][7] ||
                    playerMove == buttonOfSquaresArray[i][6] || playerMove == buttonOfSquaresArray[i][5]) {
                if (buttonOfSquaresArray[i][7].getText() == playerOrComputerPiece) {
                    if (buttonOfSquaresArray[i][6].getText() == playerOrComputerPiece) {
                        if (buttonOfSquaresArray[i][5].getText() == playerOrComputerPiece) {
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
            if (playerMove == buttonOfSquaresArray[i][0] || playerMove == buttonOfSquaresArray[i][3] ||
                    playerMove == buttonOfSquaresArray[i][5]) {
                if (buttonOfSquaresArray[i][0].getText() == playerOrComputerPiece) {
                    if (buttonOfSquaresArray[i][3].getText() == playerOrComputerPiece) {
                        if (buttonOfSquaresArray[i][5].getText() == playerOrComputerPiece) {
                            return true;
                        }
                    }
                }
            }
            if (playerMove == buttonOfSquaresArray[i][2] || playerMove == buttonOfSquaresArray[i][4]
                    || playerMove == buttonOfSquaresArray[i][7]) {
                if (buttonOfSquaresArray[i][2].getText() == playerOrComputerPiece) {
                    if (buttonOfSquaresArray[i][4].getText() == playerOrComputerPiece) {
                        if (buttonOfSquaresArray[i][7].getText() == playerOrComputerPiece) {
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
            if (playerMove == buttonOfSquaresArray[0][numbersInList] || playerMove == buttonOfSquaresArray[1]
                    [numbersInList] || playerMove == buttonOfSquaresArray[2][numbersInList]) {
                if (buttonOfSquaresArray[0][numbersInList].getText() == playerOrComputerPiece) {
                    if (buttonOfSquaresArray[1][numbersInList].getText() == playerOrComputerPiece) {
                        if (buttonOfSquaresArray[2][numbersInList].getText() == playerOrComputerPiece) {
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
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][1].getText() == "C" &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                return buttonOfSquaresArray[i][2];
            }
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][2].getText() == "C" &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                return buttonOfSquaresArray[i][1];
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][1].getText() == "C" &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                return buttonOfSquaresArray[i][0];
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][0].getText() == "C" &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                return buttonOfSquaresArray[i][1];
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][6].getText() == "C" &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                return buttonOfSquaresArray[i][7];
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C" &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                return buttonOfSquaresArray[i][6];
            }
            if (buttonOfSquaresArray[i][7].getText() == "C" && buttonOfSquaresArray[i][6].getText() == "C" &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                return buttonOfSquaresArray[i][5];
            }
            if (buttonOfSquaresArray[i][7].getText() == "C" && buttonOfSquaresArray[i][5].getText() == "C" &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                return buttonOfSquaresArray[i][6];
            }
        }
        return null;
    }//getComputerButtonVertical

    public Button blockOrMillVert(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                return buttonOfSquaresArray[i][2];

            }
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                return buttonOfSquaresArray[i][1];
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                return buttonOfSquaresArray[i][0];
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece &&
                    buttonOfSquaresArray[i][1].getText() != "C" && buttonOfSquaresArray[i][1].getText() != "P") {
                return buttonOfSquaresArray[i][1];
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                return buttonOfSquaresArray[i][7];
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                return buttonOfSquaresArray[i][6];
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                return buttonOfSquaresArray[i][5];
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece &&
                    buttonOfSquaresArray[i][6].getText() != "C" && buttonOfSquaresArray[i][6].getText() != "P") {
                return buttonOfSquaresArray[i][6];
            }
        }
        return null;
    }//blockOrMillVertical


    public Button getComputerButtonHort() {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][3].getText() == "C" &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
                return buttonOfSquaresArray[i][5];
            }
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][5].getText() == "C" &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                return buttonOfSquaresArray[i][3];
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][3].getText() == "C" &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                return buttonOfSquaresArray[i][0];
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][0].getText() == "C" &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                return buttonOfSquaresArray[i][3];
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][4].getText() == "C" &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                return buttonOfSquaresArray[i][7];
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C" &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                return buttonOfSquaresArray[i][4];
            }
            if (buttonOfSquaresArray[i][7].getText() == "C" && buttonOfSquaresArray[i][4].getText() == "C" &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                return buttonOfSquaresArray[i][2];
            }
            if (buttonOfSquaresArray[i][7].getText() == "C" && buttonOfSquaresArray[i][2].getText() == "C" &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                return buttonOfSquaresArray[i][4];
            }
        }
        return null;
    }//getComputerButtonHorizontal

    public Button blockOrMillHort(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece &&
                    buttonOfSquaresArray[i][5].getText() != "C" && buttonOfSquaresArray[i][5].getText() != "P") {
               return buttonOfSquaresArray[i][5];

            }
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                return buttonOfSquaresArray[i][3];
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece &&
                    buttonOfSquaresArray[i][0].getText() != "C" && buttonOfSquaresArray[i][0].getText() != "P") {
                return buttonOfSquaresArray[i][0];
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece &&
                    buttonOfSquaresArray[i][3].getText() != "C" && buttonOfSquaresArray[i][3].getText() != "P") {
                return buttonOfSquaresArray[i][3];
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece &&
                    buttonOfSquaresArray[i][7].getText() != "C" && buttonOfSquaresArray[i][7].getText() != "P") {
                return buttonOfSquaresArray[i][7];
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                return buttonOfSquaresArray[i][4];
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece &&
                    buttonOfSquaresArray[i][2].getText() != "C" && buttonOfSquaresArray[i][2].getText() != "P") {
                return buttonOfSquaresArray[i][2];
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece &&
                    buttonOfSquaresArray[i][4].getText() != "C" && buttonOfSquaresArray[i][4].getText() != "P") {
                return buttonOfSquaresArray[i][4];
            }
        }
        return null;
    }//blockOrMillHorizontal



    public Button getComputerButtonCrossLines() {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonOfSquaresArray[0][numbersInList].getText() == "C" && buttonOfSquaresArray[1][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[2][numbersInList].getText() != "C" && buttonOfSquaresArray[2][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[2][numbersInList];
            }
            if (buttonOfSquaresArray[0][numbersInList].getText() == "C" && buttonOfSquaresArray[2][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[1][numbersInList];
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == "C" && buttonOfSquaresArray[1][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[0][numbersInList].getText() != "C" && buttonOfSquaresArray[0][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[0][numbersInList];
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == "C" && buttonOfSquaresArray[0][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[1][numbersInList];
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//getCompterButtonCrossLines

    public Button blockOrMillCrossLines(String whichPiece) {
        int[] numberArray = {1, 3, 4, 6, 0};
        int numInListCounter = 0;
        int numbersInList = numberArray[numInListCounter];
        while (numInListCounter < 4) {
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[2][numbersInList].getText() != "C" && buttonOfSquaresArray[2][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[2][numbersInList];

            }
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[2][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[1][numbersInList];
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[0][numbersInList].getText() != "C" && buttonOfSquaresArray[0][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[0][numbersInList];
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[0][numbersInList].getText() == whichPiece &&
                    buttonOfSquaresArray[1][numbersInList].getText() != "C" && buttonOfSquaresArray[1][numbersInList].getText() != "P") {
                return buttonOfSquaresArray[1][numbersInList];
            }

            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//blockOrMillCrossLines



    public Button returnMillSecondPhaseVertButton(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]) == buttonOfSquaresArray[i][2]) {
                    return buttonOfSquaresArray[i][2];
                }
            }
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) == buttonOfSquaresArray[i][1]) {
                    return buttonOfSquaresArray[i][1];
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][1].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]) == buttonOfSquaresArray[i][0]) {
                    return buttonOfSquaresArray[i][0];
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) == buttonOfSquaresArray[i][1]) {
                    return buttonOfSquaresArray[i][1];
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]) == buttonOfSquaresArray[i][7]) {
                    return buttonOfSquaresArray[i][7];
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) == buttonOfSquaresArray[i][6]) {
                    return buttonOfSquaresArray[i][6];
                }
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][6].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]) == buttonOfSquaresArray[i][5]) {
                    return buttonOfSquaresArray[i][7];
                }
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) == buttonOfSquaresArray[i][6]) {
                    return buttonOfSquaresArray[i][6];
                }
            }
        }
        return null;
    }//returnMillSecondPhaseVertButton

    public Button returnMillSecondPhaseHortButton(String whichPiece) {
        for (int i = 0; i <= 2; i++) {
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]) == buttonOfSquaresArray[i][5]) {
                    return buttonOfSquaresArray[i][5];
                }
            }
            if (buttonOfSquaresArray[i][0].getText() == whichPiece && buttonOfSquaresArray[i][5].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) == buttonOfSquaresArray[i][3]) {
                    return buttonOfSquaresArray[i][3];
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][3].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]) == buttonOfSquaresArray[i][0]) {
                    return buttonOfSquaresArray[i][0];
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == whichPiece && buttonOfSquaresArray[i][0].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) == buttonOfSquaresArray[i][3]) {
                    return buttonOfSquaresArray[i][3];
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]) == buttonOfSquaresArray[i][7]) {
                    return buttonOfSquaresArray[i][7];
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == whichPiece && buttonOfSquaresArray[i][7].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) == buttonOfSquaresArray[i][4]) {
                    return buttonOfSquaresArray[i][4];
                }
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][4].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]) == buttonOfSquaresArray[i][2]) {
                    return buttonOfSquaresArray[i][2];
                }
            }
            if (buttonOfSquaresArray[i][7].getText() == whichPiece && buttonOfSquaresArray[i][2].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) == buttonOfSquaresArray[i][4]) {
                    return buttonOfSquaresArray[i][4];
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
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[1][numbersInList]) == buttonOfSquaresArray[2][numbersInList]) {
                    return buttonOfSquaresArray[2][numbersInList];
                }
            }
            if (buttonOfSquaresArray[0][numbersInList].getText() == whichPiece && buttonOfSquaresArray[2][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[2][numbersInList]) == buttonOfSquaresArray[1][numbersInList]) {
                    return buttonOfSquaresArray[1][numbersInList];
                }
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[1][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[1][numbersInList]) == buttonOfSquaresArray[0][numbersInList]) {
                    return buttonOfSquaresArray[0][numbersInList];
                }
            }
            if (buttonOfSquaresArray[2][numbersInList].getText() == whichPiece && buttonOfSquaresArray[0][numbersInList].getText() == whichPiece) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[0][numbersInList]) == buttonOfSquaresArray[1][numbersInList]) {
                    return buttonOfSquaresArray[1][numbersInList];
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockOrMillCrossLine

    public Button tryingToMakeAMillSecondPhrase() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][1].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]);
                }
            }// top of the squares
            if (buttonOfSquaresArray[i][6].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]);
                }
            }// bottom of the squares
            if (buttonOfSquaresArray[i][3].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]);
                }
            }// left lines of the squares
            if (buttonOfSquaresArray[i][4].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]);
                }
            }// right lines of the squares

            if (buttonOfSquaresArray[i][0].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]);
                }
            }// top left corner of squares
            if (buttonOfSquaresArray[i][2].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]);
                }
            }// top right corner of squares
            if (buttonOfSquaresArray[i][5].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]);
                }
            }// bottom left corner of squares
            if (buttonOfSquaresArray[i][7].getText() == "C" && returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) != null) {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]).getText() != "C" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]).getText() != "P") {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]);
                }
            }// bottom right corner of squares

        }//for loop
        return null;
    }//tryingToMakeMillMiddleHorizontal

    public Button ifMillSecondPhaseSquares() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][2].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) != null) {
                    return buttonOfSquaresArray[i][0];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]) != null) {
                    return buttonOfSquaresArray[i][1];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) != null) {
                    return buttonOfSquaresArray[i][2];
                }
            }
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][3].getText() == "C" && buttonOfSquaresArray[i][5].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) != null) {
                    return buttonOfSquaresArray[i][0];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]) != null) {
                    return buttonOfSquaresArray[i][3];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) != null) {
                    return buttonOfSquaresArray[i][5];
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][4].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) != null) {
                    return buttonOfSquaresArray[i][2];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]) != null) {
                    return buttonOfSquaresArray[i][4];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) != null) {
                    return buttonOfSquaresArray[i][7];
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][6].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) != null) {
                    return buttonOfSquaresArray[i][5];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]) != null) {
                    return buttonOfSquaresArray[i][6];
                } else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) != null) {
                    return buttonOfSquaresArray[i][7];
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
            if (buttonOfSquaresArray[0][numbersInList].getText() == "C" && buttonOfSquaresArray[1][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[2][numbersInList].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[0][numbersInList]) != null) {
                    return buttonOfSquaresArray[0][numbersInList];
                }
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[1][numbersInList]) != null) {
                    return buttonOfSquaresArray[1][numbersInList];
                }
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[2][numbersInList]) != null) {
                    return buttonOfSquaresArray[2][numbersInList];
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockrMillCrossLine
    public Button ifMillSecondPhaseReturnAdjacentButtons() {
        for (int i = 0; i < 3; i++) {
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][2].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][1]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]);
                }
            }
            if (buttonOfSquaresArray[i][0].getText() == "C" && buttonOfSquaresArray[i][3].getText() == "C" && buttonOfSquaresArray[i][5].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][0]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][3]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]);
                }
            }
            if (buttonOfSquaresArray[i][2].getText() == "C" && buttonOfSquaresArray[i][4].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][2]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][4]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]);
                }
            }
            if (buttonOfSquaresArray[i][5].getText() == "C" && buttonOfSquaresArray[i][6].getText() == "C" && buttonOfSquaresArray[i][7].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][5]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][6]);
                }
                else if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[i][7]);
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
            if (buttonOfSquaresArray[0][numbersInList].getText() == "C" && buttonOfSquaresArray[1][numbersInList].getText() == "C" &&
                    buttonOfSquaresArray[2][numbersInList].getText() == "C") {
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[0][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[0][numbersInList]);
                }
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[1][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[1][numbersInList]);
                }
                if (returnEnableAdjacentButtons(buttonOfSquaresArray[2][numbersInList]) != null) {
                    return returnEnableAdjacentButtons(buttonOfSquaresArray[2][numbersInList]);
                }
            }
            numInListCounter += 1;
            numbersInList = numberArray[numInListCounter];
        }//while loop
        return null;
    }//isBLockrMillCrossLine

    public Button adjacentToPlayerPiece() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (buttonOfSquaresArray[i][j].getText() == "P" &&
                        returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]) != null) {
                    if (returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]).getText() != "P"
                            && returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]).getText() != "C") {
                        return returnEnableAdjacentButtons(buttonOfSquaresArray[i][j]);
                    }

                }
            }// inner for loop
        }//outer for loop
        return null;
    }// adjacentToPlayerPiece
}// end file


