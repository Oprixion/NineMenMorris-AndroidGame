package com.example.ninemenmorris;

import android.widget.Button;

import java.util.Random;

public class Tester {
    public void setDifficultyFirstPhase(int difficulty){
        Random random = new Random();
        int percentageOfDifficulity = random.nextInt(10);
        if (difficulty==1) {
            if (percentageOfDifficulity == 0 || percentageOfDifficulity == 1) {
               System.out.println("Easy");
            }
            else{
                System.out.println("Random");
            }
        }
        else if(difficulty==2){
            if(percentageOfDifficulity==0 || percentageOfDifficulity==1 || percentageOfDifficulity==2
                    || percentageOfDifficulity == 3 || percentageOfDifficulity==4){
                System.out.println("Medium");
            }
            else{
                System.out.println("Random");
            }
        }
        else if (difficulty==3){
            if(percentageOfDifficulity==0 || percentageOfDifficulity==1 || percentageOfDifficulity==2
                    || percentageOfDifficulity == 3 || percentageOfDifficulity==4 || percentageOfDifficulity==5
                    || percentageOfDifficulity==6 || percentageOfDifficulity==7
                    || percentageOfDifficulity == 8 || percentageOfDifficulity==9){
                System.out.println("Hard");
            }
            else{
                System.out.println("Random");;
            }
        }
    }
}
