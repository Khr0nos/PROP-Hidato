package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 08/12/2015.
 */
public class Crear extends JFrame {
    private JButton crearTaulerManualmentButton;
    private JButton crearTaulerAleatoriamentButton;
    private JButton enrereButton;
    private JPanel C;
    Crear actual;
    public Crear(GestioTaulers ant, String usr){
        setContentPane(C);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        crearTaulerAleatoriamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearMaquina cm = new CrearMaquina(actual);
                setVisible(false);
            }
        });
        crearTaulerManualmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUsuari cu = new CrearUsuari(actual,usr);
                setVisible(false);
            }
        });
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
    }
}
