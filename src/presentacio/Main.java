package presentacio;

import javax.swing.*;

/**
 * Created by MAX on 01/12/2015.
 */
public class Main {
    public static void main(String arg[]) {
        Music m = new Music();
        m.play();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EntraFoto();
            }
        });
    }
}
