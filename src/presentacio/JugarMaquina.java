package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 15/12/2015.
 */
public class JugarMaquina extends JFrame {
    private JPanel JM;
    private Tauler T;
    private JButton Enrere;

    public JugarMaquina(SeleccionaTauler ant,String idtau){
        JM = new JPanel(new BorderLayout());
        setContentPane(JM);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        T = new Tauler(idtau);
        add(T,BorderLayout.CENTER);
        T.resolTauler(idtau);
        Enrere = new JButton();
        Enrere.setText("Enrere");
        add(Enrere,BorderLayout.SOUTH);
        Enrere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ant.setVisible(true);
                setVisible(false);
            }
        });
    }
}
