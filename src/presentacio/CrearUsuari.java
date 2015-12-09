package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton descartarButton;
    private JButton guardarButton;
    private JButton generarElTaulerButton;
    String f;
    String c;
    String id;
    DefaultTableModel model;

    public CrearUsuari(Crear ant, String usr){
        setContentPane(C);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        generarPlantillaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f = Fils.getText();
                    c = Cols.getText();
                    id = Idtau.getText();
                    if (f.equals("")) {
                        JOptionPane.showMessageDialog(Fils, "Entra el nombre de files!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (c.equals("")) {
                        JOptionPane.showMessageDialog(Cols, "Entra el nombre de columnes!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (id.equals("")) {
                        JOptionPane.showMessageDialog(Cols, "Entra el nom del tauler!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int n = Integer.parseInt(f);
                        int m = Integer.parseInt(c);
                        model = new DefaultTableModel(0, 2);
                        model.setColumnCount(m);
                        model.setRowCount(n);
                        for (int i = 0; i < n; ++i) {
                            for (int j = 0; j < m; ++j) {
                                model.setValueAt("", i, j);
                            }
                        }
                        Tauler.setModel(model);
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        generarElTaulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(f);
                int m = Integer.parseInt(c);
                ArrayList<Integer> t = new ArrayList<Integer>();

                for (int i = 0; i < n; ++i){
                    for(int j = 0; j < m; ++j){
                        String s = (String)model.getValueAt(i,j);
                        Integer x = Integer.parseInt(s);
                        t.add(i*m+j,x);
                    }
                }
                CtrlDomini.generarHidatoUser(n,m,usr,t,id);

            }
        });
        descartarButton.addActionListener(new ActionListener() {
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

