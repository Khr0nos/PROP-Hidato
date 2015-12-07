package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by josep on 12/7/15.
 */
public class RankingTipus extends JFrame {

    private JLabel label1;
    private JComboBox dificultat;
    private JComboBox entrades;
    private JPanel RT;
    private JLabel label2;
    private JButton enrereButton;
    private JTable table;
    private DefaultTableModel model;
    private int rows = 0;
    private String dif = "facil";


    public RankingTipus(Ranking ant) {
        setContentPane(RT);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        model = new DefaultTableModel(0,2);

        dificultat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int j = dificultat.getSelectedIndex();
                if (j == 0) dif = "facil";
                else if (j == 1) dif = "medio";
                else if (j == 2) dif = "dificil";

                CtrlDomini.inicialitzaRankingTipus(dif,rows);
                Object[] colNames = {"Usuari","Temps"};
                int x;
                if (CtrlDomini.getNEntrades() < rows) x = CtrlDomini.getNEntrades();
                else x = rows;
                model.setRowCount(x);
                model.setColumnIdentifiers(colNames);
                for (int i = 0; i < x; ++i) {
                    model.setValueAt(CtrlDomini.getEntradaUsuari(i),i,0);
                    model.setValueAt(CtrlDomini.getEntradaTemps(i),i,1);
                }
                table.setModel(model);
            }
        });
        entrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rows = entrades.getSelectedIndex();

                CtrlDomini.inicialitzaRankingTipus(dif,rows);
                Object[] colNames = {"Usuari","Temps"};
                int x;
                if (CtrlDomini.getNEntrades() < rows) x = CtrlDomini.getNEntrades();
                else x = rows;
                model.setRowCount(x);
                model.setColumnIdentifiers(colNames);
                for (int i = 0; i < x; ++i) {
                    model.setValueAt(CtrlDomini.getEntradaUsuari(i),i,0);
                    model.setValueAt(CtrlDomini.getEntradaTemps(i),i,1);
                }
                table.setModel(model);
            }
        });
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ant.setVisible(true);
            }
        });
    }
}
