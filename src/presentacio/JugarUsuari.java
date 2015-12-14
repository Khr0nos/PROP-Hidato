package presentacio;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MAX on 14/12/2015.
 */
public class JugarUsuari extends JFrame {

    private JPanel JU;
    private Tauler T;

    public JugarUsuari(SeleccionaTauler ant,String usr,String idtau ){
        setContentPane(JU);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        T = new Tauler(idtau);
        setVisible(false);
    }
}
