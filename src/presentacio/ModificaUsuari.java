package presentacio;

import domini.CtrlDomini;
import domini.Usuari.CtrlUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xavi on 05/12/2015.
 */
public class ModificaUsuari extends JFrame {
  private JPanel GestioUsuari;
  private JButton Back;
  private JPasswordField Vell;
  private JPasswordField Nou;
  private JPasswordField Nou2;
  private JButton OK;
  private JLabel Current;
  private JLabel New;
  private JLabel NewRep;

  public ModificaUsuari(GestioUsuaris ant, String usr) {
    setContentPane(GestioUsuari);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    new CtrlUser();
    Back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
    OK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String vell = String.valueOf(Vell.getPassword());
        String nou = String.valueOf(Nou.getPassword());
        String nou2 = String.valueOf(Nou2.getPassword());
        if (vell.equals("")) {
          JOptionPane.showMessageDialog(Vell, "Entra el teu password actual!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!vell.equals(CtrlDomini.getPassword(usr))) {
          JOptionPane.showMessageDialog(Nou2, "El password actual introduït no és el correcte!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nou.equals("")) {
          JOptionPane.showMessageDialog(Nou, "Entra el password nou!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nou2.equals("")) {
          JOptionPane.showMessageDialog(Nou2, "Entra el duplicat del password nou!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!nou.equals(nou2)) {
          JOptionPane.showMessageDialog(Nou2, "El password nou i el seu duplicat no són iguals!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          CtrlUser.modificaUsuari(usr, usr, nou);
          setVisible(false);
          ant.setVisible(true);
        }
      }
    });
  }
}
