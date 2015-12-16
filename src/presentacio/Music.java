package presentacio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by llistoman on 9/12/15.
 */
public class Music {
    private static File file;
    private static boolean on;
    private static Clip clip;

    public Music() {
        try {
            file = new File("src/music.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            on = false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play() {
        try {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            on = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void stop() {
        clip.stop();
        on = false;
    }
    public static boolean getOn() { return on; }
}
