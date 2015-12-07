package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Javi on 07/12/15.
 */
public class GestioTaulers extends JFrame {
  private JButton Back;
  private JButton esborrarTaulerButton;
  private JButton modificarTaulerButton;
  private JButton Crear;
  private JPanel Taulers;

  public GestioTaulers(Options ant) {
    setContentPane(Taulers);
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
    Crear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    modificarTaulerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    esborrarTaulerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
  }
}
