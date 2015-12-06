package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xavi on 05/12/2015.
 */
public class Options extends JFrame {
  private JButton Taulers;
  private JButton ModificaUsuari;
  private JPanel Options;
  private JButton Back;
  private Options actual;

  public Options(String usr, String pwd, MenuPrincipal ant) {
    setContentPane(Options);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    actual = this;
    Taulers.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // passar a una finestra on crear, modificar o esborrar taulers
      }
    });
    ModificaUsuari.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ModificaUsuari GU = new ModificaUsuari(actual, usr, pwd);
        setVisible(false);
      }
    });
    Back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
  }
}
