package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by MAX on 08/12/2015.
 */
public class CrearMaquina extends JFrame {
    private JPanel C;
    private JTextField Fils;
    private JTextField Cols;
    private JTextField Idtau;
    private JComboBox TriaDiff;
    private JButton generaElTaulerButton;
    private JButton guardarButton;
    private JButton descartaButton;
    private JTable Resultat;
    private String id = null;

    public CrearMaquina(Crear ant) {
        setContentPane(C);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        generaElTaulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String f = Fils.getText();
                    String c = Cols.getText();
                    String diff = "facil";
                    int x = TriaDiff.getSelectedIndex();
                    id = Idtau.getText();
                    if (f.equals("")) {
                        JOptionPane.showMessageDialog(Fils, "Entra el nombre de files!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (c.equals("")) {
                        JOptionPane.showMessageDialog(Cols, "Entra el nombre de columnes!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (id.equals("")) {
                        JOptionPane.showMessageDialog(Cols, "Entra el nom del tauler!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (x == 0) {
                        JOptionPane.showMessageDialog(TriaDiff, "Selecciona una dificultat!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (x == 1) diff = "facil";
                        else if (x == 2) diff = "medio";
                        else if (x == 3) diff = "dificl";
                        id = Idtau.getText();
                        int n = Integer.parseInt(f);
                        int m = Integer.parseInt(c);
                        CtrlDomini.generarHidato(n, m, diff, id);
                        ArrayList<Integer> th = CtrlDomini.getTaulerHid(id);
                        DefaultTableModel model = new DefaultTableModel() {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        model.setColumnCount(m);
                        model.setRowCount(n);
                        for (int i = 0; i < n; ++i) {
                            for (int j = 0; j < m; ++j) {
                                model.setValueAt(th.get(i * m + j), i, j);
                            }
                        }
                        Resultat.setModel(model);
                        /*for (int i = 0; i < Integer.parseInt(f); i++) {
                            for (int j = 0; j < Integer.parseInt(c); j++) {
                                //Resultat.prepareRenderer(Resultat.getCellRenderer(i,j), i, j);
                                Resultat.getCellRenderer(i,j).getTableCellRendererComponent(Resultat,"",false,false,i,j);
                                if (Resultat.getModel().getValueAt(i,j).equals("0")) Resultat.getModel().setValueAt("", i, j);
                            }
                        }*/
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
        descartaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlDomini.esborraTauler(id);
                setVisible(false);
                ant.setVisible(true);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
    }
}
