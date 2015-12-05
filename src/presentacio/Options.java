package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xavi on 05/12/2015.
 */
public class Options extends JFrame {
  private JButton Taulers;
  private JButton Usuaris;
  private JPanel Options;
  private JButton Back;
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
        // passar a una finestra on crear, modificar o esborrar taulers
      }
    });
    Usuaris.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GestioUsuaris GU = new GestioUsuaris(actual);
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
