package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.Vector;

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
    Vector<Vector<String>> valors = CtrlDomini.getDadesUsuaris();
    Vector<String> cols = new Vector<String>(2);
    cols.add("Username");
    cols.add("Password");
    Usuaris = new JTable(valors, cols);
    //Falta veure com fer que la taula mostri la info adequadament
    Back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ant.setVisible(true);
      }
    });
  }

  //Modificar la Jtable per a mostrar i poder editar usuaris a través del CtrlDomini
}
