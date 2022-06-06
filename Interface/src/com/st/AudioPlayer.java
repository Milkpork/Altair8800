package com.st;

import javax.sound.sampled.*;
import java.net.URL;


public class AudioPlayer {
    String defaultURL = "file:/" + System.getProperty("user.dir") + "/material/14312.wav";
//    String defaultURL2 = "file:/E:/Java/IDE/Altair8800/material/14312.wav";
    Clip clip;
    URL file;
    AudioInputStream ais;

    public AudioPlayer(String url) throws Exception {
        file = new URL(url);
        ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

    public AudioPlayer() throws Exception {
        file = new URL(this.defaultURL);
        ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
