package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MAX on 15/12/2015.
 */
public class Fi extends JFrame {

  private JPanel F;

  private JLabel temps;
  private JLabel pistes;
  private JButton AceptarButton;
  private JPanelBackground Fifoto;

  public Fi(double p, double t) {
    setContentPane(Fifoto);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    setSize(400, 400);
    setLocationRelativeTo(null);
    Fifoto.setBackground("src/foto1.jpg");
    temps.setText(Double.toString(t));
    pistes.setText(Double.toString(p));
    AceptarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
  }
}