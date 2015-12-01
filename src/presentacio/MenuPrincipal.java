package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 01/12/2015.
 */
public class MenuPrincipal extends JFrame {
    private JButton playButton;
    private JButton rankingButton;
    private JButton optionsButton;
    private JButton exitButton;
    private JPanel MP;

    public MenuPrincipal(){
        setContentPane(MP);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
