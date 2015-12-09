package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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
    private String f = "0";
    private String c = "0";
    private String id;
    private DefaultTableModel model;

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
                if (!Objects.equals(f, "0") && !Objects.equals(c, "0")) {
                    int n = Integer.parseInt(f);
                    int m = Integer.parseInt(c);
                    ArrayList<Integer> t = new ArrayList<Integer>();

                    for (int i = 0; i < n; ++i){
                        for(int j = 0; j < m; ++j){
                            int x = Integer.parseInt(model.getValueAt(i,j).toString());
                            t.add(i*m+j,x);
                        }
                    }
                    boolean ret = CtrlDomini.generarHidatoUser(n,m,usr,t,id);
                    if (!ret) JOptionPane.showMessageDialog(generarElTaulerButton, "Tauler incorrecte", "Error", JOptionPane.ERROR_MESSAGE);
                }
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

