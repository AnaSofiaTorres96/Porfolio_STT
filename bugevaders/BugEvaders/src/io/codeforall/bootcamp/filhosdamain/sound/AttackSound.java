
package io.codeforall.bootcamp.filhosdamain.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AttackSound implements Runnable{

    private Clip backgroundMusic;

    public AttackSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream backgroundMusicStream = AudioSystem.getAudioInputStream(new File("BugEvaders/resources/explosionSound.mp3").getAbsoluteFile());
        backgroundMusic = AudioSystem.getClip();
        backgroundMusic.open(backgroundMusicStream);
        FloatControl gainControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }


    @Override
    public void run() {
        backgroundMusic.start();
        try{
            Thread.sleep(1000000);
        } catch (Exception e) {

        }
    }
}
