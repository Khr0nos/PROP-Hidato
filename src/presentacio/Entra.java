package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 01/12/2015.
 */
public class Entra extends JFrame{
    private JPanel panel1;
    private JButton entraButton;

    public Entra(){
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        entraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loggin l = new Loggin();
                setVisible(false);
            }
        });
    }
}
