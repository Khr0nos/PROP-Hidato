package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xavi on 05/12/2015.
 */
public class GestioUsuaris extends JFrame {
  private JPanel GestioUsuaris;
  private JButton Back;
  private JTable Usuaris;

  public GestioUsuaris(Options ant) {
    setContentPane(GestioUsuaris);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    Back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
  }
  //Modificar la Jtable per a mostrar i poder editar usuaris
}
