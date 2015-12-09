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
public class Options extends JFrame {
  private JPanel Options;
  private JButton Taulers;
  private JButton Usuaris;
  private JButton Enrere;
  private Options actual;

  public Options(String usr, MenuPrincipal ant) {
    setContentPane(Options);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    actual = this;
    Taulers.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GestioTaulers GT = new GestioTaulers(actual,usr);
        setVisible(false);
      }
    });
    Usuaris.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GestioUsuaris GU = new GestioUsuaris(actual,usr);
        setVisible(false);
      }
    });

    Enrere.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
  }
}
