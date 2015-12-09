package presentacio;

import domini.CtrlDomini;
import domini.Usuari.CtrlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 09/12/2015.
 */
public class GestioUsuaris extends JFrame {

    private JPanel GU;
    private JButton CanviaContrassenyaButton;
    private JButton esborraUsuariButton;
    private JButton Enrere;
    private GestioUsuaris actual;

    public  GestioUsuaris(Options ant,String usr) {
        setContentPane(GU);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        actual = this;
        CanviaContrassenyaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaUsuari GU = new ModificaUsuari(actual, usr);
                setVisible(false);
            }
        });
        esborraUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcions = {"Si", "No"};
                int n = JOptionPane.showOptionDialog(actual,
                        "ATENCIÓ!\n" + "Estas apunt d'esborrar el teu usuari.\n" +
                                "Els teus taulers continuaran existint per altres usuaris.\n" +
                                "Les teves partides guardades s'esborraran.\n" +
                                "Estas segur que vols continuar?", "Esborra Usuari", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
                if (n == JOptionPane.YES_OPTION) {
                    CtrlUser.esborraUsuari(usr);
                    CtrlDomini.esborraPartides(usr);
                    setVisible(false);
                    dispose();
                    Loging l = new Loging();
                }
            }
        });
        Enrere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ant.setVisible(true);
                setVisible(false);
            }
        });
    }
}
