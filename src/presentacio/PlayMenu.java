package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josep on 12/14/15.
 */
public class PlayMenu extends JFrame{
    private JButton partidaNormalButton;
    private JButton partidaMàquinaButton;
    private JButton enrereButton;
    private JPanel PM;
    private PlayMenu actual;

    public PlayMenu(MenuPrincipal ant, String usr) {
        setContentPane(PM);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        partidaNormalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionaTauler s = new SeleccionaTauler(actual,usr,2);
                s.setVisible(true);
                setVisible(false);
            }
        });
        partidaMàquinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionaTauler s = new SeleccionaTauler(actual,usr,3);
                s.setVisible(true);
                setVisible(false);
            }
        });
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ant.setVisible(true);
                setVisible(false);
            }
        });
    }
}
