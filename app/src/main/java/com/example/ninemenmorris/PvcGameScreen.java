package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class PvcGameScreen extends AppCompatActivity {
     Button[][] buttonArray = new Button [8][8];
     String playerPiece;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_game_screen);
        playerPiece= "P";
        buttonsBoard(buttonArray);




    }
    public void buttonsBoard(Button [][] gameBoard) {
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
    public void playerOrComputer(View myView){
        Button myButton = (Button) myView;
        myButton.setText(playerPiece);
        myButton.setEnabled(false);
        if (playerPiece.equals("P")){
            computerTurn();
        }
        else {
            playerPiece = "P";
        }
    }

    public void computerTurn(){
        if(isComputerFirstTurn(buttonArray)) {
            firstComputerTurn();
        }
        else if(isBlockMoveFirstOp() || isBlockMoveSecondOp() ||
                isBlockMoveCrossLines1() || isBlockMoveCrossLines2()
                || isBlockMoveCrossLinesInBetween() || isBlockMoveInBetween()) {
            if (isBlockMoveFirstOp()) {
                buttonArray[blockMoveReturnRowsFirstOp()]
                        [blockMoveReturnColsFirstOp()].setText("C");
            } else if (isBlockMoveSecondOp()) {
                buttonArray[blockMoveReturnRowsSecondOp()]
                        [blockMoveReturnColsSecondOp()].setText("C");
            } else if (isBlockMoveCrossLines1()) {
                buttonArray[blockMoveCrossLinesReturnRows1()]
                        [blockMoveCrossLinesReturnCols1()].setText("C");
            } else if (isBlockMoveCrossLines2()) {
                buttonArray[blockMoveCrossLinesReturnRows2()]
                        [blockMoveCrossLinesReturnCols2()].setText("C");
            } else if (isBlockMoveInBetween()) {
                buttonArray[blockMoveInBetweenReturnRow()]
                        [blockMoveInBetweenReturnCol()].setText("C");
            } else if (isBlockMoveCrossLinesInBetween()) {
                buttonArray[blockMoveCrossLinesInBetweenReturnRow()]
                        [blockMoveCrossLinesInBetweenReturnCol()].setText("C");
            }
        }
        else if(isMakeMillCrossLines1()|| isMakeMillCrossLines2()
                ||isMakeMillFirstOp() || isMakeMillSecondOp() || isMakeMillInBetween()
        || isMakeMillCrossLinesInBetween()){
            if (isMakeMillFirstOp()) {
                buttonArray[makeMillReturnRowsFirstOp()]
                        [makeMillReturnColsFirstOp()].setText("C");
            } else if (isMakeMillSecondOp()) {
                buttonArray[makeMillReturnRowsSecondOp()]
                        [makeMillReturnColsSecondOp()].setText("C");
            } else if (isMakeMillCrossLines1()) {
                buttonArray[makeMillCrossLinesReturnRows1()]
                        [makeMillCrossLinesReturnCols1()].setText("C");
            } else if (isMakeMillCrossLines2()) {
                buttonArray[makeMillCrossLinesReturnRows2()]
                        [makeMillCrossLinesReturnCols2()].setText("C");
            } else if (isMakeMillInBetween()) {
                buttonArray[makeMillInBetweenReturnRow()]
                        [makeMillInBetweenReturnCol()].setText("C");
            } else if (isMakeMillCrossLinesInBetween()) {
                buttonArray[makeMillCrossLinesInBetweenReturnRow()]
                        [makeMillCrossLinesInBetweenReturnCol()].setText("C");
            }
        }
    }
    public void disableAllButtons(Button[][] gameBoard ) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                gameBoard[i][j].setEnabled(false);
            }
        }
    }//disableAllButtons
        public void enableAllButtons(Button[][] gameBoard){
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 7; j++) {
                    gameBoard[i][j].setEnabled(true);
                }
            }
        }//enableAllButtons
    public void firstComputerTurn(){
        int[] numberArray = {0,2,5,7};
        Random random = new Random();
        int  randomNumber= random.nextInt(4);
        int cpuFirstPosition = numberArray[randomNumber];
        while(buttonArray[0][cpuFirstPosition].getText()=="P"){
            randomNumber = random.nextInt(4);
            cpuFirstPosition=numberArray[randomNumber];
        }
        buttonArray[0][cpuFirstPosition].setText("C");
        buttonArray[0][cpuFirstPosition].setEnabled(false);

    }
    public boolean isComputerFirstTurn(Button[][] gameBoard) {
        int numberOfPlayerPieces = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if (gameBoard[i][j].getText() == ("P")) {
                    numberOfPlayerPieces += 1;
                }//if
            }//inner for loop
        }// outer for loop
        if (numberOfPlayerPieces <= 1) {
            return true;
        } else {
            return false;
        }
    }//isCompterFirstTurn
        public int blockMoveReturnColsFirstOp (){
            for(int i = 0 ; i<=2 ; i++) {
                if (buttonArray[i][0].getText() == "P") {
                    if (buttonArray[i][1].getText() == "P") {
                        if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                            return 2;
                        }
                    }
                }
                if (buttonArray[i][2].getText() == "P") {
                    if (buttonArray[i][1].getText() == "P") {
                        if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                            return 0;
                        }
                    }
                }
                if(buttonArray[i][7].getText() == "P") {
                    if (buttonArray[i][6].getText() == "P") {
                        if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                            return 5;
                        }
                    }
                }
                if (buttonArray[i][5].getText() == "P") {
                    if (buttonArray[i][6].getText() == "P") {
                        if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                            return 7;
                        }
                    }
                }
        }//for loop
          return -1;
       }//blockMoveReturnCols
    public int blockMoveReturnColsSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return 5;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return 7;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return 2;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return 0;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnCols
    public int blockMoveReturnRowsFirstOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][1].getText() == "P") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "P") {
                if (buttonArray[i][1].getText() == "P") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][6].getText() == "P") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][6].getText() == "P") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnRows
    public int blockMoveReturnRowsSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnRows
    public boolean isBlockMoveFirstOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][1].getText() == "P") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "P") {
                if (buttonArray[i][1].getText() == "P") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return true;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][6].getText() == "P") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][6].getText() == "P") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove
    public boolean isBlockMoveSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        return true;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][4].getText() == "P") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][3].getText() == "P") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove
   public boolean isBlockMoveCrossLines1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
               if(buttonArray[1][numbersInList].getText()=="P") {
                 if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                         [numbersInList].getText()!="P"){
                     return true;
                 }
               }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
       return false;
   }
    public int blockMoveCrossLinesReturnRows1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
                if(buttonArray[1][numbersInList].getText()=="P") {
                    if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                            [numbersInList].getText()!="P"){
                        return 2;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public int blockMoveCrossLinesReturnCols1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
                if(buttonArray[1][numbersInList].getText()=="P") {
                    if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public boolean isBlockMoveCrossLines2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 3;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="P"){
                if(buttonArray[1][numbersInList].getText()=="P") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return true;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    public int blockMoveCrossLinesReturnRows2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 4;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="P"){
                if(buttonArray[1][numbersInList].getText()=="P") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return 0;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public int blockMoveCrossLinesReturnCols2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 4;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="P"){
                if(buttonArray[1][numbersInList].getText()=="P") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public boolean isBlockMoveInBetween(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][5].getText() == "P") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return true;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][7].getText() == "P") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockMoveInBetween
    public int blockMoveInBetweenReturnCol(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return 1;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][5].getText() == "P") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return 3;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return 4;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][7].getText() == "P") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return 6;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveInBetweenReturnCols
    public int blockMoveInBetweenReturnRow(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "P") {
                if (buttonArray[i][5].getText() == "P") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "P") {
                if (buttonArray[i][2].getText() == "P") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "P") {
                if (buttonArray[i][7].getText() == "P") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveInBetweenReturnRows
    public boolean isBlockMoveCrossLinesInBetween(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
                if(buttonArray[2][numbersInList].getText()=="P") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return true;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    public int blockMoveCrossLinesInBetweenReturnCol(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
                if(buttonArray[2][numbersInList].getText()=="P") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }//blockMoveCrossLinesInBetweenReturnCol
    public int blockMoveCrossLinesInBetweenReturnRow(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="P"){
                if(buttonArray[2][numbersInList].getText()=="P") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return 1;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }//blockMoveCrossLineInBetweenReturnRow
    ////////////////// Make a MIlllllll///////////////
    /////////////////////////////////
    public int makeMillReturnColsFirstOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return 2;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return 0;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return 5;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return 7;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnCols
    public int makeMillReturnColsSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return 5;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return 7;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return 2;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return 0;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnCols
    public int makeMillReturnRowsFirstOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnRows
    public int makeMillReturnRowsSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveReturnRows
    public boolean isMakeMillFirstOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][1].getText() == "C") {
                    if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if (buttonArray[i][5].getText() != "C" && buttonArray[i][5].getText() != "P") {
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][6].getText() == "C") {
                    if (buttonArray[i][7].getText() != "C" && buttonArray[i][7].getText() != "P") {
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove
    public boolean isMakeMillSecondOp (){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][5].getText() !="C" && buttonArray[i][5].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][2].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][7].getText() !="C" && buttonArray[i][7].getText()!="P"){
                        return true;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][4].getText() == "C") {
                    if(buttonArray[i][2].getText() !="C" && buttonArray[i][2].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][3].getText() == "C") {
                    if(buttonArray[i][0].getText() !="C" && buttonArray[i][0].getText()!="P"){
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockmove
    public boolean isMakeMillCrossLines1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                            [numbersInList].getText()!="P"){
                        return true;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    public int makeMillCrossLinesReturnRows1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                            [numbersInList].getText()!="P"){
                        return 2;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public int makeMillCrossLinesReturnCols1(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[2][numbersInList].getText()!= "C" && buttonArray[2]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public boolean isMakeMillCrossLines2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 3;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return true;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    public int makeMillCrossLinesReturnRows2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 4;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return 0;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public int makeMillCrossLinesReturnCols2(){
        int[] numberArray = {0,1,3,4,6,0};
        int numInListCounter= 4;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter>=1){
            if(buttonArray[2][numbersInList].getText()=="C"){
                if(buttonArray[1][numbersInList].getText()=="C") {
                    if(buttonArray[0][numbersInList].getText()!= "C" && buttonArray[0]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter-=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }
    public boolean isMakeMillInBetween(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][5].getText() == "C") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return true;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return true;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][7].getText() == "C") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return true;
                    }
                }
            }
        }//for loop
        return false;
    }//isblockMoveInBetween
    public int makeMillInBetweenReturnCol(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return 1;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][5].getText() == "C") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return 3;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return 4;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][7].getText() == "C") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return 6;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveInBetweenReturnCols
    public int makeMillInBetweenReturnRow(){
        for(int i = 0 ; i<=2 ; i++) {
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][1].getText() !="C" && buttonArray[i][1].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][0].getText() == "C") {
                if (buttonArray[i][5].getText() == "C") {
                    if(buttonArray[i][3].getText() !="C" && buttonArray[i][3].getText()!="P"){
                        return i;
                    }
                }
            }
            if(buttonArray[i][7].getText() == "C") {
                if (buttonArray[i][2].getText() == "C") {
                    if(buttonArray[i][4].getText() !="C" && buttonArray[i][4].getText()!="P"){
                        return i;
                    }
                }
            }
            if (buttonArray[i][5].getText() == "C") {
                if (buttonArray[i][7].getText() == "C") {
                    if(buttonArray[i][6].getText() !="C" && buttonArray[i][6].getText()!="P"){
                        return i;
                    }
                }
            }
        }//for loop
        return -1;
    }//blockMoveInBetweenReturnRows
    public boolean isMakeMillCrossLinesInBetween(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[2][numbersInList].getText()=="C") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return true;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return false;
    }
    public int makeMillCrossLinesInBetweenReturnCol(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[2][numbersInList].getText()=="C") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return numbersInList;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }//blockMoveCrossLinesInBetweenReturnCol
    public int makeMillCrossLinesInBetweenReturnRow(){
        int[] numberArray = {1,3,4,6,0};
        int numInListCounter= 0;
        int numbersInList= numberArray[numInListCounter];
        while(numInListCounter<4){
            if(buttonArray[0][numbersInList].getText()=="C"){
                if(buttonArray[2][numbersInList].getText()=="C") {
                    if(buttonArray[1][numbersInList].getText()!= "C" && buttonArray[1]
                            [numbersInList].getText()!="P"){
                        return 1;
                    }
                }
            }
            numInListCounter+=1;
            numbersInList=numberArray[numInListCounter];
        }//while loop
        return -1;
    }//blockMoveCrossLineInBetweenReturnRow
  /*  public boolean isTryingToMakeMillMiddleHorizonal() {
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i][1].getText() == "C") {
                if (buttonArray[i][0].getText() != "C" && buttonArray[i][0].getText()!="P") {
                    buttonArray[i][0].setText("C");
                }
                else if (buttonArray[i][2].getText() != "C" && buttonArray[i][2].getText()!="P"){
                    buttonArray[i][2].setText("C");
                }
            }

        }
        return false
    }*/

}//end of file
    


