package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
    private JTable Resultat;
    private JButton descartaButton;
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
                    if (x == 1) diff = "facil";
                    else if (x == 2) diff = "medio";
                    else if (x == 3) diff = "dificl";
                    id = Idtau.getText();
                    int n = Integer.parseInt(f);
                    int m = Integer.parseInt(c);
                    CtrlDomini.generarHidato(n, m, diff, id);
                    ArrayList<Integer> th = CtrlDomini.getTaulerHid(id);
                    DefaultTableModel model = new DefaultTableModel(0,2);
                    model.setColumnCount(m);
                    model.setRowCount(n);
                    for (int i = 0; i < n; ++i){
                        for (int j = 0; j < m; ++j) {
                            model.setValueAt(th.get(i * m + j), i, j);
                        }
                    }
                    Resultat.setModel(model);
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
