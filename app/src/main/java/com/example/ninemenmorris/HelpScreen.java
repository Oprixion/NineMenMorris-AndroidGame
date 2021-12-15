package com.example.ninemenmorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpScreen extends AppCompatActivity {

    String[] tutorialScreenNames = {"BASICS", "HOW TO WIN", "1st PHASE", "2nd PHASE", "3rd PHASE"};
    int tutorialCurrentScreen = 0;
    int tutorialScreenMax = 4;

    //Int arrays with the resource ids corrosponding to each screen
    int[] basicsScreenResources = {R.id.basicsBlueToken, R.id.basicsPvc, R.id.basicsPvp,
            R.id.basicsRedToken, R.id.basicsExplain};
    int[] winningScreenResources = {R.id.winningBoard, R.id.winningCapture, R.id.winningExplain1,
            R.id.winningExplain2, R.id.winningToken1, R.id.winningToken2, R.id.winningToken3};
    int[] phaseOneScreenResources = {R.id.firstPhaseExplain, R.id.firstPhasePlace};
    int[] phaseTwoScreenResources = {R.id.secondPhaseBlueToken, R.id.secondPhaseExplain,
            R.id.secondPhaseMove, R.id.secondPhaseWhiteToken, R.id.secondPhaseBoardConnector};
    int[] phaseThreeScreenResources = {R.id.thirdPhaseBlue, R.id.thirdPhaseWins,
            R.id.thirdPhaseExplain};

    int[][] tutorialScreenResources = {basicsScreenResources, winningScreenResources,
            phaseOneScreenResources, phaseTwoScreenResources, phaseThreeScreenResources};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

    }
    public void goBackHome(View myView){
        Intent goHome = new Intent(this, StartScreen.class);
        startActivity(goHome);
        this.finish();
    }
    public void tutorialScreenShift(View myView){
        //Shifts number left or right based input button
        int lastScreen = tutorialCurrentScreen;
        if(myView.getId() == R.id.buttonLeft){
            //LEFT ARROW BUTTON
            if(tutorialCurrentScreen == 0){
                //Loops to final if at start
                tutorialCurrentScreen = tutorialScreenMax;
            }
            else{
                tutorialCurrentScreen += -1;
            }
        }
        else{
            //RIGHT ARROW BUTTON
            if(tutorialCurrentScreen == tutorialScreenMax){
                //Loops to start if at final
                tutorialCurrentScreen = 0;
            }
            else{
                tutorialCurrentScreen += 1;
            }
        }

        TextView displayCurrentTutorial = (TextView) findViewById(R.id.currentTutorial);
        displayCurrentTutorial.setText(tutorialScreenNames[tutorialCurrentScreen]);

        //Turn previous screen invisible
        for(int asset = 0; asset < tutorialScreenResources[lastScreen].length; asset++){
            View selectedAsset = (View) findViewById(tutorialScreenResources[lastScreen][asset]);
            selectedAsset.setAlpha(0);
        }
        //Turn desired screen visible
        for(int asset = 0; asset < tutorialScreenResources[tutorialCurrentScreen].length; asset++){
            View selectedAsset = (View) findViewById(tutorialScreenResources[tutorialCurrentScreen][asset]);
            selectedAsset.setAlpha(1);
        }
    }
}