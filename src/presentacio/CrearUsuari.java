package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by MAX on 09/12/2015.
 */
public class CrearUsuari extends JFrame {
  private JPanel C;
  private JTextField Fils;
  private JTextField Cols;
  private JTextField Idtau;
  private JButton generarPlantillaButton;
  private JTable Tauler;
  private JButton enrereButton;
  private JButton guardarButton;
  private JLabel labelTauler;
  private String f = "0";
  private String c = "0";
  private String id = null;
  private DefaultTableModel model;

  public CrearUsuari(Crear ant, String usr) {
    setContentPane(C);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    Tauler.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    generarPlantillaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          f = Fils.getText();
          c = Cols.getText();
          id = Idtau.getText();
          if (id.equals("")) {
            JOptionPane.showMessageDialog(Cols, "Entra el nom del tauler!", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (CtrlDomini.checkIdtauler(id)) {
            JOptionPane.showMessageDialog(Idtau, "Nom de tauler ja existent", "Identificador incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (f.equals("")) {
            JOptionPane.showMessageDialog(Fils, "Entra el nombre de files!", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (c.equals("")) {
            JOptionPane.showMessageDialog(Cols, "Entra el nombre de columnes!", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (Integer.parseInt(f) < 3) {
            JOptionPane.showMessageDialog(Fils, "Mínim nombre de files: 3", "Nombre files incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(c) < 3) {
            JOptionPane.showMessageDialog(Cols, "Mínim nombre de columnes: 3", "Nombre columnes incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(f) > 20) {
            JOptionPane.showMessageDialog(Fils, "Màxim nombre de files: 20", "Nombre files incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(c) > 20) {
            JOptionPane.showMessageDialog(Fils, "Màxim nombre de columnes: 20", "Nombre columnes incorrecte", JOptionPane.WARNING_MESSAGE);
          } else {
            int n = Integer.parseInt(f);
            int m = Integer.parseInt(c);
            model = new DefaultTableModel(n, m);
            for (int i = 0; i < n; ++i) {
              for (int j = 0; j < m; ++j) {
                model.setValueAt("0", i, j);
              }
            }
            Tauler.setModel(model);
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    guardarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Tauler.clearSelection();
        if (!Objects.equals(f, "0") && !Objects.equals(c, "0") && teValors(model)) {
          int n = Integer.parseInt(f);
          int m = Integer.parseInt(c);
          //ArrayList<Integer> t = new ArrayList<Integer>();
          CtrlDomini.iniTaulerHidato(n, m, usr);
          for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
              int x = Integer.parseInt(model.getValueAt(i, j).toString()); //problema amb el model al guardar valors
              CtrlDomini.setValorAt(i, j, x);
              if (x > 0) CtrlDomini.setFixedAt(i, j);
            }
          }
          boolean b = CtrlDomini.checkIdtauler(id);
          if (!b) {
            boolean ret = CtrlDomini.guardarHidato(id);
            if (!ret)
              JOptionPane.showMessageDialog(guardarButton, "Tauler incorrecte!", "Error", JOptionPane.ERROR_MESSAGE);
            else {
              CtrlDomini.guardaReferenciaTauler(id);
              JOptionPane.showMessageDialog(guardarButton, "Tauler generat correctament.", "OK", JOptionPane.INFORMATION_MESSAGE);
              setVisible(false);
              ant.setVisible(true);
            }
          } else
            JOptionPane.showMessageDialog(guardarButton, "El ID del tauler ja existeix.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    enrereButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] opcions = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(enrereButton,
                "ATENCIÓ!\n" + "Tots els canvis que no hagis guardat es perdran.\n" +
                        "Estas segur que vols sortir?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
        if (n == JOptionPane.YES_OPTION) {
          CtrlDomini.iniTaulerHidato(0, 0, "maquina");
          setVisible(false);
          ant.setVisible(true);
        }
      }
    });
  }

  public CrearUsuari(SeleccionaTauler ant, String usr, String identificador) {
    setContentPane(C);
    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    CtrlDomini.carregaTaulerHidato(identificador);
    Fils.setText(String.valueOf(CtrlDomini.getFiles()));
    Cols.setText(String.valueOf(CtrlDomini.getColumnes()));
    Idtau.setText(identificador);
    Idtau.setVisible(false);
    labelTauler.setVisible(false);
    f = Fils.getText();
    c = Cols.getText();
    id = identificador;
    model = new DefaultTableModel(CtrlDomini.getFiles(), CtrlDomini.getColumnes());
    for (int i = 0; i < CtrlDomini.getFiles(); ++i) {
      for (int j = 0; j < CtrlDomini.getColumnes(); ++j) {
        model.setValueAt(String.valueOf(CtrlDomini.getValorAt(i, j)), i, j);
      }
    }
    Tauler.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    Tauler.setModel(model);
    generarPlantillaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          f = Fils.getText();
          c = Cols.getText();
          id = identificador;
          if (f.equals("")) {
            JOptionPane.showMessageDialog(Fils, "Entra el nombre de files!", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (c.equals("")) {
            JOptionPane.showMessageDialog(Cols, "Entra el nombre de columnes!", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (Integer.parseInt(f) < 3) {
            JOptionPane.showMessageDialog(Fils, "Mínim nombre de files: 3", "Nombre files incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(c) < 3) {
            JOptionPane.showMessageDialog(Cols, "Mínim nombre de columnes: 3", "Nombre columnes incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(f) > 20) {
            JOptionPane.showMessageDialog(Fils, "Màxim nombre de files: 20", "Nombre files incorrecte", JOptionPane.WARNING_MESSAGE);
          } else if (Integer.parseInt(c) > 20) {
            JOptionPane.showMessageDialog(Fils, "Màxim nombre de columnes: 20", "Nombre columnes incorrecte", JOptionPane.WARNING_MESSAGE);
          } else {
            int n = Integer.parseInt(f);
            int m = Integer.parseInt(c);
            model = new DefaultTableModel(n, m);
            for (int i = 0; i < n; ++i) {
              for (int j = 0; j < m; ++j) {
                model.setValueAt("0", i, j);
              }
            }
            Tauler.setModel(model);
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    guardarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!Objects.equals(f, "0") && !Objects.equals(c, "0") && teValors(model)) {
          Tauler.clearSelection();
          int n = Integer.parseInt(f);
          int m = Integer.parseInt(c);
          //ArrayList<Integer> t = new ArrayList<Integer>();
          CtrlDomini.iniTaulerHidato(n, m, usr);
          for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
              int x = Integer.parseInt(model.getValueAt(i, j).toString()); //problema amb el model al guardar valors
              CtrlDomini.setValorAt(i, j, x);
              if (x > 0) CtrlDomini.setFixedAt(i, j);
            }
          }
          boolean ret = CtrlDomini.guardarHidato(id);
          if (!ret)
            JOptionPane.showMessageDialog(guardarButton, "Tauler incorrecte!", "Error", JOptionPane.ERROR_MESSAGE);
          else {
            JOptionPane.showMessageDialog(guardarButton, "Tauler modificat correctament.", "OK", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            ant.setVisible(true);
          }
        }
      }
    });
    enrereButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] opcions = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(enrereButton,
                "ATENCIÓ!\n" + "Tots els canvis que no hagis guardat es perdran.\n" +
                        "Estas segur que vols sortir?", "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
        if (n == JOptionPane.YES_OPTION) {
          CtrlDomini.iniTaulerHidato(0, 0, "maquina");
          setVisible(false);
          ant.setVisible(true);
        }
      }
    });
  }

  private boolean teValors(DefaultTableModel model) {
    for (int i = 0; i < model.getRowCount(); i++) {
      for (int j = 0; j < model.getColumnCount(); j++) {
        if (((Vector) model.getDataVector().elementAt(i)).elementAt(j).equals("1"))
          return true;
      }
    }
    return false;
  }
}
