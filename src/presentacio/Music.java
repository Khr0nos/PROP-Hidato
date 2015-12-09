package presentacio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by llistoman on 9/12/15.
 */
public class Music {
    private File file;

    public Music() {
        file = new File("src/music.wav");
    }

    public void play() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
