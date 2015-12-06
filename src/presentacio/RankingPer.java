package presentacio;

import domini.Ranking.RankingPersonal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;

/**
 * Created by MAX on 06/12/2015.
 */
public class RankingPer extends JFrame {
    private JButton enrereButton;
    private JPanel RP;
    private JComboBox TriaDiff;
    private JLabel nPartides;
    private JLabel nPistes;
    private JLabel Temps;

    public RankingPer (Ranking ant, String usr){
        setContentPane(RP);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        RankingPersonal rp = new RankingPersonal(usr);
        int n = rp.getResolts();
        String s = Integer.toString(n);
        nPartides.setText(s);
        double m = rp.getPistes();
        s = Double.toString(m);
        nPistes.setText(s);
        Temps.setText(" ");

        TriaDiff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = TriaDiff.getSelectedIndex();
                double m;
                String s;
                if (i == 1) {
                    if (rp.getBestTime("facil") != null) {
                        m = rp.getBestTime("facil");
                        s = Double.toString(m);
                        Temps.setText(s);
                    } else Temps.setText("0.0");
                } else if (i == 2) {
                    if (rp.getBestTime("medio") != null) {
                        m = rp.getBestTime("medio");
                        s = Double.toString(m);
                        Temps.setText(s);
                    } else Temps.setText("0.0");
                } else if (i == 3) {
                    if (rp.getBestTime("dificil") != null) {
                        m = rp.getBestTime("dificil");
                        s = Double.toString(m);
                        Temps.setText(s);
                    } else Temps.setText("0.0");
                }
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
