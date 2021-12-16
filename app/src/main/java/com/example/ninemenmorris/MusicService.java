package com.example.ninemenmorris;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

public class MusicService extends AppCompatActivity {
    public static MediaPlayer audioMusic;
    public static String audioStatus;
    public static int musicInitialize = 1;

    public static void startAudio(){
        audioMusic.setLooping(true);
        setMuteStatus("unmuted");
        audioMusic.start();
    }

    public static void setMuteStatus(String status){
        audioStatus = status;
        if (audioStatus == "muted"){
            audioMusic.setVolume(0,0);
        }
        else if (audioStatus == "unmuted"){
            audioMusic.setVolume(1,1);
        }
    }

    public static String getMuteStatus(){
        return audioStatus;
    }


}
