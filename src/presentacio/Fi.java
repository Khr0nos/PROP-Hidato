package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 15/12/2015.
 */
public class Fi extends JFrame{

    private JPanel F;
    private JLabel temps;
    private JLabel pistes;
    private JButton Aceptar;

    public Fi(double p, double t){
        setContentPane(F);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        temps.setText(Double.toString(t));
        pistes.setText(Double.toString(p));
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
